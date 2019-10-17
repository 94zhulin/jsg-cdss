package com.jsg.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author jeanson 进生
 * @date 2019/10/17 9:51
 */
@Data
public class Hzsx {
    @ApiModelProperty(position = 1, value = "主键Id")
    private Integer id;
    @ApiModelProperty(position = 1, value = "知识库类别ID", required = true)
    private Integer catalogId;
    @ApiModelProperty(position = 1, value = "属性名称", required = true)
    private String name;
    @ApiModelProperty(position = 1, value = "属性编码", required = true)
    private String code;
    @ApiModelProperty(position = 1, value = "数值类型：1-文本；2-数字；3-布尔；4-列表；5-日期；", required = true)
    private Integer valueType;
    @ApiModelProperty(position = 1, value = "状态：1-启用；0-停用", required = true)
    private Integer status;
    @ApiModelProperty(position = 1, value = "  创建时间", readOnly = true)
    private Date createTime;
    @ApiModelProperty(position = 1, value = "修改时间", readOnly = true)
    private Date updateTime;
    @ApiModelProperty(position = 1, value = "创建人", required = true)
    private Integer createUserId;
    @ApiModelProperty(position = 1, value = "修改人", required = true)
    private Integer updateUserId;
}
