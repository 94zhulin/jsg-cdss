package com.jsg.controller;

/**
 * @author jeanson 进生
 * @date 2019/10/26 17:14
 */

import com.jsg.base.result.ResultBase;
import com.jsg.service.DroolsService;
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
 * generla
 *
 * @author jeanson 进生
 * @date 2019/10/21 10:12
 */
@RestController
@RequestMapping("/login")
@Api(value = "/login", tags = "通用的小接口")
@Slf4j
public class DroolsController {


    @Autowired
    private DroolsService droolsService;

    @ApiOperation(value = "进行规则运算")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ruleName", value = "规则名称", dataType = "String"),
            @ApiImplicitParam(name = "ruleId", value = "规则id", dataType = "String")
    })
    @PostMapping(value = "/operation", consumes = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase operation(String ruleName, String ruleId) {
        log.info("functionName:{}    Url:{}  parameter:{} ", "规则运算", "/login", ruleName, ruleName);
        return droolsService.operation(ruleName, ruleId);
    }


    @ApiOperation(value = "规则生成")
    @PostMapping(value = "/rule-generate", consumes = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase ruleGenerate() {
        return null;
    }

}
