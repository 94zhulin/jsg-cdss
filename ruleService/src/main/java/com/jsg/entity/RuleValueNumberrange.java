package com.jsg.entity;

import lombok.Data;

/**
 * @author jeanson 进生
 * @date 2019/10/21 10:44
 */
@Data
public class RuleValueNumberrange {
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
     * 开始数值运算符：>,>=,<,<=,=,<>
     */
    private String startOp;

    /**
     * 开始数值
     */
    private Double startValue;

    /**
     * 结束数值运算符：<,<=
     */
    private String endOp;

    /**
     * 结束数值
     */
    private Double endValue;

}