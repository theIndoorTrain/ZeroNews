package com.xm.zeronews.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 作者：Xm Guo
 * 时间：2018/11/15
 **/
@Data
public class LoveDto {
    private Long id;

    private Long userId;

    private Long editorId;

    private LocalDateTime createTime;

    private Boolean isLove;
}
