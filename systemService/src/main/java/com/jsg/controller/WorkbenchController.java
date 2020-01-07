package com.jsg.controller;

import com.jsg.base.result.ResultBase;
import com.jsg.entity.Pageable;
import com.jsg.service.WorkbenchService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

/**
 * @author jeanson 进生
 * @date 2020/1/7 9:17
 */
@RestController
@RequestMapping("/workbench")
@Api(value = "/workbench", tags = "工作台")
@Slf4j
public class WorkbenchController {
    @Autowired
    private WorkbenchService workbenchService;

    @ApiOperation(value = "快捷入口")
    @PostMapping(value = "/quick-entry", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase quickEntry() {
        return workbenchService.quickEntry();
    }

    @ApiOperation(value = "访问日志统计分析")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "queryKey", value = "规则名称", dataType = "string"),
            @ApiImplicitParam(name = "ruleType", value = "规则类别", dataType = "string"),
            @ApiImplicitParam(name = "startTime", value = "开始日期", dataType = "string"),
            @ApiImplicitParam(name = "endTime", value = "结束日期", dataType = "string"),
    })
    @PostMapping(value = "/log-statistical-analysis-entry/list", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase logByList(String queryKey, String ruleType, String startTime, String endTime) {
        return workbenchService.logByList(queryKey, ruleType, startTime, endTime);
    }


    @ApiOperation(value = "日志列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "resultName", value = "决策结果", dataType = "string"),
            @ApiImplicitParam(name = "ruleName", value = "规则名称", dataType = "string"),
            @ApiImplicitParam(name = "appCode", value = "应用名称", dataType = "string"),
            @ApiImplicitParam(name = "clientType", value = "用户终端类型：1-PC；2-移动端（手机）；3-移动端（iPad）；99-其他", dataType = "string"),
            @ApiImplicitParam(name = "ruleCatalogName", value = "规则类别", dataType = "string"),
    })
    @PostMapping(value = "/list", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase list(String resultName, String ruleName, String appCode, String clientType, String ruleCatalogName, Pageable pageable) {
        return workbenchService.list(resultName, ruleName, appCode, clientType, ruleCatalogName, pageable);
    }


    @ApiOperation(value = "访问日志统计分析")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "startTime", value = "开始日期", dataType = "string"),
            @ApiImplicitParam(name = "endTime", value = "结束日期", dataType = "string")
    })
    @PostMapping(value = "/bar-chart", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase barChart(String startTime, String endTime) {
        return workbenchService.barChart(startTime, endTime);
    }


}
