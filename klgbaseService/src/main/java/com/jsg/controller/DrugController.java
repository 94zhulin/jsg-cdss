package com.jsg.controller;

import com.jsg.base.result.ResultBase;
import com.jsg.entity.Drug;
import com.jsg.entity.Pageable;
import com.jsg.service.DrugService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

/**
 * @author jeanson 进生
 * @date 2019/10/17 10:30
 */
@RestController
@RequestMapping("/drug")
@Api(value = "/drug", tags = "药品")
@Slf4j
public class DrugController {
    @Autowired
    private DrugService drugService;


    @ApiOperation(value = "添加药品")
    @PostMapping(value = "/add", consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase add(@RequestBody @Validated Drug drug) {
        return drugService.add(drug);
    }


    @ApiOperation(value = "检索列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "catalogId", value = "分类Id", dataType = "int"),
            @ApiImplicitParam(name = "queryKey", value = "编码/名称", dataType = "string"),
            @ApiImplicitParam(name = "jxCode", value = "剂型：来自字典定义", dataType = "string"),
            @ApiImplicitParam(name = "pcCode", value = "频次：来自字典定义", dataType = "string"),
            @ApiImplicitParam(name = "gyfsCode", value = "给药方式：来自字典定义", dataType = "string"),
            @ApiImplicitParam(name = "yysjCode", value = "用药时间：来自字典定义", dataType = "string"),
    })
    @PostMapping(value = "/list", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase list(Integer catalogId, String queryKey, String jxCode, String pcCode, String gyfsCode, String yysjCode, Pageable pageable) {
        return drugService.list(catalogId,queryKey, jxCode, pcCode, gyfsCode, yysjCode, pageable);
    }

    @ApiOperation(value = "编辑药品")
    @PostMapping(value = "/edi", consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase edi(@RequestBody @Validated Drug drug) {
        return drugService.edi(drug);
    }

    @ApiOperation(value = "删除药品")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "drugId", value = "药品对象", dataType = "int"),
            @ApiImplicitParam(name = "catalogId", value = "分类id", dataType = "int")
    })
    @PostMapping(value = "/del", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase del(Integer drugId, Integer catalogId) {
        return drugService.del(drugId, catalogId);
    }
}
