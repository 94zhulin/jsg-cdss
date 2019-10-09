package com.jsg.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author jeanson 进生
 * @date 2019/10/9 9:33
 */
@Data
public class Properties {

    @ApiModelProperty(value = "属性id")
    private Integer id;
    @ApiModelProperty(position = 1, value = "属性名称", required = true)
    private String propName;
    @ApiModelProperty(position = 2, value = "属性值", required = true)
    private String propValue;
    @ApiModelProperty(position = 3, value = " 类型：99-系统属性；1-业务属性", required = true)
    private Integer type;
    @ApiModelProperty(position = 4, value = " 状态：1-启用；0-停用", required = true)
    private Integer status;
    @ApiModelProperty(position = 5, value = " 创建时间", readOnly = true)
    private Date createTime = new Date();
    @ApiModelProperty(position = 6, value = " 修改时间", readOnly = true)
    private Date updateTime = new Date();
    @ApiModelProperty(position = 7, value = "创建人", required = true)
    private Integer createUserId;
    @ApiModelProperty(position = 8, value = "修改人", required = true)
    private Integer updateUserId;
}
