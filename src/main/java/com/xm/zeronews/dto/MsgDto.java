package com.xm.zeronews.dto;

import com.xm.zeronews.pojo.PageInfo;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 作者：Xm Guo
 * 时间：2018/11/16
 **/
@Data
public class MsgDto extends PageInfo {
    private Long id;

    private Long userId;

    private Boolean isRead;

    private String context;

    private LocalDateTime createTime;

    private String name;
}
