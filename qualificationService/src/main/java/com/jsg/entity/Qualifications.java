package com.jsg.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author jeanson 进生
 * @date 2019/10/14 15:04
 */
@Data
public class Qualifications {
    @ApiModelProperty(value = "主键Id")
    private Integer id;
    @NotNull(message = "type is notnull")
    @ApiModelProperty(position = 1, value = "人员ID", required = true)
    private Integer staffId;
    @NotNull(message = "type is notnull")
    @ApiModelProperty(position = 2, value = "资质类别ID：来自字典表定义", required = true)
    private Integer catalogId;
    @NotNull(message = "type is notnull")
    @ApiModelProperty(position = 3, value = "资质类别ID：来自字典表定义", required = true)
    private Integer zzmcId;
    @NotNull(message = "type is notnull")
    @ApiModelProperty(position = 4, value = "准入日期", required = true)
    private Date admDate;
    @NotNull(message = "type is notnull")
    @ApiModelProperty(position = 5, value = "准入依据", required = true)
    private String admComment;
    @ApiModelProperty(position = 6, value = "手术科目：来自字典表定义", readOnly = true)
    private Integer sskmId;
    @ApiModelProperty(position = 7, value = "手术级别：来自字典表定义", readOnly = true)
    private Integer ssjbId;
    @NotNull(message = "type is notnull")
    @ApiModelProperty(position = 8, value = "/0' COMMENT '是否通过科审：1-通过；0-未通过", required = true)
    private Integer isKsApproved;
    @NotNull(message = "type is notnull")
    @ApiModelProperty(position = 9, value = "0' COMMENT '是否通过院审：1-通过；0-未通过；", required = true)
    private Integer isYyApproved;
    @NotNull(message = "type is notnull")
    @ApiModelProperty(position = 10, value = "1' COMMENT '状态：1-启用；0-停用；", required = true)
    private Integer status;
    @ApiModelProperty(position = 11, value = "创建时间", readOnly = true)
    private Date createTime = new Date();
    @ApiModelProperty(position = 12, value = "修改时间", readOnly = true)
    private Date updateTime = new Date();
    @NotNull(message = "type is notnull")
    @ApiModelProperty(position = 13, value = "创建人", required = true)
    private Integer createUserId;
    @NotNull(message = "type is notnull")
    @ApiModelProperty(position = 14, value = "修改人", required = true)
    private Integer updateUserId;
}
