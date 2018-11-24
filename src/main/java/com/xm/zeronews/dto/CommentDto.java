package com.xm.zeronews.dto;

import com.xm.zeronews.pojo.PageInfo;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 作者：Xm Guo
 * 时间：2018/11/16
 **/
@Data
public class CommentDto extends PageInfo {

    private Long id;

    private Long newsId;

    private Long userId;

    private String context;

    private LocalDateTime createTime;

    private UserDto user;

    public List<ReplyDto> replyList;
}
