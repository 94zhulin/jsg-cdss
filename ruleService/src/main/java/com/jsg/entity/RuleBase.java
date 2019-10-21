package com.jsg.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author jeanson 进生
 * @date 2019/10/21 10:44
 */
@Data
public class RuleBase {
    @ApiModelProperty(position = 1, value = "应用名称", readOnly = true)
    private Integer id;

    @ApiModelProperty(position = 2, value = "规则编码", required = true)
    private String code;

    @ApiModelProperty(position = 2, value = "规则名称", required = true)
    private String name;

    @ApiModelProperty(position = 2, value = "优先级：1-高；2-中；3-低；", required = true)
    private Integer priority;

    @ApiModelProperty(position = 2, value = "依赖规则ID", required = true)
    private Integer dependRuleid;

    @ApiModelProperty(position = 2, value = "决策类型：1-拦截；2-警告；3-建议；", required = true)
    private Integer policyType;

    @ApiModelProperty(position = 2, value = "状态：1-已部署；0-未部署", required = true)
    private Integer deployStatus;

    @ApiModelProperty(position = 2, value = "反馈信息", required = true)
    private String feedbackComment;

    @ApiModelProperty(position = 2, value = "创建时间", readOnly = true)
    private Date createTime = new Date();

    @ApiModelProperty(position = 2, value = "修改时间", readOnly = true)
    private Date updateTime = new Date();

    @ApiModelProperty(position = 2, value = "创建人", required = true)
    private Integer createUserid;

    @ApiModelProperty(position = 2, value = "修改人", required = true)
    private Integer updateUserid;

}