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
    @ApiModelProperty(position = 2, value = "项目类别 1 人资 2 患者 3药品 4诊断 5检查 6校验 7过敏史", required = true)
    private Integer itemType;
    @ApiModelProperty(position = 3, value = "项目Code", required = true)
    private String itemCode;
    @ApiModelProperty(position = 4, value = "患者信息", required = true)
    private HisPatients hisPatients;
    @ApiModelProperty(position = 5, value = "检查信息", required = true)
    private Inspect inspect;
    @ApiModelProperty(position = 6, value = "诊断", required = true)
    private Diagnosis diagnosis;
    @ApiModelProperty(position = 7, value = "药品", required = true)
    private Drug drug;
    @ApiModelProperty(position = 8, value = "检验", required = true)
    private Examine examine;
    @ApiModelProperty(position = 9, value = "过敏史", required = true)
    private Historyallergy historyallergy;


}

