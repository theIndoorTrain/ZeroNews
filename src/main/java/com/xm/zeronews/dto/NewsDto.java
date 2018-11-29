package com.xm.zeronews.dto;

import com.xm.zeronews.pojo.PageInfo;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 作者：Xm Guo
 * 时间：2018/11/16
 **/
@Data
public class NewsDto  extends PageInfo {

    private Long id;

    private Long userId;

    private String title;

    private String context;

    private String images;

    private Integer type;

    private Integer status;

    private LocalDateTime createTime;

    private LocalDateTime pullTime;

    private UserDto user;

    private Long commentNum;

    private Long zanNum;

    private String reply;

    private String search;

}
