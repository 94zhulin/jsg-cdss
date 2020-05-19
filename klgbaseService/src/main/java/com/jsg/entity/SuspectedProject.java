package com.jsg.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class SuspectedProject<T> {
    @ApiModelProperty(position = 1, value = "项目类别 1 人资 2 患者 3药品 4诊断 5检查 6校验 7过敏史", required = true)
    private String   xmlb ;
    private String  titleOne;
    private String  titleTo;
    private String  titleThree;
    private String  titleFour;
    private String titleFive ;
    private List<T> datas ;

}
