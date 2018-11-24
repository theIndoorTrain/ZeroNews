package com.xm.zeronews.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xm.zeronews.dto.DtoMapper;
import com.xm.zeronews.dto.MsgDto;
import com.xm.zeronews.pojo.Msg;
import com.xm.zeronews.service.MsgService;
import com.xm.zeronews.util.UserUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 消息表 前端控制器
 * </p>
 *
 * @author Xm Guo
 * @since 2018-11-15
 */
@Api(value="MsgController",tags="消息管理")
@RestController
@RequestMapping("/msg")
public class MsgController {

    @Autowired
    private MsgService msgService;
    @Autowired
    private DtoMapper dtoMapper;


    @ApiOperation(value="根据id查看消息详情")
    @GetMapping("/{id}")
    public MsgDto get(@PathVariable Long id) {
        if(null != id) {
            Msg msg = msgService.getById(id);
            return dtoMapper.msgToDto(msg);
        }
        return null;
    }

    @ApiOperation(value="分页查看消息")
    @PostMapping("/page")
    public IPage<MsgDto> page(@RequestBody MsgDto msgDto) {
        if(null != msgDto) {
            IPage page = new Page(msgDto.getCurrent(),msgDto.getSize());
            QueryWrapper<Msg> wrapper = new QueryWrapper<>();
            wrapper.eq("userId", UserUtil.getUserId());
            wrapper.orderByAsc("isRead");
            wrapper.orderByDesc("createTime");
            page = msgService.page(page,wrapper);
            List<Msg> msgDtoList = page.getRecords();
            page.setRecords(dtoMapper.msgList(msgDtoList));
            return page;
        }
        return null;
    }

    @ApiOperation(value="消息已读")
    @PutMapping("/{id}")
    public void update(@PathVariable Long id) {
        if(null != id) {
            Msg msg = new Msg();
            msg.setId(id);
            msg.setIsRead(true);
            msgService.updateById(msg);
        }
    }



}

