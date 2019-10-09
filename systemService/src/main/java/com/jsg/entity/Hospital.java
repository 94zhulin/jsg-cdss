package com.jsg.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author jeanson 进生
 * @date 2019/10/8 20:21
 */
@Data
public class Hospital {
    @ApiModelProperty(value = "医院ID")
    private Integer id;
    @ApiModelProperty(position = 1, value = "医院名称", required = true)
    private String name;
    @ApiModelProperty(position = 2, value = "医院编码", required = true)
    private String code;
    @ApiModelProperty(position = 3, value = "医院Logo图片链接", readOnly = true)
    private String logoUrl;
    @ApiModelProperty(position = 4, value = "联系人", readOnly = true)
    private String contactPerson;
    @ApiModelProperty(position = 5, value = "联系电话", readOnly = true)
    private String contactPhoneNum;
    @ApiModelProperty(position = 6, value = "联系地址", readOnly = true)
    private String contactAddress;
    @ApiModelProperty(position = 7, value = "创建时间", readOnly = true)
    private Date createTime;
    @ApiModelProperty(position = 8, value = "修改时间",readOnly = true)
    private Date updateTime;
    @ApiModelProperty(position = 9, value = "创建人", required = true)
    private Integer createUserId;
    @ApiModelProperty(position = 10, value = "修改人", required = true)
    private Integer updateUserId;
}
