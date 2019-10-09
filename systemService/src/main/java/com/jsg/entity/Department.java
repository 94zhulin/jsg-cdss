package com.jsg.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author jeanson 进生
 * @date 2019/10/8 20:08
 */
@Data
public class Department {
    @ApiModelProperty(value = "主键Id")
    private Integer id;
    @ApiModelProperty(position = 1, value = "医院ID", required = true)
    private Integer hospitalId;
    @ApiModelProperty(position = 2, value = "统计时间")
    private Date statTime;
    @ApiModelProperty(position = 3, value = "科室编码", required = true)
    private String ksCode;
    @ApiModelProperty(position = 3, value = "科室名称", required = true)
    private String ksName;
    @ApiModelProperty(position = 3, value = "科室类型：1-门诊; 2-住院；0-其他；", required = true)
    private Integer ksType;
}
