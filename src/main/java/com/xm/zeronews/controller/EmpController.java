package com.xm.zeronews.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xm.zeronews.dto.DtoMapper;
import com.xm.zeronews.dto.EmpDto;
import com.xm.zeronews.pojo.Emp;
import com.xm.zeronews.pojo.PageInfo;
import com.xm.zeronews.pojo.User;
import com.xm.zeronews.service.EmpService;
import com.xm.zeronews.service.UserService;
import com.xm.zeronews.util.UserUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 职工表 前端控制器
 * </p>
 *
 * @author Xm Guo
 * @since 2018-11-15
 */
@Api(value="EmpController",tags="职员管理")
@RestController
@RequestMapping("/emp")
public class EmpController {

    @Autowired
    private DtoMapper mapper;
    @Autowired
    private EmpService empService;
    @Autowired
    private UserService userService;

    @ApiOperation(value="创建职员信息")
    @PostMapping("/create")
    public EmpDto create(@RequestBody EmpDto empDto) {
        if(null != empDto) {
            Emp emp = mapper.dtoToEmp(empDto);
            emp.setCreateTime(LocalDateTime.now());
            emp.setUserId(UserUtil.getUserId());
            empService.save(emp);
            return mapper.empToDto(emp);
        }
        return null;
    }

    @ApiOperation(value="修改职员信息")
    @PutMapping("/update")
    public void update(@RequestBody EmpDto empDto) {
        if(null != empDto) {
            Emp emp = mapper.dtoToEmp(empDto);
            if(emp.getStatus() == 3) {
                emp = empService.getOne(new QueryWrapper<Emp>().eq("userId",UserUtil.getUserId()));
                if(emp.getStatus()!=3) {
                    return;
                }
                int num = empService.list(new QueryWrapper<Emp>().eq("status",4)).size() + 1001;
                emp.setNum(num);
                emp.setStatus(4);
                User user = UserUtil.getUser();
                user.setType(emp.getType()==true?2:3);
                userService.updateById(user);
            }
            empService.update(emp,new QueryWrapper<Emp>().eq("userId",UserUtil.getUserId()));
        }
    }

    @ApiOperation(value="获取职员信息")
    @GetMapping("/get")
    public EmpDto get() {
        Emp emp = empService.getOne(new QueryWrapper<Emp>().eq("userId",UserUtil.getUserId()));
        if(null != emp) {
            emp.setUser(UserUtil.getUser());
            return mapper.empToDto(emp);
        }
        return null;
    }

    @ApiOperation(value="分页获取职员信息")
    @PostMapping("/page")
    public IPage<Emp> page(@RequestBody PageInfo pageInfo){

        IPage<Emp> page = new Page<>(pageInfo.getCurrent(),pageInfo.getSize());
        page = empService.page(page,new QueryWrapper<Emp>().eq("status",1));
        return page;
    }

}

