package com.jsg.controller;

import com.jsg.base.result.ResultBase;
import com.jsg.entity.Pageable;
import com.jsg.entity.Properties;
import com.jsg.service.PropertiesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

/**
 * @author jeanson 进生
 * @date 2019/10/8 18:36
 */
@RestController
@RequestMapping("/properties")
@Api(value = "/properties", tags = "属性管理模块")
@Slf4j
public class PropertiesController {

    @Autowired
    private PropertiesService propertiesService;

    @ApiOperation(value = "属性列表", notes = "返回所有的属性列表数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "queryKey", value = "属性名/值", dataType = "string"),
            @ApiImplicitParam(name = "status", value = "是否启用", dataType = "int"),
    })
    @PostMapping(value = "/list", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase list(String queryKey, Integer status, Pageable pageable) {
        return propertiesService.list(queryKey, status, pageable);
    }

    @ApiOperation(value = "删除属性", notes = "删除属性")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "propName", value = "属性名", dataType = "string")})
    @PostMapping(value = "/del", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase del(@RequestParam("propName") String propName) {
        return propertiesService.del(propName);
    }


    @ApiOperation(value = "新增属性", notes = "新增属性")
    @PostMapping(value = "/add", consumes = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase add(@RequestBody @Validated Properties properties) {
        return propertiesService.add(properties);
    }


    @ApiOperation(value = "编辑属性", notes = "编辑属性")
    @PostMapping(value = "/edi", consumes = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase edi(@RequestBody Properties properties) {
        return propertiesService.edi(properties);
    }

    @ApiOperation(value = "根据属性名获取属性列表", notes = "可用于查询属性名是否唯一")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "propName", value = "属性名", dataType = "string")})
    @PostMapping(value = "/query-name", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase selectByPropName(@RequestParam("propName") String propName) {
        return propertiesService.selectByPropName(propName);
    }

}
