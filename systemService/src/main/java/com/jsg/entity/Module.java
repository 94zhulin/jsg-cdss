package com.jsg.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * @author jeanson 进生
 * @date 2019/10/9 9:15
 */
@Data
public class Module {
    @ApiModelProperty(value = "模块ID")
    private Integer id;
    @NotNull(message = "type is notnull")
    @ApiModelProperty(position = 1, value = "模块名称", required = true)
    private String name;
    @NotNull(message = "type is notnull")
    @ApiModelProperty(position = 2, value = "模块编码", required = true)
    private String code;
    @NotNull(message = "type is notnull")
    @ApiModelProperty(position = 3, value = "父模块ID", required = true)
    private Integer parentModuleId;
    @NotNull(message = "type is notnull")
    @ApiModelProperty(position = 4, value = "模块层级", required = true)
    private Integer level;
    @ApiModelProperty(position = 5, value = "路由链接", required = true)
    @NotNull(message = "type is notnull")
    private String routeUrl;
    @NotNull(message = "type is notnull")
    @ApiModelProperty(position = 6, value = "排序索引", required = true)
    private Integer orderIndex;
    @ApiModelProperty(position = 7, value = "权限数", readOnly = true)
    private Integer permissionNum;
    @ApiModelProperty(position = 8, value = "//状态：0-已停用；1-已启用", required = true)
    private Integer status;
    @ApiModelProperty(position = 9, value = "创建时间", readOnly = true)
    private Date createTime = new Date();
    @ApiModelProperty(position = 10, value = "修改时间", readOnly = true)
    private Date updateTime = new Date();
    @NotNull(message = "type is notnull")
    @ApiModelProperty(position = 11, value = "创建人", required = true)
    private Integer createUserId;
    @NotNull(message = "type is notnull")
    @ApiModelProperty(position = 12, value = "修改人", required = true)
    private Integer updateUserId;
    @ApiModelProperty(position = 9, value = "子目录", readOnly = true)
    private List<Module> children;

}
