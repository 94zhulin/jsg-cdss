package com.jsg.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author jeanson 进生
 * @date 2019/10/14 12:02
 */
@Data
public class ModulePermission {

    @ApiModelProperty(position = 1, value = "模块ID")
    private Integer moduleId;
    @ApiModelProperty(position = 1, value = "权限ID")
    private Integer permissionId;

}
