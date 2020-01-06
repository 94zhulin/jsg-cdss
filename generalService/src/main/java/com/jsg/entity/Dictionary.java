package com.jsg.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author jeanson 进生
 * @date 2019/10/8 20:10
 */
@Data
public class Dictionary {
    @ApiModelProperty(value = "字典ID")
    private Integer id;
    @NotNull(message = "type is notnull")
    @ApiModelProperty(position = 1, value = "字典类别ID", required = true)
    private Integer catalogId;
    @ApiModelProperty(position = 1, value = "字典类别Code", readOnly = true)
    private String catalogCode;
    @ApiModelProperty(position = 1, value = "字典类别Name", readOnly = true)
    private String catalogName;
    @NotNull(message = "type is notnull")
    @ApiModelProperty(position = 2, value = "字典名称", required = true)
    private String name;
    @NotNull(message = "type is notnull")
    @ApiModelProperty(position = 3, value = "字典编码", required = true)
    private String code;
    @NotNull(message = "type is notnull")
    @ApiModelProperty(position = 4, value = "状态", required = true)
    private Integer status;
    @ApiModelProperty(position = 5, value = "创建时间", readOnly = true)
    private Date createTime = new Date();
    @ApiModelProperty(position = 6, value = "修改时间", readOnly = true)
    private Date updateTime = new Date();
    @ApiModelProperty(position = 7, value = "创建人", required = true)
    private Integer createUserId;
    @ApiModelProperty(position = 8, value = "修改人", required = true)
    private Integer updateUserId;
}
