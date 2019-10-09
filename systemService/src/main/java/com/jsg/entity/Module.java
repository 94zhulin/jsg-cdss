package com.jsg.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author jeanson 进生
 * @date 2019/10/9 9:15
 */
@Data
public class Module {
    @ApiModelProperty(value = "模块ID")
    private Integer id;
    @ApiModelProperty(position = 9, value = "模块名称", required = true)
    private String name;
    @ApiModelProperty(position = 9, value = "模块编码", required = true)
    private String code;
    @ApiModelProperty(position = 9, value = "父模块ID", required = true)
    private Integer parentModuleId;
    @ApiModelProperty(position = 9, value = "模块层级" ,readOnly = true)
    private Integer level;
    @ApiModelProperty(position = 9, value = "路由链接", required = true)
    private String routeUrl;
    @ApiModelProperty(position = 9, value = "排序索引" ,readOnly = true)
    private Integer orderIndex;
    @ApiModelProperty(position = 9, value = "权限数" ,readOnly = true )
    private Integer permissionNum;
    @ApiModelProperty(position = 9, value = "//状态：0-已停用；1-已启用", required = true)
    private Integer status;
    @ApiModelProperty(position = 9, value = "创建时间" ,readOnly = true)
    private Date createTime = new Date();
    @ApiModelProperty(position = 9, value = "修改时间" ,readOnly = true)
    private Date updateTime = new Date();
    @ApiModelProperty(position = 9, value = "创建人", required = true)
    private Integer createUserId;
    @ApiModelProperty(position = 9, value = "修改人", required = true)
    private Integer updateUserId;

}
