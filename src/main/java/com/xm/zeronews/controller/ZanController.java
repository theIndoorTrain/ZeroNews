package com.xm.zeronews.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xm.zeronews.pojo.Zan;
import com.xm.zeronews.service.NewsService;
import com.xm.zeronews.service.ZanService;
import com.xm.zeronews.util.UserUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * <p>
 * 赞 前端控制器
 * </p>
 *
 * @author Xm Guo
 * @since 2018-11-21
 */
@Api(value="ZanController",tags="赞管理")
@CrossOrigin
@RestController
@RequestMapping("/zan")
public class ZanController {

    @Autowired
    private ZanService zanService;
    @Autowired
    private NewsService newsService;

    @ApiOperation(value="点赞")
    @PostMapping("/{newsId}")
    public void create(@PathVariable Long newsId) {
        if(newsId != null) {
            if(null != newsService.getById(newsId)) {
                if(null == zanService.getOne(new QueryWrapper<Zan>().eq("userId", UserUtil.getUserId()).eq("newsId",newsId))) {
                    Zan zan = new Zan();
                    zan.setCreateTime(LocalDateTime.now());
                    zan.setNewsId(newsId);
                    zan.setUserId(UserUtil.getUserId());
                    zanService.save(zan);
                }
            }
        }
    }

    @ApiOperation(value="获取赞状态")
    @GetMapping("/{newsId}")
    public Boolean get(@PathVariable Long newsId) {
        if(null != newsId ) {
            if(null != (Long)UserUtil.getUserId()) {

                Zan one = zanService.getOne(new QueryWrapper<Zan>().eq("userId", UserUtil.getUserId()).eq("newsId", newsId));
                if(null != one) {
                    return true;
                }
            }
        }
        return false;
    }

}

