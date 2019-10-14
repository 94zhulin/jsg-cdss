package com.jsg.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author jeanson 进生
 * @date 2019/10/14 15:04
 */
@Data
public class Qualifications {
    @ApiModelProperty(value = "主键Id")
    private Integer id;
    @ApiModelProperty(position = 1, value = "人员ID", required = true)
    private Integer staffId;
    @ApiModelProperty(position = 1, value = "资质类别ID：来自字典表定义", required = true)
    private Integer catalogId;
    @ApiModelProperty(position = 1, value = "资质名称", required = true)
    private String name;
    @ApiModelProperty(position = 1, value = "准入日期", required = true)
    private Date admDate;
    @ApiModelProperty(position = 1, value = "准入依据", required = true)
    private String admComment;
    @ApiModelProperty(position = 1, value = "手术科目：来自字典表定义", required = true)
    private Integer sskmId;
    @ApiModelProperty(position = 1, value = "手术级别：来自字典表定义", required = true)
    private Integer ssjbId;
    @ApiModelProperty(position = 1, value = "/0' COMMENT '是否通过科审：1-通过；0-未通过", required = true)
    private Integer isKsApproved;
    @ApiModelProperty(position = 1, value = "0' COMMENT '是否通过院审：1-通过；0-未通过；", required = true)
    private Integer isYyApproved;
    @ApiModelProperty(position = 1, value = "1' COMMENT '状态：1-启用；0-停用；", required = true)
    private Integer status;
    @ApiModelProperty(position = 1, value = "创建时间", readOnly = true)
    private Date createTime;
    @ApiModelProperty(position = 1, value = "修改时间", readOnly = true)
    private Date updateTime;
    @ApiModelProperty(position = 1, value = "创建人", required = true)
    private Integer createUserId;
    @ApiModelProperty(position = 1, value = "修改人", required = true)
    private Integer updateUserId;
}
