package com.jsg.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author jeanson 进生
 * @date 2019/10/17 9:39
 */
@Data
public class Drug {
    @ApiModelProperty(position = 0, value = "    主键Id")
    private Integer id;
    @ApiModelProperty(position = 1, value = "知识库类别ID", required = true)
    private Integer catalogId;
    @ApiModelProperty(position = 2, value = "药品名称", required = true)
    private String name;
    @ApiModelProperty(position = 2, value = "药品名称", readOnly = true)
    private String name_to = "药品名称";


    @ApiModelProperty(position = 3, value = "医保标准编码", required = true)
    private String codeGb;

    @ApiModelProperty(position = 3, value = "医保标准编码", readOnly = true)
    private String codeGb_to = "医保标准编码";


    @ApiModelProperty(position = 4, value = "院内编码", required = true)
    private String codeYy;


    @ApiModelProperty(position = 4, value = "院内编码", readOnly = true)
    private String codeYy_to = "院内编码";


    @ApiModelProperty(position = 5, value = "种类：来自字典定义", required = true)
    private String zlCode;


    @ApiModelProperty(position = 5, value = "种类：来自字典定义", readOnly = true)
    private String zlCode_to = "种类";


    @ApiModelProperty(position = 6, value = " 范围：来自字典定义", required = true)
    private String fwCode;

    @ApiModelProperty(position = 6, value = " 范围：来自字典定义", readOnly = true)
    private String fwCode_to = "范围";


    @ApiModelProperty(position = 7, value = "统筹类别：来自字典定义", required = true)
    private String tclbCode;

    @ApiModelProperty(position = 7, value = "统筹类别：来自字典定义", readOnly = true)
    private String tclbCode_to = "统筹类别";

    @ApiModelProperty(position = 8, value = "抗生素：来自字典定义", required = true)
    private String kssCode;

    @ApiModelProperty(position = 8, value = "抗生素：来自字典定义", readOnly = true)
    private String kssCode_to = "抗生素";


    @ApiModelProperty(position = 9, value = "特殊药物：来自字典定义", required = true)
    private String tsywCode;
    @ApiModelProperty(position = 9, value = "特殊药物：来自字典定义", readOnly = true)
    private String tsywCode_to = "特殊药物";

    @ApiModelProperty(position = 10, value = "抗菌药物：来自字典定义", required = true)
    private String kjywCode;
    @ApiModelProperty(position = 10, value = "抗菌药物：来自字典定义", readOnly = true)
    private String kjywCode_to = "抗菌药物";

    @ApiModelProperty(position = 11, value = " 限制用药：来自字典定义", required = true)
    private String xzyyCode;

    @ApiModelProperty(position = 11, value = " 限制用药：来自字典定义", readOnly = true)
    private String xzyyCode_to = "限制用药";


    @ApiModelProperty(position = 12, value = "自付比例（%）", required = true)
    private Double zfbl;
    @ApiModelProperty(position = 12, value = "自付比例（%）", readOnly = true)
    private String zfbl_to = "自付比例";

    @ApiModelProperty(position = 13, value = "精神类药：来自字典定义", required = true)
    private String jslyCode;

    @ApiModelProperty(position = 13, value = "精神类药：来自字典定义", readOnly = true)
    private String jslyCode_to = "精神类药";


    @ApiModelProperty(position = 14, value = "剂型：来自字典定义", required = true)
    private String jxCode;

    @ApiModelProperty(position = 14, value = "剂型：来自字典定义", readOnly = true)
    private String jxCode_to = "剂型";


    @ApiModelProperty(position = 15, value = "频次：来自字典定义", required = true)
    private String pcCode;
    @ApiModelProperty(position = 15, value = "频次：来自字典定义", readOnly = true)
    private String pcCode_to = "频次";

    @ApiModelProperty(position = 16, value = "给药方式：来自字典定义", required = true)
    private String gyfsCode;

    @ApiModelProperty(position = 16, value = "给药方式：来自字典定义", readOnly = true)
    private String gyfsCode_to = "给药方式";

    @ApiModelProperty(position = 17, value = "单次剂量", required = true)
    private String dcjl;
    @ApiModelProperty(position = 17, value = "单次剂量", readOnly = true)
    private String dcjl_to = "单次剂量";

    @ApiModelProperty(position = 18, value = "剂量单位：来自字典定义", required = true)
    private String jldwCode;

    @ApiModelProperty(position = 18, value = "剂量单位：来自字典定义", readOnly = true)
    private String jldwCode_to = "剂量单位";


    @ApiModelProperty(position = 19, value = "用药时间：来自字典定义", required = true)
    private String yysjCode;

    @ApiModelProperty(position = 19, value = "用药时间：来自字典定义", readOnly = true)
    private String yysjCode_to = "用药时间";

    @ApiModelProperty(position = 20, value = "使用说明", required = true)
    private String sysm;

    @ApiModelProperty(position = 20, value = "使用说明", readOnly = true)
    private String sysm_to = "使用说明";


    @ApiModelProperty(position = 21, value = "0' COMMENT '是否高危药品：1-是；0-否", required = true)
    private Integer isGw;

    @ApiModelProperty(position = 21, value = "0' COMMENT '是否高危药品：1-是；0-否", readOnly = true)
    private String isGw_to = "是否高危药品";


    @ApiModelProperty(position = 22, value = "0' COMMENT '是否麻醉药品：1-是；0-否", required = true)
    private Integer isMz;

    @ApiModelProperty(position = 22, value = "0' COMMENT '是否麻醉药品：1-是；0-否", readOnly = true)
    private String isMz_to = "是否麻醉药品";


    @ApiModelProperty(position = 23, value = "  是否毒性药品：1-是；0-否", required = true)
    private Integer isDx;


    @ApiModelProperty(position = 23, value = "  是否毒性药品：1-是；0-否", readOnly = true)
    private String isDx_to = "是否毒性药品";

    @ApiModelProperty(position = 24, value = " 0' COMMENT '是否人流药品：1-是；0-否", required = true)
    private Integer isRl;
    @ApiModelProperty(position = 24, value = " 0' COMMENT '是否人流药品：1-是；0-否", readOnly = true)
    private String isRl_to = "是否人流药品";

    @ApiModelProperty(position = 25, value = "  0' COMMENT '是否国家重点监控：1-是；0-否", required = true)
    private Integer isZdjkGj;

    @ApiModelProperty(position = 25, value = "  0' COMMENT '是否国家重点监控：1-是；0-否", readOnly = true)
    private String isZdjkGj_to = "是否国家重点监控";

    @ApiModelProperty(position = 26, value = " 是否省重点监控：1-是；0-否", required = true)
    private Integer isZdjkSf;

    @ApiModelProperty(position = 26, value = " 是否省重点监控：1-是；0-否", readOnly = true)
    private String isZdjkSf_to = "是否省重点监控";


    @ApiModelProperty(position = 27, value = " 0' COMMENT '是否医院重点监控：1-是；0-否", required = true)
    private Integer isZdjkYy;

    @ApiModelProperty(position = 27, value = " 0' COMMENT '是否医院重点监控：1-是；0-否", readOnly = true)
    private String isZdjkYy_to = "是否医院重点监控";

    @ApiModelProperty(position = 28, value = " 0' COMMENT '是否处方权药品：1-是；0-否", required = true)
    private Integer isCfq;


    @ApiModelProperty(position = 28, value = " 0' COMMENT '是否处方权药品：1-是；0-否", readOnly = true)
    private String isCfq_to = "是否处方权药品";

    @ApiModelProperty(position = 29, value = "  0' COMMENT '是否急诊处方药品：1-是；0-否", required = true)
    private Integer isJzcf;

    @ApiModelProperty(position = 29, value = "  0' COMMENT '是否急诊处方药品：1-是；0-否", readOnly = true)
    private String isJzcf_to = "是否急诊处方药品";

    @ApiModelProperty(position = 30, value = " 状态：1-启用；0-停用", required = true)
    private Integer status;
    @ApiModelProperty(position = 31, value = " 创建时间", readOnly = true)
    private Date createTime = new Date();
    @ApiModelProperty(position = 32, value = " 修改时间", readOnly = true)
    private Date updateTime = new Date();
    @ApiModelProperty(position = 33, value = "创建人", required = true)
    private Integer createUserId;
    @ApiModelProperty(position = 34, value = "修改人", required = true)
    private Integer updateUserId;
}
