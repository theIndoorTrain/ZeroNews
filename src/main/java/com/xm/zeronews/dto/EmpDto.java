package com.xm.zeronews.dto;

import com.xm.zeronews.pojo.PageInfo;
import com.xm.zeronews.pojo.User;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 作者：Xm Guo
 * 时间：2018/11/15
 **/
@Data
public class EmpDto{

    private Integer num;

    private Long userId;

    private Integer auditNum;

    private String name;

    private String phone;

    private String address;

    private Integer status;

    private Boolean type;

    private LocalDateTime createTime;

    private User user;
}
