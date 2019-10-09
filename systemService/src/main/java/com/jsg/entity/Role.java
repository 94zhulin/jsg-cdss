package com.jsg.entity;

import lombok.Data;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @author jeanson 进生
 * @date 2019/10/9 9:35
 */
@Data
public class Role {
    @ApiModelProperty("角色ID")
    private Integer id;
    @ApiModelProperty(position = 1, value = "角色名称", required = true)
    private String name;
    @ApiModelProperty(position = 2, value = "角色编码", required = true)
    private String code;
    @ApiModelProperty(position = 3, value = "描述",readOnly = true )
    private String description;
    @ApiModelProperty(position = 4, value = "权限数" ,readOnly = true )
    private Integer permissionNum;
    @ApiModelProperty(position = 5, value = "状态：0-停用；1-启用", required = true)
    private Integer status;
    @ApiModelProperty(position = 6, value = "创建时间",readOnly = true )
    private Date createTime = new Date();
    @ApiModelProperty(position = 7, value = "修改时间" ,readOnly = true )
    private Date updateTime = new Date();
    @ApiModelProperty(position = 8, value = "创建人", required = true)
    private Integer createUserId;
    @ApiModelProperty(position = 9, value = "修改人", required = true)
    private Integer updateUserId;
}
