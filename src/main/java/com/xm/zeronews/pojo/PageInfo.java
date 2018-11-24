package com.xm.zeronews.pojo;

import lombok.Data;

@Data
public class PageInfo {
    //页码
    private int current;
    //每页的数目
    private int size;
}
