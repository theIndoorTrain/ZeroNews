package com.xm.zeronews.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 作者：Xm Guo
 * 时间：2018/11/16
 **/
@Data
public class ReplyDto {

    private Long id;

    private Long userId;

    private Long newsId;

    private Long commentId;

    private String context;

    private LocalDateTime createTime;

    private Long replyUserId;

    private UserDto user;

    private UserDto replyUser;
}
