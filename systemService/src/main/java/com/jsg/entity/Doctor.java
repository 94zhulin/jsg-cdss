package com.jsg.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author jeanson 进生
 * @date 2019/10/8 20:15
 */
@Data
public class Doctor {
    @ApiModelProperty(value = "主键Id")
    private Integer id;
    @ApiModelProperty(position = 1, value = "医院ID", required = true)
    private Integer hospitalId;
    @ApiModelProperty(position = 2, value = "统计时间" ,readOnly = true)
    private Date statTime;
    @ApiModelProperty(position = 3, value = "医生编码", required = true)
    private String ysCode;
    @ApiModelProperty(position = 4, value = "医生姓名", required = true)
    private String ysName;
    @ApiModelProperty(position = 5, value = "HIS系统密码", required = true)
    private String password;
    @ApiModelProperty(position = 6, value = "密码MD5" ,readOnly = true )
    private String passwordMd5;
    @ApiModelProperty(position = 7, value = "科室编码", required = true)
    private String ksCode;
    @ApiModelProperty(position = 8, value = "医生类型", required = true)
    private Integer ysType;
    @ApiModelProperty(position = 9, value = "手机号", required = true)
    private String mobileNum;
    @ApiModelProperty(position = 10, value = "职务", required = true)
    private String jobTitle;
    @ApiModelProperty(position = 11, value = "性别：1-男，2-女，0-不详", required = true)
    private Integer sex;
}
