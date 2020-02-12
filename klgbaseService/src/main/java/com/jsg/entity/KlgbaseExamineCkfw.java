package com.jsg.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * klgbase_examine_ckfw
 *
 * @author
 */
@Data
public class KlgbaseExamineCkfw {

    @ApiModelProperty(position = 1, value = "知识库检验项目ID", required = true)
    private Integer id;

    @ApiModelProperty(position = 1, value = "检验项目ID", required = true)
    private Integer jyxmId;

    @ApiModelProperty(position = 1, value = "参考值名称", required = true)
    private String name;


    @ApiModelProperty(position = 1, value = "开始参考值", required = true)
    private Double startValue;

    @ApiModelProperty(position = 1, value = "结束参考值", required = true)
    private Double endValue;

}