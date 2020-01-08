package com.jsg.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author jeanson 进生
 * @date 2019/10/21 21:30
 */
@Data
public class Patients {
    @ApiModelProperty(position = 1, value = "知识库类别ID")
    private Integer typeId;
    @ApiModelProperty(position = 2, value = "项目id")
    private Integer itemId;
    @ApiModelProperty(position = 3, value = "例如 name = 年龄   则该字段的值为 年龄 ,用于然后给前端")
    private String itemName;
    @ApiModelProperty(position = 4, value = " 知识库属性值类型：1-布尔，2-数字，3-数字范围，4-日期，5-日期范围，6-文本，7-列表',")

    private Integer klgItemValueType;
    @ApiModelProperty(position = 5, value = "项目类别 1 人资 2 患者 3药品 4诊断 5检查 6校验 7过敏史")
    private Integer type;
    @ApiModelProperty(position = 6, value = "进行运算的字段名")
    private String name; //
    @ApiModelProperty(position = 7, value = "操作符顺序索引")
    private Integer opIndex; //
    @ApiModelProperty(position = 8, value = "最外层的比较符,  && 是与 ||是或")
    private Integer rootCompare; //
    @ApiModelProperty(position = 9, value = "开始 运算符")
    private String startOp; //
    @ApiModelProperty(position = 10, value = "开始值")
    private String startValue;//
    @ApiModelProperty(position = 11, value = "结束 运算符")
    private String endOp;//
    @ApiModelProperty(position = 12, value = "结束值")
    private String endValue; //
    @ApiModelProperty(position = 13, value = "结束时间")
    private Date endValueDate;//
    @ApiModelProperty(position = 14, value = "/开始时间")
    private Date startValueDate;
    @ApiModelProperty(position = 15, value = "")
    private Boolean result = false;
    @ApiModelProperty(position = 16, value = "")
    private String pinyin;
    @ApiModelProperty(position = 17, value = "开始值")
    private Boolean startValueBoo;
    @ApiModelProperty(position = 18, value = "开始值")
    private int startValueInt;
    @ApiModelProperty(position = 19, value = "开始值")
    private List<String> startValueList;//
    @ApiModelProperty(position = 20, value = "结束值")
    private Boolean endValueBoo;
    @ApiModelProperty(position = 21, value = "结束值")
    private int endValueInt;
    @ApiModelProperty(position = 22, value = "结束值")
    private List<String> endValueList;


}
