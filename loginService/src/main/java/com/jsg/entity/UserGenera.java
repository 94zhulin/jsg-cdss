package com.jsg.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author jeanson 进生
 * @date 2019/11/19 18:08
 */
@Data
public class UserGenera {
    @ApiModelProperty(value = "用户ID")
    private Integer id;
    @ApiModelProperty(position = 1, value = "角色ID", required = true)
    private Integer roleId;
    @ApiModelProperty(position = 2, value = "用户名", required = true)
    private String userName;
    @ApiModelProperty(position = 3, value = "密码", required = true)
    private String password;
    @ApiModelProperty(position = 4, value = "医生编码", required = true)
    private String ysCode;
    @ApiModelProperty(position = 5, value = "科室编码", required = true)
    private String ksCode;
    @ApiModelProperty(position = 6, value = "姓名", required = true)
    private String fullName;
    @ApiModelProperty(position = 7, value = "性别：1-男；2-女；0-不详", required = true)
    private Integer sex;
    @ApiModelProperty(position = 8, value = "年龄", required = true)
    private Integer age;
    @ApiModelProperty(position = 9, value = "手机号", required = true)
    private String mobileNum;
    @ApiModelProperty(position = 10, value = "职务", required = true)
    private String jobTitle;
    @ApiModelProperty(position = 11, value = "状态：0-停用；1-启用", required = true)
    private Integer status;
    @ApiModelProperty(position = 12, value = "创建时间", readOnly = true)
    private Date createTime = new Date();
    @ApiModelProperty(position = 13, value = "修改时间", readOnly = true)
    private Date updateTime = new Date();
    @ApiModelProperty(position = 14, value = "创建人", required = true)
    private Integer createUserId;
    @ApiModelProperty(position = 15, value = "修改人", required = true)
    private Integer updateUserId;
    @ApiModelProperty(position = 16, value = "最近登录时间", readOnly = true)
    private Date lastLoginTime;
    @ApiModelProperty(position = 17, value = "最近登录IP", readOnly = true)
    private String lastLoginIp;
    @ApiModelProperty(position = 18, value = "role权限名(只读)", readOnly = true)
    private String name;
    @ApiModelProperty(position = 19, value = "科室名称(只读)", readOnly = true)
    private String ksName;
    private  RoleGenera role ;

    /**
     * 创建人
     */
    private Integer createUserId;

    /**
     * 修改人
     */
    private Integer updateUserid;

}
