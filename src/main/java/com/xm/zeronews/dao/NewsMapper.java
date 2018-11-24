package com.xm.zeronews.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xm.zeronews.pojo.News;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 新闻表 Mapper 接口
 * </p>
 *
 * @author Xm Guo
 * @since 2018-11-15
 */
public interface NewsMapper extends BaseMapper<News> {

    IPage pagePublic(IPage page,@Param("ew") QueryWrapper<News> wrapper);

    IPage pageWithNews(IPage page,@Param("ew") QueryWrapper<News> wrapper);

    IPage pageFailure(IPage page,@Param("ew") QueryWrapper<News> wrapper);
}
