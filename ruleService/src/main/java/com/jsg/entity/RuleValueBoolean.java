package com.jsg.entity;

import lombok.Data;

/**
 * @author jeanson 进生
 * @date 2019/10/21 10:44
 */
@Data
public class RuleValueBoolean {
    /**
     * 自增长ID
     */
    private Integer id;

    /**
     * 规则ID
     */
    private Integer ruleId;

    /**
     * 规则项明细ID
     */
    private Integer ruleItemId;

    /**
     * 运算符: =, <>
     */
    private String operator;

    /**
     * 布尔值：1-true；0-false;
     */
    private Integer value;

}