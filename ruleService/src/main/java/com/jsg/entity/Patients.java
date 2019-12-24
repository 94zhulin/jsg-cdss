package com.jsg.entity;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author jeanson 进生
 * @date 2019/10/21 21:30
 */
@Data
public class Patients {
    private Integer typeId; //知识库类别ID
    private Integer itemId; //项目id
    private String itemName;// 项目名  例如 name = 年龄   则该字段的值为 年龄 ,用于然后给前端
    private Integer klgItemValueType; //知识库属性值类型：1-布尔，2-数字，3-数字范围，4-日期，5-日期范围，6-文本，7-列表',
    private Integer type; //项目类别 1 人资 2 患者 3药品 4诊断 5检查 6校验 7过敏史
    private String name; // 进行运算的字段名
    private Integer opIndex; // 操作符顺序索引
    private Integer rootCompare; // 最外层的比较符,  1是与 0是或
    private String startOp; //开始 运算符
    private String startValue;//开始值
    private String endOp;// 结束 运算符
    private String endValue; //结束值
    private Date endValueDate;//结束时间
    private Date startValueDate;//开始时间
    private Boolean result = false;
    private String pinyin;
    //知识库属性值类型：1-布尔，2-数字，3-数字范围，4-日期，5-日期范围，6-文本，7-列表',
    private Boolean startValueBoo;//开始值
    private int startValueInt;//开始值
    private List<String> startValueList;//开始值
    private Boolean endValueBoo;//结束值
    private int endValueInt;//结束值
    private List<String> endValueList;//结束值


}
