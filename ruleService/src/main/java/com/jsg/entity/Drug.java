package com.jsg.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author jeanson 进生
 * @date 2019/10/17 9:39
 */
@Data
public class Drug {

    @ApiModelProperty(position = 1, value = "知识库类别ID", required = true)
    private Integer catalogId;
    @ApiModelProperty(position = 2, value = "药品名称", required = true)
    private String name;


    @ApiModelProperty(position = 3, value = "医保标准编码", required = true)
    private String codeGb;


    @ApiModelProperty(position = 4, value = "院内编码", required = true)
    private String codeYy;


    @ApiModelProperty(position = 5, value = "种类：来自字典定义", required = true)
    private String zlCode;


    @ApiModelProperty(position = 6, value = " 范围：来自字典定义", required = true)
    private String fwCode;


    @ApiModelProperty(position = 7, value = "统筹类别：来自字典定义", required = true)
    private String tclbCode;


    @ApiModelProperty(position = 8, value = "抗生素：来自字典定义", required = true)
    private String kssCode;


    @ApiModelProperty(position = 9, value = "特殊药物：来自字典定义", required = true)
    private String tsywCode;

    @ApiModelProperty(position = 10, value = "抗菌药物：来自字典定义", required = true)
    private String kjywCode;

    @ApiModelProperty(position = 11, value = " 限制用药：来自字典定义", required = true)
    private String xzyyCode;


    @ApiModelProperty(position = 12, value = "自付比例（%）", required = true)
    private Double zfbl;


    @ApiModelProperty(position = 13, value = "精神类药：来自字典定义", required = true)
    private String jslyCode;


    @ApiModelProperty(position = 14, value = "剂型：来自字典定义", required = true)
    private String jxCode;


    @ApiModelProperty(position = 15, value = "频次：来自字典定义", required = true)
    private String pcCode;


    @ApiModelProperty(position = 16, value = "给药方式：来自字典定义", required = true)
    private String gyfsCode;


    @ApiModelProperty(position = 17, value = "单次剂量", required = true)
    private String dcjl;


    @ApiModelProperty(position = 18, value = "剂量单位：来自字典定义", required = true)
    private String jldwCode;


    @ApiModelProperty(position = 19, value = "用药时间：来自字典定义", required = true)
    private String yysjCode;


    @ApiModelProperty(position = 20, value = "使用说明", required = true)
    private String sysm;


    @ApiModelProperty(position = 21, value = "0' COMMENT '是否高危药品：1-是；0-否", required = true)
    private Integer isGw;


    @ApiModelProperty(position = 22, value = "0' COMMENT '是否麻醉药品：1-是；0-否", required = true)
    private Integer isMz;


    @ApiModelProperty(position = 23, value = "  是否毒性药品：1-是；0-否", required = true)
    private Integer isDx;


    @ApiModelProperty(position = 24, value = " 0' COMMENT '是否人流药品：1-是；0-否", required = true)
    private Integer isRl;


    @ApiModelProperty(position = 25, value = "  0' COMMENT '是否国家重点监控：1-是；0-否", required = true)
    private Integer isZdjkGj;


    @ApiModelProperty(position = 26, value = " 是否省重点监控：1-是；0-否", required = true)
    private Integer isZdjkSf;


    @ApiModelProperty(position = 27, value = " 0' COMMENT '是否医院重点监控：1-是；0-否", required = true)
    private Integer isZdjkYy;


    @ApiModelProperty(position = 28, value = " 0' COMMENT '是否处方权药品：1-是；0-否", required = true)
    private Integer isCfq;


    @ApiModelProperty(position = 29, value = "  0' COMMENT '是否急诊处方药品：1-是；0-否", required = true)
    private Integer isJzcf;


}