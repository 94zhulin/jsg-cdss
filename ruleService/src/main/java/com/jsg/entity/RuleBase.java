package com.jsg.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * rule_base
 *
 * @author
 */
@Data
public class RuleBase {

    @ApiModelProperty(position = 13, value = "规则ID")
    private Integer id;
    @ApiModelProperty(position = 13, value = "规则类别ID", required = true)
    private Integer catalogId;
    @ApiModelProperty(position = 13, value = "规则编码", required = true)
    private String code;
    @ApiModelProperty(position = 13, value = "规则名称", required = true)
    private String name;
    @ApiModelProperty(position = 13, value = "优先级：1-高；2-中；3-低；", required = true)
    private Integer priority;
    @ApiModelProperty(position = 13, value = "依赖规则ID", required = true)
    private Integer dependRuleid;
    @ApiModelProperty(position = 13, value = "决策类型：1-拦截；2-警告；3-建议；", required = true)
    private Integer policyType;
    @ApiModelProperty(position = 13, value = "是否为新版本 -- 1 新版本  0旧版本", required = true)
    private Integer isVersion;
    @ApiModelProperty(position = 13, value = "自增版本号", required = true)
    private Integer version;
    @ApiModelProperty(position = 13, value = "相关联的规则ID(多个ID用符号-分隔)，例如：1-2-3", required = true)
    private String relatedRuleIds;
    @ApiModelProperty(position = 13, value = "状态：1-已部署；0-未部署", required = true)
    private Integer deployStatus;
    @ApiModelProperty(position = 13, value = "是否删除标志:1-已删除；0-未删除", required = true)
    private Integer isDelete;
    @ApiModelProperty(position = 13, value = "反馈信息", required = true)
    private String feedbackComment;
    @ApiModelProperty(position = 13, value = "创建时间", readOnly = true)
    private Date createTime = new Date();
    @ApiModelProperty(position = 13, value = "修改时间", readOnly = true)
    private Date updateTime = new Date();
    @ApiModelProperty(position = 13, value = "创建人", required = true)
    private Integer createUserid;
    @ApiModelProperty(position = 13, value = "修改人", required = true)
    private Integer updateUserid;
    @ApiModelProperty(position = 13, value = "类别id", required = true)
    private Integer typeId;
    @ApiModelProperty(position = 14, value = "条件为真的类别id", required = true)
    private Integer conditionsTrueTypeId;
    @ApiModelProperty(position = 15, value = "条件为真的项目Id", required = true)
    private Integer trueItemId;
    @ApiModelProperty(position = 16, value = "条件为假的类别Id", required = true)
    private Integer conditionsFalseTypeId;
    @ApiModelProperty(position = 17, value = "条件为假的项目Id", required = true)
    private Integer falseItemId;
    @ApiModelProperty(position = 18, value = "人资集合", required = true)
    private List<Patients> staffPatients;
    @ApiModelProperty(position = 19, value = "患者条件集合", required = true)
    private List<Patients> hzPatients;
    @ApiModelProperty(position = 20, value = "其他条件集合", required = true)
    private List<Patients> otherPatients;
}