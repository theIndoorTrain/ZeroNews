package com.xm.zeronews.dto;

import com.xm.zeronews.pojo.PageInfo;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class UserDto extends PageInfo {
    private Long id;

    private String email;

    private String username;

    private String password;

    private String newPass;

    private String signature;

    private String code;

    private String image;

    private String bg;

    private Integer type;

    private Boolean gender;

    private LocalDate birth;

    private LocalDateTime createTime;

    private LoveDto love;

    private List<NewsDto> newsList;
}
