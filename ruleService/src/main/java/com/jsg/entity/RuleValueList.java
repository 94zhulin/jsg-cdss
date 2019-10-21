package com.jsg.entity;

import lombok.Data;
/**
 * @author jeanson 进生
 * @date 2019/10/21 10:44
 */
@Data
public class RuleValueList {
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
     * 列表值（多个值用逗号分隔）
     */
    private String value;

}