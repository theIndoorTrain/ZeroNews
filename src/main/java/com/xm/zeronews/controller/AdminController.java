package com.xm.zeronews.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xm.zeronews.dto.DtoMapper;
import com.xm.zeronews.dto.UserDto;
import com.xm.zeronews.pojo.User;
import com.xm.zeronews.service.MailService;
import com.xm.zeronews.service.MsgService;
import com.xm.zeronews.service.UserService;
import com.xm.zeronews.util.CodeUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Api(value="AdminController",tags="系统管理")
@CrossOrigin
@RestController
public class AdminController {

    @Autowired
    private DtoMapper mapper;
    @Autowired
    private UserService userService;
    @Autowired
    private MailService mailService;
    @Autowired
    private MsgService msgService;

    @ApiOperation(value="用户登录")
    @PostMapping("/doLogin")
    public String doLogin(@RequestBody UserDto userDto) {
        if(null != userDto) {
            User user = mapper.dtoToUser(userDto);
            String email = user.getEmail()+","+user.getType();
            UsernamePasswordToken token = new UsernamePasswordToken(email,user.getPassword());
            Subject currentUser = SecurityUtils.getSubject();
            try {
                currentUser.login(token);
            } catch (Exception e) {
                return null;
            }

            return (String) currentUser.getSession().getId();
        }
        return null;
    }

    @ApiOperation(value="用户登出")
    @GetMapping("/doLogout")
    public void doLogout() {
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
    }

    @ApiOperation(value="提交用户信息")
    @PostMapping("/submit")
    public boolean sighIn(@RequestBody UserDto userDto) {

        //查询email和code是否存在
        if(null != userDto) {
            User user = userService.getOne(new QueryWrapper<User>().eq("email",userDto.getEmail()).eq("code",userDto.getCode()));
            if(user != null) {
                user.setPassword(userDto.getPassword());
                if(!user.getIsActive()) {
                    user.setIsActive(true);
                    user.setCreateTime(LocalDateTime.now());
                    msgService.createWelcome(user.getId());
                }
                userService.updateById(user);
                return true;
            }
        }
        return false;
    }

    @ApiOperation(value="用户注册获取验证码")
    @GetMapping("/sighIn/{email}")
    public boolean getCodeBySighIn(@PathVariable String email) {
        //1.查询是否有此账号

        if(null != userService.getOne(new QueryWrapper<User>().eq("email",email))) {
            return false;
        }
        //没有的话创建
        User user = new User();
        user.setEmail(email);
        //有的话修改验证码
        String code = CodeUtil.getCode();
        user.setCode(code);
        userService.save(user);
        //发送邮箱
        mailService.sendCode(code,email);
        return true;
    }

    @ApiOperation(value="用户找回密码获取验证码")
    @GetMapping("/forget/{email}")
    public boolean getCodeByForget(@PathVariable String email) {
        //1.查询是否有此账号
        User user = userService.getOne(new QueryWrapper<User>().eq("email",email));
        if(null == user) {
            return false;
        }
        //有的话修改验证码
        String code = CodeUtil.getCode();
        user.setCode(code);
        userService.updateById(user);
        //发送邮箱
        mailService.sendCode(code,email);
        return true;
    }
}
