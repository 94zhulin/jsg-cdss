package com.jsg.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author jeanson 进生
 * @date 2019/10/10 20:08
 */
@Data
public class RolePermission {
    @ApiModelProperty(position = 1, value = "角色ID")
    private Integer roleId;
    @ApiModelProperty(position = 1, value = "权限ID")
    private Integer permissionId;

}
