package com.xm.zeronews.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xm.zeronews.pojo.Comment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 评论表 Mapper 接口
 * </p>
 *
 * @author Xm Guo
 * @since 2018-11-15
 */
public interface CommentMapper extends BaseMapper<Comment> {

    IPage pageWithReply(Page page, @Param("ew") QueryWrapper<Comment> wrapper);
}
