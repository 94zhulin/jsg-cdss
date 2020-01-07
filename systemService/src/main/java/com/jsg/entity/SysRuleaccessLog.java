package com.jsg.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * sys_ruleaccess_log
 *
 * @author
 */
@Data
public class SysRuleaccessLog {

    @ApiModelProperty(position = 1, value = "日志ID")
    private Integer id;


    @ApiModelProperty(position = 1, value = "访问时间")
    private Date accessTime;

    @ApiModelProperty(position = 1, value = "应用名称")
    private String appName;

    @ApiModelProperty(position = 1, value = "应用编码")
    private String appCode;

    @ApiModelProperty(position = 1, value = "IP")
    private String ip;

    @ApiModelProperty(position = 1, value = "用户终端类型：1-PC；2-移动端（手机）；3-移动端（iPad）；99-其他")
    private Integer clientType;

    @ApiModelProperty(position = 1, value = "规则ID")
    private Integer ruleId;

    @ApiModelProperty(position = 1, value = "规则名称")
    private String ruleName;

    @ApiModelProperty(position = 1, value = "规则类型")
    private String ruleCatalogName;

    @ApiModelProperty(position = 1, value = "决策结果")
    private String resultName;
}