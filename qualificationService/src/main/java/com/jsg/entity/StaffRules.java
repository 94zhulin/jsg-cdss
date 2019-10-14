package com.jsg.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author jeanson 进生
 * @date 2019/10/14 15:53
 */
@Data
public class StaffRules {
    @ApiModelProperty(position = 1, value = "人员ID", required = true)
    private Integer staffId;
    @ApiModelProperty(position = 2, value = "资质ID", required = true)
    private Integer qlfId;
    @ApiModelProperty(position = 3, value = "规则ID", required = true)
    private Integer ruleId;


}
