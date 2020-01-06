package com.jsg.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author jeanson 进生
 * @date 2019/10/17 9:44
 */
@Data
public class Diagnosis {
    @ApiModelProperty(position = 0, value = "    主键Id")
    private Integer id;
    @ApiModelProperty(position = 1, value = "    知识库类别ID", required = true)
    private Integer catalogId;
    @ApiModelProperty(position = 2, value = "    诊断名称", required = true)
    private String name;
    @ApiModelProperty(position = 2, value = "    诊断名称_规则库使用，后台返回", readOnly = true)
    private String name_to = "诊断名称";

    @ApiModelProperty(position = 3, value = "    ICD10编码", required = true)
    private String icd10Code;

    @ApiModelProperty(position = 3, value = "    ICD10编码_规则库使用，后台返回", readOnly = true)
    private String icd10Code_to = "ICD10编码";

    @ApiModelProperty(position = 4, value = "    类别：来自字典定义  1-门诊诊断；2-入院初步诊断；3-出院诊断；4-术前诊断；5-术后诊断；6-放射诊断；7-超声诊断；8-病理诊断；9-尸检诊断；", required = true)
    private Integer type;


    @ApiModelProperty(position = 4, value = "    类别：来自字典定义  1-门诊诊断；2-入院初步诊断；3-出院诊断；4-术前诊断；5-术后诊断；6-放射诊断；7-超声诊断；8-病理诊断；9-尸检诊断；", readOnly = true)
    private String type_to = "类别";


    @ApiModelProperty(position = 5, value = "    主诊断标志：1-是；0-否", required = true)
    private String zzdFlag;

    @ApiModelProperty(position = 5, value = "    主诊断标志：1-是；0-否", readOnly = true)
    private String zzdFlag_to = "主诊断标志";

    @ApiModelProperty(position = 6, value = "    传染病标志：1-是；0-否", required = true)
    private String crbFlag;


    @ApiModelProperty(position = 6, value = "    传染病标志：1-是；0-否", readOnly = true)
    private String crbFlag_to = "传染病标志";

    @ApiModelProperty(position = 7, value = "    产妇分娩标志：1-是；0-否", required = true)
    private String cffmFlag;

    @ApiModelProperty(position = 7, value = "    产妇分娩标志：1-是；0-否", readOnly = true)
    private String cffmFlag_to = "产妇分娩标志";

    @ApiModelProperty(position = 8, value = "    单病种标志：1-是；0-否", required = true)
    private String dbzFlag;

    @ApiModelProperty(position = 8, value = "    单病种标志：1-是；0-否", required = true)
    private String dbzFlag_to = "单病种标志";


    @ApiModelProperty(position = 6, value = "    状态：1-启用；0-停用", required = true)
    private Integer status;

    @ApiModelProperty(position = 7, value = "    创建时间", readOnly = true)
    private Date createTime = new Date();
    @ApiModelProperty(position = 8, value = "      修改时间", readOnly = true)
    private Date updateTime = new Date();
    @ApiModelProperty(position = 9, value = "    创建人", required = true)
    private Integer createUserId;
    @ApiModelProperty(position = 10, value = "     修改人", required = true)
    private Integer updateUserId;
}
