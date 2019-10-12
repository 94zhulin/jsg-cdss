package com.jsg.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author jeanson 进生
 * @date 2019/10/8 20:11
 */
@Data
public class DictionaryCatalog {
    @ApiModelProperty(value = "字典类别ID")
    private Integer id;
    @NotNull(message = "type is notnull")
    @ApiModelProperty(position = 1, value = "父类别ID", required = true)
    private Integer parentId;
    @NotNull(message = "type is notnull")
    @ApiModelProperty(position = 2, value = "字典类别名称", required = true)
    private String name;
    @NotNull(message = "type is notnull")
    @ApiModelProperty(position = 3, value = "字典类别编码", required = true)
    private String code;
    @NotNull(message = "type is notnull")
    @ApiModelProperty(position = 4, value = "'层级'", required = true)
    private Integer level;
    @NotNull(message = "type is notnull")
    @ApiModelProperty(position = 5, value = "排序索引", required = true)
    private Integer orderIndex;
    @ApiModelProperty(position = 4, value = "子类别数量")
    private Integer childNum = 0;
    @ApiModelProperty(position = 5, value = "字典数量")
    private Integer dictNum = 0;
    @NotNull(message = "type is notnull")
    @ApiModelProperty(position = 6, value = "状态：1-启用；0-停用", required = true)
    private Integer status;
    @ApiModelProperty(position = 7, value = "创建时间", readOnly = true)
    private Date createTime = new Date();
    @ApiModelProperty(position = 8, value = "修改时间", readOnly = true)
    private Date updateTime = new Date();
    @NotNull(message = "type is notnull")
    @ApiModelProperty(position = 9, value = "创建人", required = true)
    private Integer createUserId;
    @NotNull(message = "type is notnull")
    @ApiModelProperty(position = 10, value = "修改人", required = true)
    private Integer updateUserId;
}
