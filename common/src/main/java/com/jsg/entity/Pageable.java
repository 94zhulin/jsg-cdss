package com.jsg.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author jeanson 进生
 * @date 2019/10/9 17:54
 */
@Data
public class Pageable {
    @ApiModelProperty(position = 1, value = "页码，从0开始", required = true)
    private Integer pageNumber;
    @ApiModelProperty(position = 2, value = "单页规模,数据数", required = true)
    private Integer pageSize;

}
