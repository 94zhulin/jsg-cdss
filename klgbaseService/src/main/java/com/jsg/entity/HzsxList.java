package com.jsg.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author jeanson 进生
 * @date 2019/10/17 9:53
 */
@Data
public class HzsxList {
    @ApiModelProperty(position = 1, value = "主键Id")
    private Integer id;
    @ApiModelProperty(position = 2, value = "属性ID", required = true)
    private Integer propId;
    @ApiModelProperty(position = 3, value = "列表值（多个值用逗号分隔）", required = true)
    private String value;
}
