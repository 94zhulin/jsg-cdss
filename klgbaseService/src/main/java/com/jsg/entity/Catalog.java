package com.jsg.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author jeanson 进生
 * @date 2019/10/17 9:34
 */
@Data
public class Catalog {
    @ApiModelProperty(position = 0, value = "    知识库类别ID")
    private Integer id;
    @ApiModelProperty(position = 1, value = "    父类别ID", required = true)
    private Integer parentId;
    @ApiModelProperty(position = 2, value = "    类别名称", required = true)
    private String name;
    @ApiModelProperty(position = 2, value = "    类别名称label", readOnly = true)
    private String label;
    @ApiModelProperty(position = 3, value = "    类别编码", required = true)
    private String code;
    @ApiModelProperty(position = 4, value = "    层级", required = true)
    private Integer level;
    @ApiModelProperty(position = 5, value = "    排序索引", required = true)
    private Integer orderIndex;
    @ApiModelProperty(position = 6, value = "    子类别数量", required = true)
    private Integer childNum = 0;
    @ApiModelProperty(position = 7, value = "    知识项数量", required = true)
    private Integer itemNum = 0;
    @ApiModelProperty(position = 8, value = "    状态：1-启用；0-停用", required = true)
    private Integer status;
    @ApiModelProperty(position = 9, value = "    创建时间", readOnly = true)
    private Date createTime = new Date();
    @ApiModelProperty(position = 10, value = "    修改时间", readOnly = true)
    private Date updateTime = new Date();
    @ApiModelProperty(position = 11, value = "    创建人", required = true)
    private Integer createUserId;
    @ApiModelProperty(position = 12, value = "    修改人", required = true)
    private Integer updateUserId;
    @ApiModelProperty(position = 13, value = "    子目录", readOnly = true)
    private List<Catalog> children;
}
