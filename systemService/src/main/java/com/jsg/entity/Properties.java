package com.jsg.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author jeanson 进生
 * @date 2019/10/9 9:33
 */
@Data
public class Properties {
    @NotNull(message = "propName is notnull")
    @ApiModelProperty(position = 1, value = "属性名称", required = true)
    private String propName;
    @NotNull(message = "propValue is notnull")
    @ApiModelProperty(position = 2, value = "属性值", required = true)
    private String propValue;
    @NotNull(message = "type is notnull")
    @ApiModelProperty(position = 3, value = " 类型：99-系统属性；1-业务属性", required = true)
    private Integer type;
    @NotNull(message = "status is notnull")
    @ApiModelProperty(position = 4, value = " 状态：1-启用；0-停用", required = true)
    private Integer status;
    @ApiModelProperty(position = 5, value = " 创建时间", readOnly = true)
    private Date createTime = new Date();
    @ApiModelProperty(position = 6, value = " 修改时间", readOnly = true)
    private Date updateTime = new Date();
    @NotNull(message = "createUserId is notnull")
    @ApiModelProperty(position = 7, value = "创建人", required = true)
    private Integer createUserId;
    @NotNull(message = "updateUserId is notnull")
    @ApiModelProperty(position = 8, value = "修改人", required = true)
    private Integer updateUserId;
}
