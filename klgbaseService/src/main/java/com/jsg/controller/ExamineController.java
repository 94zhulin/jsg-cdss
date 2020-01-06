package com.jsg.controller;

import com.jsg.base.result.ResultBase;
import com.jsg.entity.Examine;
import com.jsg.entity.Pageable;
import com.jsg.service.ExamineService;
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
@RequestMapping("/examine")
@Api(value = "/examine", tags = "检验表")
@Slf4j
public class ExamineController {
    @Autowired
    private ExamineService examineService;

    @ApiOperation(value = "添加检验")
    @PostMapping(value = "/add", consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase add(@RequestBody @Validated Examine examine) {
        return examineService.add(examine);
    }

    @ApiOperation(value = "检索列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "catalogId", value = "分类Id", dataType = "int"),
            @ApiImplicitParam(name = "queryKey", value = "编码/名称", dataType = "string"),
/*            @ApiImplicitParam(name = "xmlxCode", value = "项目类型：来自字典表定义", dataType = "string"),*/
            @ApiImplicitParam(name = "jyTypeCode", value = "检验类别：来自字典定义", dataType = "string"),
            @ApiImplicitParam(name = "yblxCode", value = "样本类型：来自字典表定义", dataType = "string"),
    })
    @PostMapping(value = "/list", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase list(Integer catalogId ,String queryKey, String xmlxCode, String jyTypeCode, String yblxCode, Pageable pageable) {
        return examineService.list(catalogId , queryKey, xmlxCode, jyTypeCode, yblxCode, pageable);
    }

    @ApiOperation(value = "编辑检验")
    @PostMapping(value = "/edi", consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase edi(@RequestBody @Validated Examine examine) {
        return examineService.edi(examine);
    }

    @ApiOperation(value = "删除检验")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "examineId", value = "药品对象", dataType = "int"),
            @ApiImplicitParam(name = "catalogId", value = "分类id", dataType = "int")
    })
    @PostMapping(value = "/del", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase del(Integer examineId, Integer catalogId) {
        return examineService.del(examineId, catalogId);
    }
}
