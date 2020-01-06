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
    @ApiModelProperty(position = 1, value = "主键Id")
    private Integer id;
    @ApiModelProperty(position = 2, value = "    知识库类别ID", required = true)
    private Integer catalogId;
    @ApiModelProperty(position = 3, value = "    项目名称", required = true)
    private String xmName;
    @ApiModelProperty(position = 4, value = "    项目编码", required = true)
    private String xmCode;
/*    @ApiModelProperty(position = 5, value = "项目类型:来自字典表定义", required = true)
    private String xmlxCode;*/
    @ApiModelProperty(position = 6, value = "    检验方法：来自字典表定义", required = true)
    private String jyffCode;
    @ApiModelProperty(position = 7, value = "    样本类型：来自字典表定义", required = true)
    private String yblxCode;
    @ApiModelProperty(position = 8, value = "     检验类别：来自字典定义", required = true)
    private String jyTypeCode;
    @ApiModelProperty(position = 9, value = "    采集部位", required = true)
    private String cjbw;
    @ApiModelProperty(position = 10, value = "    结果计量单位：来自字典表定义", required = true)
    private String jgjldwCode;
    @ApiModelProperty(position = 11, value = "    结果正常标识：来自字典表定义（多个值用逗号分隔）", required = true)
    private String jgzcbsCode;
    @ApiModelProperty(position = 12, value = "    开始参考值", required = true)
    private Double startCkz;
    @ApiModelProperty(position = 13, value = "    结束参考值", required = true)
    private Double endCkz;
    @ApiModelProperty(position = 14, value = "     适应症", required = true)
    private String syz;
    @ApiModelProperty(position = 15, value = "    禁忌症", required = true)
    private String jjz;
    @ApiModelProperty(position = 16, value = "    状态：1-启用；0-停用", required = true)
    private Integer status;
    @ApiModelProperty(position = 17, value = "     创建时间", readOnly = true)
    private Date createTime = new Date();
    @ApiModelProperty(position = 18, value = "    修改时间", readOnly = true)
    private Date updateTime = new Date();
    @ApiModelProperty(position = 19, value = "    创建人", required = true)
    private Integer createUserId;
    @ApiModelProperty(position = 20, value = "    修改人", required = true)
    private Integer updateUserId;
}
