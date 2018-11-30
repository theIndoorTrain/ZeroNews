package com.xm.zeronews.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xm.zeronews.dto.CommentDto;
import com.xm.zeronews.dto.DtoMapper;
import com.xm.zeronews.pojo.Comment;
import com.xm.zeronews.pojo.PageInfo;
import com.xm.zeronews.service.CommentService;
import com.xm.zeronews.util.UserUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 评论表 前端控制器
 * </p>
 *
 * @author Xm Guo
 * @since 2018-11-15
 */

@Api(value="CommentController",tags="评论管理")
@CrossOrigin
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private DtoMapper mapper;
    @Autowired
    private CommentService commentService;

    @ApiOperation(value="创建评论")
    @PostMapping("/create")
    public void create(@RequestBody CommentDto commentDto){
        if(null != commentDto) {
            Comment comment = mapper.dtoToComment(commentDto);
            comment.setCreateTime(LocalDateTime.now());
            comment.setUserId(UserUtil.getUserId());
            commentService.save(comment);
        }
    }

    @ApiOperation(value="根据id删除评论")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        if(null != id) {
            commentService.removeById(id);
        }
    }

    @ApiOperation(value="分页查询")
    @PostMapping("/page")
    public IPage<CommentDto> page(@RequestBody CommentDto commentDto) {
        if(null != commentDto) {
            Page page = new Page(commentDto.getCurrent(),commentDto.getSize());
            QueryWrapper<Comment> wrapper = new QueryWrapper<>();
            wrapper.eq("a.newsId",commentDto.getNewsId());
            //wrapper.orderByDesc("createTime");
            IPage ipage = commentService.pageWithReply(page,wrapper);

            return ipage;
        }
        return null;
    }


}

