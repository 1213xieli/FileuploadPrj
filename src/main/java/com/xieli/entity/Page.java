package com.xieli.entity;

import lombok.Data;

/**
 * Page
 * time:2019/7/18
 * author:xieli
 */
@Data
public class Page {
    //每页显示数量
    private int limit;
    //页码
    private int page;
    //sql语句起始索引
    private int offset;

}

