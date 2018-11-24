package com.xm.zeronews.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 作者：Xm Guo
 * 时间：2018/11/16
 **/
@Data
public class AuditDto {
    private Long id;

    private Long newsId;

    private String reply;

    private Integer auditNum;

    private LocalDateTime createTime;

    private Boolean isAgree;
}
