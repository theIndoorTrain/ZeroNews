package com.xm.zeronews.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xm.zeronews.pojo.Comment;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 评论表 服务类
 * </p>
 *
 * @author Xm Guo
 * @since 2018-11-15
 */
public interface CommentService extends IService<Comment> {

    IPage pageWithReply(Page page, QueryWrapper<Comment> wrapper);
}
