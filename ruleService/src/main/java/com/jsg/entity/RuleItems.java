package com.jsg.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * rule_items
 *
 * @author
 */
@Data
public class RuleItems {
    @ApiModelProperty(position = 0, value = "    自增长ID")
    private Integer id;


    @ApiModelProperty(position = 1, value = "    规则ID", required = true)
    private Integer ruleId;


    @ApiModelProperty(position = 2, value = "    规则项类型：1-满足条件项目；2-条件真关联项目；3-条件假关联项目", required = true)
    private Integer ruleItemType;

    @ApiModelProperty(position = 3, value = " 满足条件类型:1-人资，2-患者，99-其他", required = true)
    private Integer conditionType;


    @ApiModelProperty(position = 4, value = " 知识库类别ID", required = true)
    private Integer klgCatalogId;


    @ApiModelProperty(position = 5, value = " 知识库项目Code", required = true)
    private String  klgItemCode;

    @ApiModelProperty(position = 5, value = " 知识库项目Name", required = true)
    private String  klgItemName;



    @ApiModelProperty(position = 6, value = " 知识库属性字段名", required = true)
    private String klgItemPropname;


    @ApiModelProperty(position = 7, value = " 知识库属性值类型：1-布尔，2-数字，3-数字范围，4-日期，5-日期范围，6-文本，7-列表", required = true)
    private Integer klgItemValuetype;


    @ApiModelProperty(position = 7, value = " 操作符：与，或 1 是 与  0是或", required = true)
    private Integer operator;


    @ApiModelProperty(position = 7, value = " 操作符顺序索引", required = true)
    private Integer opIndex;


}