package com.xm.zeronews.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xm.zeronews.pojo.News;
import com.xm.zeronews.dao.NewsMapper;
import com.xm.zeronews.service.NewsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 新闻表 服务实现类
 * </p>
 *
 * @author Xm Guo
 * @since 2018-11-15
 */
@Service
public class NewsServiceImpl extends ServiceImpl<NewsMapper, News> implements NewsService {

    @Autowired
    private NewsMapper newsMapper;

    @Override
    public News getDisAuditNewsId() {
        List<News> newsList = newsMapper.selectList(new QueryWrapper<News>().eq("status",2).orderByAsc("createTime"));
        News news = newsList.get(0);
        if(news != null) {
            news.setStatus(3);
            newsMapper.updateById(news);
            return news;
        }
        return null;
    }

    @Override
    public IPage pagePublic(IPage page, QueryWrapper<News> wrapper) {
        return newsMapper.pagePublic(page,wrapper);
    }

    @Override
    public IPage pageWithNews(IPage page, QueryWrapper<News> wrapper) {
        return newsMapper.pageWithNews(page,wrapper);
    }

    @Override
    public IPage pageFailure(IPage page, QueryWrapper<News> wrapper) {
        return newsMapper.pageFailure(page,wrapper);
    }

    @Override
    public List<News> listType(QueryWrapper<News> objectQueryWrapper) {
        return newsMapper.listType(objectQueryWrapper);
    }
}
