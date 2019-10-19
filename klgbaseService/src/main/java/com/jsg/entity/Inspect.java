package com.jsg.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author jeanson 进生
 * @date 2019/10/17 9:54
 */
@Data
public class Inspect {
    @ApiModelProperty(position = 1, value = "主键Id")
    private Integer id;
    @ApiModelProperty(position = 2, value = "知识库类别ID", required = true)
    private Integer catalogId;
    @ApiModelProperty(position = 3, value = "项目名称", required = true)
    private String xmName;
    @ApiModelProperty(position = 4, value = "项目编码", required = true)
    private String xmCode;
    @ApiModelProperty(position = 5, value = "部位名称", required = true)
    private String bwName;
    @ApiModelProperty(position = 6, value = "部位编码", required = true)
    private String bwCode;
    @ApiModelProperty(position = 7, value = " 检查类型：来自字典定义", required = true)
    private String jcTypeCode;
    @ApiModelProperty(position = 8, value = "阳性标识：来自字典定义（多个值用逗号分隔）", required = true)
    private String yxFlagCode;
    @ApiModelProperty(position = 9, value = "适应症", required = true)
    private String syz;
    @ApiModelProperty(position = 10, value = "禁忌症", required = true)
    private String jjz;
    @ApiModelProperty(position = 11, value = "状态：1-启用；0-停用", required = true)
    private Integer status;
    @ApiModelProperty(position = 12, value = "创建时间", readOnly = true)
    private Date createTime = new Date();
    @ApiModelProperty(position = 13, value = "修改时间", readOnly = true)
    private Date updateTime = new Date();
    @ApiModelProperty(position = 14, value = "创建人", required = true)
    private Integer createUserId;
    @ApiModelProperty(position = 15, value = "修改人", required = true)
    private Integer updateUserId;
}
