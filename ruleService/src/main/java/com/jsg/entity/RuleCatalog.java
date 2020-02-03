package com.jsg.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author jeanson 进生
 * @date 2019/10/21 10:44
 */
@Data
public class RuleCatalog {

    //  @NotNull(message = "type is notnull")
    @ApiModelProperty(position = 1, value = "规则类别ID")
    private Integer id;

    @ApiModelProperty(position = 2, value = "类别编码", required = true)
    private String code;

    @ApiModelProperty(position = 3, value = "父类别ID", required = true)
    private Integer parentId;

    @ApiModelProperty(position = 4, value = "类别名称", required = true)
    private String name;
    @ApiModelProperty(position = 4, value = "类别名称", readOnly = true)
    private String label;

    @ApiModelProperty(position = 5, value = "层级", required = true)
    private Integer level;


    @ApiModelProperty(position = 6, value = "排序索引", required = true)
    private Integer orderIndex;


    @ApiModelProperty(position = 7, value = "子类别数量", required = true)
    private Integer childNum;


    @ApiModelProperty(position = 8, value = "规则数量", required = true)
    private Integer ruleNum;

    @ApiModelProperty(position = 8, value = "状态：1-启用；0-停用", required = true)
    private Integer status;

    @ApiModelProperty(position = 4, value = "创建时间", readOnly = true)
    private Date createTime;

    @ApiModelProperty(position = 4, value = "修改时间", readOnly = true)
    private Date updateTime;
    @ApiModelProperty(position = 8, value = "创建人", required = true)
    private Integer createUserId;

    @ApiModelProperty(position = 8, value = "修改人", required = true)
    private Integer updateUserid;

    private List<RuleCatalog> children;

}