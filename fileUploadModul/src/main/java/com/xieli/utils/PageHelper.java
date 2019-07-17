package com.xieli.utils;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * PageHelper
 * time:2019/7/18
 * author:xieli
 */
@Data
public class PageHelper<T> {
    //实体类集合
    private List<T> rows = new ArrayList<T>();
    //数据总条数
    private int total;

}
