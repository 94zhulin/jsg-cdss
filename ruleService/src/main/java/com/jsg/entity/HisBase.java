package com.jsg.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author jeanson 进生
 * @date 2020/1/7 11:41
 */
@Data
public class HisBase {
    @ApiModelProperty(position = 1, value = "医师code,然后查询得到 该医生资质", required = true)
    private String ysCode;
    @ApiModelProperty(position = 2, value = "知识库类别ID", required = true)
    private Integer itemType;
    @ApiModelProperty(position = 3, value = "项目Code", required = true)
    private String itemCode;
    @ApiModelProperty(position = 4, value = "患者信息", required = true)
    private HisPatients hisPatients;


}

