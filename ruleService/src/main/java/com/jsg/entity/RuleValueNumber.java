package com.jsg.entity;

import lombok.Data;

/**
 * @author jeanson 进生
 * @date 2019/10/21 10:44
 */
@Data
public class RuleValueNumber {
    /**
     * 自增长ID
     */
    private Integer id;

    /**
     * 属性ID
     */
    private Integer ruleId;

    /**
     * 规则项明细ID
     */
    private Integer ruleItemId;

    /**
     * 运算符: >,>=,<,<=,<>
     */
    private String operator;

    /**
     * 数字值
     */
    private Integer value;


}