package com.xm.zeronews.controller;


import com.xm.zeronews.dto.DtoMapper;
import com.xm.zeronews.dto.UserDto;
import com.xm.zeronews.pojo.User;
import com.xm.zeronews.service.UserService;
import com.xm.zeronews.util.UserUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author Xm Guo
 * @since 2018-11-14
 */
@Api(value="UserController",tags="用户管理")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private DtoMapper mapper;
    @Autowired
    private UserService userService;

    @GetMapping("/isLogin")
    @ApiOperation(value="获取用户信息")
    public UserDto get() {
        return mapper.userToDto(userService.getById(UserUtil.getUserId()));
    }

    @PutMapping("/update")
    @ApiOperation(value="修改用户信息")
    public void update(@RequestBody UserDto userDto) {
        if(null != userDto) {
            User user = mapper.dtoToUser(userDto);
            userService.updateById(user);
        }
    }

    @PutMapping("/upPass")
    @ApiOperation(value="修改用户密码")
    public boolean upPass(@RequestBody UserDto userDto) {
        if(null != userDto) {
            User user = userService.getById(UserUtil.getUserId());
            if(null != user) {
                if(user.getPassword().equals(userDto.getPassword())) {
                    user.setPassword(userDto.getNewPass());
                    userService.updateById(user);
                    return true;
                }
            }
        }
        return false;
    }



}

