package com.jsg.entity;

import lombok.Data;

/**
 * @author jeanson 进生
 * @date 2019/10/22 14:55
 */
@Data
public class Conditions {

    private Integer priority; // 当有多个条件时,判断条件的优先级
    private String rootCompare; // 最外层的比较符,
    private String leftCompare; //左比较符
    private String rightCompare;//右比较符
    private String leftValue;// 左边的内容
    private String righValue; //右边的内容
}
