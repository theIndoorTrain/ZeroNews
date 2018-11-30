package com.xm.zeronews.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sun.org.apache.xpath.internal.operations.Bool;
import com.xm.zeronews.dto.DtoMapper;
import com.xm.zeronews.dto.NewsDto;
import com.xm.zeronews.pojo.News;
import com.xm.zeronews.pojo.User;
import com.xm.zeronews.service.NewsService;
import com.xm.zeronews.service.UserService;
import com.xm.zeronews.util.UserUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 新闻表 前端控制器
 * </p>
 *
 * @author Xm Guo
 * @since 2018-11-15
 */
@Api(value="AdminController",tags="新闻管理")
@CrossOrigin
@RestController
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private DtoMapper mapper;
    @Autowired
    private NewsService newsService;
    @Autowired
    private UserService userService;


    @ApiOperation(value="新闻创建")
    @PostMapping("/create")
    public NewsDto create(@RequestBody NewsDto newsDto){
        if(null != newsDto) {
            News news = mapper.dtoToNews(newsDto);
            news.setCreateTime(LocalDateTime.now());
            news.setUserId(UserUtil.getUserId());
            newsService.save(news);
            return mapper.newsToDto(news);
        }
        return null;
    }

    @ApiOperation(value="新闻保存")
    @PutMapping("/update")
    public void update(@RequestBody NewsDto newsDto) {
        if(null != newsDto) {
            News news = mapper.dtoToNews(newsDto);
            news.setStatus(1);
            newsService.updateById(news);
        }
    }

    @ApiOperation(value="新闻发布")
    @PutMapping("/pull")
    public void pull(@RequestBody NewsDto newsDto) {
        if(null != newsDto) {
            News news = mapper.dtoToNews(newsDto);
            news.setPullTime(LocalDateTime.now());
            news.setStatus(2);
            newsService.updateById(news);
        }
    }


    @ApiOperation(value="根据id查看新闻详情")
    @GetMapping("/{id}")
    public NewsDto get(@PathVariable Long id) {
        if(null != id) {
            News news = newsService.getById(id);
            User user = userService.getById(news.getUserId());
            news.setUser(user);
            return mapper.newsToDto(news);
        }
        return null;
    }

    @ApiOperation(value="分页查看自己的新闻详情")
    @PostMapping("/page")
    public IPage<NewsDto> pages(@RequestBody NewsDto newsDto) {
        if(null != newsDto) {
            IPage page = new Page<>(newsDto.getCurrent(),newsDto.getSize());
            QueryWrapper<News> wrapper = new QueryWrapper<>();
            News news = mapper.dtoToNews(newsDto);
            if(null != news.getStatus()) {
                if(news.getStatus()==2) {
                    wrapper.in("status",2,3);
                } else{
                    wrapper.eq("status",news.getStatus());
                }
            }
            wrapper.eq("userId",UserUtil.getUserId());
            wrapper.orderByDesc("pullTime","createTime");
            page = newsService.page(page,wrapper);
            List newsList = page.getRecords();
            page.setRecords(mapper.newsList(newsList));
            return page;
        }
        return null;
    }

    @ApiOperation(value="分页查看自己已发表的新闻详情")
    @PostMapping("/page/public")
    public IPage<NewsDto> pagesPublic(@RequestBody NewsDto newsDto) {
        if(null != newsDto) {
            IPage page = new Page<>(newsDto.getCurrent(),newsDto.getSize());
            QueryWrapper<News> wrapper = new QueryWrapper<>();
            wrapper.groupBy("a.id");
            wrapper.eq("a.userId",UserUtil.getUserId());
            wrapper.eq("a.status",5);
            wrapper.orderByDesc("pullTime");
            page = newsService.pagePublic(page,wrapper);
            List newsList = page.getRecords();
            page.setRecords(mapper.newsList(newsList));
            return page;
        }
        return null;
    }

    @ApiOperation(value="分页查看自己审核未的新闻详情")
    @PostMapping("/page/failure")
    public IPage<NewsDto> pageFailure(@RequestBody NewsDto newsDto) {
        if(null != newsDto) {
            IPage page = new Page<>(newsDto.getCurrent(),newsDto.getSize());
            QueryWrapper<News> wrapper = new QueryWrapper<>();
            wrapper.groupBy("a.id");
            wrapper.eq("a.userId",UserUtil.getUserId());
            wrapper.eq("a.status",4);
            wrapper.orderByDesc("pullTime");
            page = newsService.pageFailure(page,wrapper);
            List newsList = page.getRecords();
            page.setRecords(mapper.newsList(newsList));
            return page;
        }
        return null;
    }

    @ApiOperation(value="分页查看已发表的新闻详情")
    @PostMapping("/page/publicType")
    public IPage<NewsDto> pageTypePublic(@RequestBody NewsDto newsDto) {
        if(null != newsDto) {
            IPage page = new Page<>(newsDto.getCurrent(),newsDto.getSize());
            QueryWrapper<News> wrapper = new QueryWrapper<>();
            if(newsDto.getType()!=0) {
                wrapper.eq("a.type",newsDto.getType());
            }
            wrapper.groupBy("a.id");
            wrapper.eq("a.status",5);
            wrapper.orderByDesc("pullTime");
            page = newsService.pagePublic(page,wrapper);
            List newsList = page.getRecords();
            page.setRecords(mapper.newsList(newsList));
            return page;
        }
        return null;
    }

    @ApiOperation(value="根据id删除新闻")
    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Long id) {
        if(id != null) {
            News news = newsService.getById(id);
            if(news.getUserId() == UserUtil.getUserId()) {
                newsService.removeById(id);
                return true;
            }
        }
        return false;
    }

    @ApiOperation(value="获取热度排行榜")
    @GetMapping("/ranking/{type}")
    public List<NewsDto> list(@PathVariable Integer type) {
        QueryWrapper<News> wrapper = new QueryWrapper<>();
        if(0 != type) {
            wrapper.eq("a.type",type);
        }
        wrapper.eq("a.status",5)
                .groupBy("a.id")
                .last("limit 15")
                .orderByDesc("zanNum");
        List<News> list = newsService.listType(wrapper);
        return mapper.newsList(list);
    }

    @ApiOperation(value="模糊查询")
    @PostMapping("/search")
    public IPage<NewsDto> searchPublic(@RequestBody NewsDto newsDto){
        if(null != newsDto) {
            IPage page = new Page<>(newsDto.getCurrent(),newsDto.getSize());
            QueryWrapper<News> wrapper = new QueryWrapper<>();
            wrapper.groupBy("a.id");
            wrapper.eq("a.status",5);
            wrapper.and(i -> i.like("a.title",newsDto.getSearch()).or(j -> j.like("b.username",newsDto.getSearch())));
            page = newsService.pageWithNews(page,wrapper);
            List newsList = page.getRecords();
            page.setRecords(mapper.newsList(newsList));
            return page;
        }
        return null;
    }

}

