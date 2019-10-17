package com.jsg.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author jeanson 进生
 * @date 2019/10/17 9:49
 */
@Data
public class Historyallergy {
    @ApiModelProperty(position = 0, value = "主键Id")
    private Integer id;
    @ApiModelProperty(position = 1, value = "知识库类别ID", required = true)
    private Integer catalogId;
    @ApiModelProperty(position = 2, value = "过敏史名称", required = true)
    private String name;
    @ApiModelProperty(position = 3, value = "过敏史编码", required = true)
    private String code;
    @ApiModelProperty(position = 4, value = "过敏源", required = true)
    private String gmy;
    @ApiModelProperty(position = 5, value = "症状", required = true)
    private String zz;
    @ApiModelProperty(position = 6, value = "状态：1-启用；0-停用", required = true)
    private Integer status;
    @ApiModelProperty(position = 7, value = "创建时间", readOnly = true)
    private Date createTime;
    @ApiModelProperty(position = 8, value = "修改时间", readOnly = true)
    private Date updateTime;
    @ApiModelProperty(position = 9, value = "创建人", required = true)
    private Integer createUserId;
    @ApiModelProperty(position = 10, value = "修改人", required = true)
    private Integer updateUserId;
}
