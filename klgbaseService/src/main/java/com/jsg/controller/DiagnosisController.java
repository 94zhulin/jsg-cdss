package com.jsg.controller;

/**
 * @author jeanson 进生
 * @date 2019/10/17 11:17
 */

import com.jsg.base.result.ResultBase;
import com.jsg.entity.Diagnosis;
import com.jsg.entity.Pageable;
import com.jsg.service.DiagnosisService;
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
@RequestMapping("/diagnosis")
@Api(value = "/diagnosis", tags = "诊断")
@Slf4j
public class DiagnosisController {

    @Autowired
    private DiagnosisService diagnosisService;

    @ApiOperation(value = "添加诊断信息")
    @PostMapping(value = "/add", consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase add(@RequestBody @Validated Diagnosis diagnosis) {
        return diagnosisService.add(diagnosis);
    }


    @ApiOperation(value = "检索列表", notes = "可检索的模块列表接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "catalogId", value = "分类Id", dataType = "int"),
            @ApiImplicitParam(name = "queryKey", value = "编码/名称", dataType = "string"),
            @ApiImplicitParam(name = "type", value = "类别：来自字典定义", dataType = "int"),
            @ApiImplicitParam(name = "zzd_flag_code", value = "主诊断标志：来自字典定义", dataType = "string"),
    })
    @PostMapping(value = "/list", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase list(Integer catalogId, String queryKey, Integer type, String zzd_flag_code, Pageable pageable) {
        return diagnosisService.list(catalogId, queryKey, type, zzd_flag_code, pageable);
    }

    @ApiOperation(value = "编辑诊断信息")
    @PostMapping(value = "/edi", consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase edi(@RequestBody @Validated Diagnosis diagnosis) {
        return diagnosisService.edi(diagnosis);
    }

    @ApiOperation(value = "删除诊断信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "diagnosisId", value = "诊断对象Id", dataType = "int"),
            @ApiImplicitParam(name = "catalogId", value = "分类id", dataType = "int")
    })
    @PostMapping(value = "/del", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase del(Integer diagnosisId, Integer catalogId) {
        return diagnosisService.del(diagnosisId, catalogId);
    }


}