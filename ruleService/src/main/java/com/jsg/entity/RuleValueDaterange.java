package com.jsg.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author jeanson 进生
 * @date 2019/10/21 10:44
 */
@Data
public class RuleValueDaterange {
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
     * 开始日期运算符：>,>=,<,<=,=,<>
     */
    private String startOp;

    /**
     * 开始日期
     */
    private Date startValue;

    /**
     * 结束日期运算符：<,<=
     */
    private String endOp;

    /**
     * 结束日期
     */
    private Date endValue;

}