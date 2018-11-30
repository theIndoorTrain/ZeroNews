package com.xm.zeronews.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xm.zeronews.dto.DtoMapper;
import com.xm.zeronews.dto.LoveDto;
import com.xm.zeronews.dto.NewsDto;
import com.xm.zeronews.dto.UserDto;
import com.xm.zeronews.pojo.Love;
import com.xm.zeronews.pojo.News;
import com.xm.zeronews.pojo.User;
import com.xm.zeronews.service.LoveService;
import com.xm.zeronews.service.NewsService;
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
 * 关注表 前端控制器
 * </p>
 *
 * @author Xm Guo
 * @since 2018-11-15
 */
@Api(value="LoveController",tags="关注管理")
@CrossOrigin
@RestController
@RequestMapping("/love")
public class LoveController {

    @Autowired
    private UserService userService;
    @Autowired
    private LoveService loveService;
    @Autowired
    private NewsService newsService;
    @Autowired
    private DtoMapper mapper;

    @ApiOperation(value="改变关注状态")
    @PostMapping("/update")
    public void setLove(@RequestBody LoveDto loveDto) {
        if(null != loveDto) {
            Love love = mapper.dtoToLove(loveDto);
            Love loveOne = loveService.getOne(new QueryWrapper<Love>().eq("userId",UserUtil.getUserId()).eq("editorId",love.getEditorId()));
            if(loveOne == null) {
                love.setUserId(UserUtil.getUserId());
                love.setCreateTime(LocalDateTime.now());
                loveService.save(love);
            }else {
                love.setId(loveOne.getId());
                loveService.updateById(love);
            }
        }
    }

    @ApiOperation(value="获取关注信息")
    @GetMapping("/{editorId}")
    public UserDto get(@PathVariable Long editorId) {
        if(null != editorId) {
            User user = userService.getWithLove(new QueryWrapper<User>().eq("a.id",editorId).eq("b.userId",UserUtil.getUserId()));
            if(null == user) {
                user = userService.getById(editorId);
            }
            return mapper.userToDto(user);
        }
        return null;
    }

    @ApiOperation(value="获取关注用户信息")
    @PostMapping("/pageNews")
    public IPage<NewsDto> pageNews(@RequestBody NewsDto newsDto) {
        if(null != newsDto) {
            IPage page = new Page(newsDto.getCurrent(),newsDto.getSize());
            QueryWrapper<News> wrapper = new QueryWrapper<>();
            wrapper.eq("a.status",5)
                    .eq("e.userId",UserUtil.getUserId())
                    .eq("e.isLove",true)
                    .groupBy("a.id")
                    .orderByDesc("a.pullTime");
            page = newsService.pageWithNews(page,wrapper);
            List<NewsDto> newsDtoList = mapper.newsList(page.getRecords());
            page.setRecords(newsDtoList);
            return page;
        }
        return null;
    }

    @ApiOperation(value="获取关注用户的新闻信息")
    @PostMapping("/pageUser")
    public IPage<NewsDto> pageUser(@RequestBody UserDto userDto) {
        if(null != userDto) {
            IPage page = new Page(userDto.getCurrent(),userDto.getSize());
            QueryWrapper<User> wrapper = new QueryWrapper<>();
            wrapper.eq("b.userId",UserUtil.getUserId())
                    .eq("a.type",2)
                    .eq("c.status",5)
                    .eq("b.isLove",true)
                    .orderByAsc("c.pullTime");
            page = userService.pageNews(page,wrapper);
            List<UserDto> userDtoList = mapper.userList(page.getRecords());
            page.setRecords(userDtoList);
            return page;
        }
        return null;
    }

}

