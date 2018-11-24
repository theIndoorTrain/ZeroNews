package com.xm.zeronews.controller;


import com.xm.zeronews.dto.DtoMapper;
import com.xm.zeronews.dto.ReplyDto;
import com.xm.zeronews.pojo.Reply;
import com.xm.zeronews.service.ReplyService;
import com.xm.zeronews.util.UserUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * <p>
 * 回复表 前端控制器
 * </p>
 *
 * @author Xm Guo
 * @since 2018-11-15
 */
@Api(value="ReplyController",tags="回复管理")
@RestController
@RequestMapping("/reply")
public class ReplyController {

    @Autowired
    private DtoMapper mapper;
    @Autowired
    private ReplyService replyService;

    @ApiOperation(value="添加评论")
    @PostMapping("/create")
    public void create(@RequestBody ReplyDto replyDto) {
        if(null != replyDto) {

            Reply reply = mapper.dtoToReply(replyDto);
            reply.setCreateTime(LocalDateTime.now());
            reply.setUserId(UserUtil.getUserId());
            replyService.save(reply);

        }

    }

}

