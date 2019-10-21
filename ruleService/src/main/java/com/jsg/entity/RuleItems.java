package com.jsg.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author jeanson 进生
 * @date 2019/10/21 10:44
 */
@Data
public class RuleItems implements Serializable {
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
    private Integer klgId;

}