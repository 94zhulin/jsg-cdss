package com.jsg.entity;

import lombok.Data;

/**
 * rule_items
 *
 * @author
 */
@Data
public class RuleItems {
    /**
     * 自增长ID
     */
    private Integer id;

    /**
     * 规则ID
     */
    private Integer ruleId;

    /**
     * 规则项类型：1-满足条件项目；2-条件真关联项目；3-条件假关联项目
     */
    private Integer ruleItemType;

    /**
     * 满足条件类型:1-人资，2-患者，99-其他
     */
    private Integer conditionType;

    /**
     * 知识库类别ID
     */
    private Integer klgCatalogId;

    /**
     * 知识库ID
     */
    private Integer klgItemId;

    /**
     * 知识库属性字段名
     */
    private String klgItemPropname;

    /**
     * 知识库属性值类型：1-布尔，2-数字，3-数字范围，4-日期，5-日期范围，6-文本，7-列表
     */
    private Integer klgItemValuetype;

    /**
     * 操作符：与，或 1 是 与  0是或
     */
    private Integer operator;

    /**
     * 操作符顺序索引
     */
    private Integer opIndex;


}