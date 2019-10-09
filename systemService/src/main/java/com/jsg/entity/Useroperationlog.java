package com.jsg.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author jeanson 进生
 * @date 2019/10/9 9:39
 */
@Data
public class Useroperationlog {
    @ApiModelProperty(value = "日志ID")
    private Integer id;
    @ApiModelProperty(position = 1, value = "用户ID", readOnly = true)
    private Integer userId;
    @ApiModelProperty(position = 2, value = "用户IP", readOnly = true)
    private String IP;
    @ApiModelProperty(position = 3, value = "操作时间", readOnly = true)
    private Date operationTime;
    @ApiModelProperty(position = 4, value = "操作名称", readOnly = true)
    private String operationName;
    @ApiModelProperty(position = 5, value = "URL", readOnly = true)
    private String url;
    @ApiModelProperty(position = 6, value = "用户终端类型：1-PC；2-移动端（手机）；3-移动端（iPad）；99-其他", readOnly = true)
    private Integer clientType;
    @ApiModelProperty(position = 7, value = "浏览器类型", readOnly = true)
    private String browserType;
    @ApiModelProperty(position = 8, value = "浏览器名称", readOnly = true)
    private String browserName;
    @ApiModelProperty(position = 9, value = "浏览器版本号", readOnly = true)
    private String browserVersion;
    @ApiModelProperty(position = 10, value = "0' COMMENT '手机类型：99-其他；1-apple；2-华为；3-小米；4-Vivo；5-Oppo；6-魅族；7-三星；8-一加；9-努比亚；", readOnly = true)
    private Integer mobileType;
    @ApiModelProperty(position = 11, value = "0' COMMENT '手机系统类型：1-安卓；2-Apple；3-Windows；99-其他", readOnly = true)
    private Integer mobileSystemType;
    @ApiModelProperty(position = 12, value = "' COMMENT '手机系统版本", readOnly = true)
    private String mobileSystemVersion;

}
