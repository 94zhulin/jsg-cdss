package com.jsg.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author jeanson 进生
 * @date 2020/1/7 21:14
 */
@Data
public class HisPatients {

    @ApiModelProperty(position = 1, value = "年龄")
    private String AGE;


}
