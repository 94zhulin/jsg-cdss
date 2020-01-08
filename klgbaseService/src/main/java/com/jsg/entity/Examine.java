package com.jsg.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author jeanson 进生
 * @date 2019/10/17 9:46
 */
@Data
public class Examine {

    @ApiModelProperty(position = 3, value = "    项目名称", required = true)
    private String xmName;

    @ApiModelProperty(position = 3, value = "    项目名称", readOnly = true)
    private String xmName_to = "项目名称";

    @ApiModelProperty(position = 4, value = "    项目编码", required = true)
    private String xmCode;

    @ApiModelProperty(position = 4, value = "    项目编码", readOnly = true)
    private String xmCode_to = "项目编码";


    @ApiModelProperty(position = 8, value = "     检验类别：来自字典定义", required = true)
    private String jyTypeCode;


    @ApiModelProperty(position = 8, value = "     检验类别：来自字典定义", readOnly = true)
    private String jyTypeCode_to = "检验类别";


    @ApiModelProperty(position = 9, value = "    采集部位", required = true)
    private String cjbw;

    @ApiModelProperty(position = 9, value = "    采集部位", readOnly = true)
    private String cjbw_to = "采集部位";

    @ApiModelProperty(position = 10, value = "    结果计量单位：来自字典表定义", required = true)
    private String jgjldwCode;

    @ApiModelProperty(position = 10, value = "    结果计量单位：来自字典表定义", readOnly = true)
    private String jgjldwCode_to = "结果计量单位";

    @ApiModelProperty(position = 11, value = "    结果正常标识：来自字典表定义（多个值用逗号分隔）", required = true)
    private String jgzcbsCode;

    @ApiModelProperty(position = 11, value = "    结果正常标识：来自字典表定义（多个值用逗号分隔）", readOnly = true)
    private String jgzcbsCode_to = "结果正常标识";


    @ApiModelProperty(position = 12, value = "    开始参考值", required = true)
    private Double startCkz;
    @ApiModelProperty(position = 12, value = "    开始参考值", readOnly = true)
    private String startCkz_to = "开始参考值";

    @ApiModelProperty(position = 13, value = "    结束参考值", required = true)
    private Double endCkz;
    @ApiModelProperty(position = 13, value = "    结束参考值", readOnly = true)
    private String endCkz_to = "结束参考值";

    @ApiModelProperty(position = 14, value = "     适应症", required = true)
    private String syz;
    @ApiModelProperty(position = 14, value = "     适应症", readOnly = true)
    private String syz_to = "适应症";

    @ApiModelProperty(position = 15, value = "    禁忌症", required = true)
    private String jjz;
    @ApiModelProperty(position = 15, value = "    禁忌症", readOnly = true)
    private String jjz_to = "禁忌症";


    @ApiModelProperty(position = 16, value = "    送检要求", required = true)
    private String sjyq;

    @ApiModelProperty(position = 17, value = "    送检要求", readOnly = true)
    private String sjyq_to = "送检要求";

    @ApiModelProperty(position = 17, value = "    临床意义", required = true)
    private String lcyy;
    private String lcyy_to = "临床意义";


    @ApiModelProperty(position = 17, value = "    LIS检验明细编码", required = true)
    private String lisJymxBm;
    private String lisJymxBm_to = "LIS检验明细编码";


    @ApiModelProperty(position = 17, value = "    检验方法", required = true)
    private String jyff;
    private String jyff_to = "检验方法";


    @ApiModelProperty(position = 17, value = "    样本类型", required = true)
    private String yblx;
    private String yblx_to = "样本类型";

    @ApiModelProperty(position = 17, value = "    开始参考值(成人男)", required = true)
    private Double startCkzNan;
    private String startCkzNan_to = "开始参考值(成人男)";


    @ApiModelProperty(position = 17, value = " 结束参考值(成人男)", required = true)
    private Double endCkzNan;
    private String endCkzNan_to = "结束参考值(成人男)";


    @ApiModelProperty(position = 17, value = " 开始参考值(成人女)", required = true)
    private Double startCkzNv;
    private String startCkzNv_to = "开始参考值(成人女)";

    @ApiModelProperty(position = 17, value = " 结束参考值(成人女)", required = true)
    private Double endCkzNv;
    private String endCkzNv_to = "结束参考值(成人女)";

    @ApiModelProperty(position = 17, value = " 开始参考值(儿童)", required = true)
    private Double startCkzEt;
    private String startCkzEt_to = "开始参考值(儿童)";

    @ApiModelProperty(position = 17, value = " 结束参考值(儿童)", required = true)
    private Double endCkzEt;
    private String endCkzEt_to = "结束参考值(儿童)";

    @ApiModelProperty(position = 17, value = " 开始参考值(新生儿)", required = true)
    private Double startCkzXse;
    private String startCkzXse_to = "开始参考值(新生儿)";
    @ApiModelProperty(position = 17, value = "结束参考值(新生儿)", required = true)
    private Double endCkzXse;
    private String endCkzXse_to = "结束参考值(新生儿)";

    @ApiModelProperty(position = 17, value = " 开始参考值(婴儿)", required = true)
    private Double startCkzYe;
    private String startCkzYe_to = "开始参考值(婴儿)";

    @ApiModelProperty(position = 17, value = " 结束参考值(婴儿)", required = true)
    private Double endCkzYe;
    private String endCkzYe_to = "结束参考值(婴儿)";

    @ApiModelProperty(position = 18, value = "    状态：1-启用；0-停用", required = true)
    private Integer status;
    @ApiModelProperty(position = 19, value = "     创建时间", readOnly = true)
    private Date createTime = new Date();
    @ApiModelProperty(position = 20, value = "    修改时间", readOnly = true)
    private Date updateTime = new Date();
    @ApiModelProperty(position = 21, value = "    创建人", required = true)
    private Integer createUserId;
    @ApiModelProperty(position = 22, value = "    修改人", required = true)
    private Integer updateUserId;
}
