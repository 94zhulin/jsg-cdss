package com.jsg.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author jeanson 进生
 * @date 2019/10/8 20:05
 */
@Data
public class AccessAuth {
    @ApiModelProperty(value = "授权ID", readOnly = true)
    private Integer id;
    @ApiModelProperty(position = 1, value = "应用名称", required = true)
    private String appName;
    @ApiModelProperty(position = 2, value = "应用编码", required = true)
    private String appCode;
    @ApiModelProperty(position = 3, value = "授权码", required = true)
    private String authKey;
    @ApiModelProperty(position = 4, value = "授权IP列表（多个IP用逗号分隔）", required = true)
    private String authIpList;
    @ApiModelProperty(position = 5, value = "是否过期：1-是；0-否", required = true)
    private Integer isExpired;
    @ApiModelProperty(position = 6, value = "过期日期", required = true)
    private Date expiredDate;

    @ApiModelProperty(position = 6, value = "过期日期", required = true)
    private String expiredDateStr;

    @ApiModelProperty(position = 7, value = "状态：0-已停用；1-已启用", required = true)
    private Integer status;
    @ApiModelProperty(position = 8, value = "创建时间", readOnly = true)
    private Date createTime = new Date();
    @ApiModelProperty(position = 8, value = "修改时间", readOnly = true)
    private Date updateTime = new Date();
    @ApiModelProperty(position = 8, value = "创建人", required = true)
    private Integer createUserId;
    @ApiModelProperty(position = 9, value = "修改人", required = true)
    private Integer updateUserId;
}
