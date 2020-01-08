package com.jsg.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author jeanson 进生
 * @date 2019/10/17 9:44
 */
@Data
public class Diagnosis {
    @ApiModelProperty(position = 1, value = "    知识库类别ID", required = true)
    private Integer catalogId;
    @ApiModelProperty(position = 2, value = "    诊断名称", required = true)
    private String name;
    @ApiModelProperty(position = 3, value = "    ICD10编码", required = true)
    private String icd10Code;

    @ApiModelProperty(position = 4, value = "    类别：来自字典定义  1-门诊诊断；2-入院初步诊断；3-出院诊断；4-术前诊断；5-术后诊断；6-放射诊断；7-超声诊断；8-病理诊断；9-尸检诊断；", required = true)
    private Integer type;

    @ApiModelProperty(position = 5, value = "    主诊断标志：1-是；0-否", required = true)
    private String zzdFlag;

    @ApiModelProperty(position = 6, value = "    传染病标志：1-是；0-否", required = true)
    private String crbFlag;

    @ApiModelProperty(position = 7, value = "    产妇分娩标志：1-是；0-否", required = true)
    private String cffmFlag;

    @ApiModelProperty(position = 8, value = "    单病种标志：1-是；0-否", required = true)
    private String dbzFlag;

}
