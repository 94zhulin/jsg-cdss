package com.jsg.controller;

import com.jsg.base.result.ResultBase;
import com.jsg.entity.Inspect;
import com.jsg.entity.Pageable;
import com.jsg.service.InspectService;
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
 * @date 2019/10/17 11:29
 */

@RestController
@RequestMapping("/inspect")
@Api(value = "/inspect", tags = "检查")
@Slf4j
public class InspectController {

    @Autowired
    private InspectService inspectService;

    @ApiOperation(value = "添加检查")
    @PostMapping(value = "/add", consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase add(@RequestBody @Validated Inspect inspect) {
        return inspectService.add(inspect);
    }

    @ApiOperation(value = "检索列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "catalogId", value = "分类Id", dataType = "int"),
            @ApiImplicitParam(name = "queryKey", value = "编码/名称", dataType = "string"),
            @ApiImplicitParam(name = "bw", value = "部位名称/编码", dataType = "string"),
            @ApiImplicitParam(name = "jcTypeCode", value = "检查类型：来自字典定义", dataType = "string"),
            @ApiImplicitParam(name = "yxFlagCode", value = "阳性标识：来自字典定义（多个值用逗号分隔）", dataType = "string")
    })
    @PostMapping(value = "/list", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase list(Integer catalogId, String queryKey, String bw, String jcTypeCode, String yxFlagCode, Pageable pageable) {
        return inspectService.list(catalogId, queryKey, bw, jcTypeCode, yxFlagCode, pageable);
    }

    @ApiOperation(value = "编辑检查")
    @PostMapping(value = "/edi", consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase edi(@RequestBody @Validated Inspect inspect) {
        return inspectService.edi(inspect);
    }

    @ApiOperation(value = "删除检查")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dinspectId", value = "检查对象", dataType = "int"),
            @ApiImplicitParam(name = "catalogId", value = "分类id", dataType = "int")
    })
    @PostMapping(value = "/del", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase del(Integer dinspectId, Integer catalogId) {
        return inspectService.del(dinspectId, catalogId);
    }
}
