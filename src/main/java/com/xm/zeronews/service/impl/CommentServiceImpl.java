package com.xm.zeronews.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.sql.SqlHelper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xm.zeronews.pojo.Comment;
import com.xm.zeronews.dao.CommentMapper;
import com.xm.zeronews.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 评论表 服务实现类
 * </p>
 *
 * @author Xm Guo
 * @since 2018-11-15
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public IPage pageWithReply(Page page, QueryWrapper<Comment> wrapper) {
        return commentMapper.pageWithReply(page,wrapper);
    }
}
