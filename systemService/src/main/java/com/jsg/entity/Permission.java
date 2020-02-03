package com.jsg.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author jeanson 进生
 * @date 2019/10/9 9:32
 */
@Data
public class Permission {
    @ApiModelProperty(value = "权限ID")
    private Integer id;

    @ApiModelProperty(value = "权限ID")
    private String idStr;
    @ApiModelProperty(position = 1, value = "权限名称", required = true)
    private String name;
    @ApiModelProperty(position = 2, value = "权限编码", required = true)
    private String code;
    @ApiModelProperty(position = 3, value = "状态：0-停用；1-启用", required = true)
    private Integer status;
    @ApiModelProperty(position = 4, value = "创建时间", readOnly = true)
    private Date createTime = new Date();
    @ApiModelProperty(position = 5, value = "修改时间", readOnly = true)
    private Date updateTime = new Date();
    @ApiModelProperty(position = 6, value = "创建人", required = true)
    private Integer createUserId;
    @ApiModelProperty(position = 7, value = "修改人", required = true)
    private Integer updateUserId;
}
