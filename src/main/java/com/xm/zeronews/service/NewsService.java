package com.xm.zeronews.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xm.zeronews.pojo.News;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 新闻表 服务类
 * </p>
 *
 * @author Xm Guo
 * @since 2018-11-15
 */
public interface NewsService extends IService<News> {

    News getDisAuditNewsId();

    IPage pagePublic(IPage page, QueryWrapper<News> wrapper);

    IPage pageWithNews(IPage page, QueryWrapper<News> wrapper);

    IPage pageFailure(IPage page, QueryWrapper<News> wrapper);
}
