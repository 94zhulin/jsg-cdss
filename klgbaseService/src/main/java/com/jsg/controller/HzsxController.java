package com.jsg.controller;

import com.jsg.base.result.ResultBase;
import com.jsg.entity.Hzsx;
import com.jsg.entity.Pageable;
import com.jsg.service.HzsxService;
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
 * @date 2019/10/17 11:26
 */
@RestController
@RequestMapping("/hzsx")
@Api(value = "/hzsx", tags = "患者属性表")
@Slf4j
public class HzsxController {

    @Autowired
    private HzsxService hzsxService;

    @ApiOperation(value = "添加患者")
    @PostMapping(value = "/add", consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase add(@RequestBody @Validated Hzsx hzsx) {
        return hzsxService.add(hzsx);
    }

    @ApiOperation(value = "检索列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "catalogId", value = "分类Id", dataType = "int", required = true),
            @ApiImplicitParam(name = "queryKey", value = "编码/名称", dataType = "string"),
            @ApiImplicitParam(name = "valueType", value = "数值类型", dataType = "int"),
    })
    @PostMapping(value = "/list", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase list(Integer catalogId, String queryKey, Integer valueType, Pageable pageable) {
        return hzsxService.list(catalogId, queryKey, valueType, pageable);
    }

    @ApiOperation(value = "编辑患者")
    @PostMapping(value = "/edi", consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase edi(@RequestBody @Validated Hzsx hzsx) {
        return hzsxService.edi(hzsx);
    }

    @ApiOperation(value = "删除患者")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "hzsxId", value = "患者ID", dataType = "int"),
            @ApiImplicitParam(name = "catalogId", value = "分类id", dataType = "int")
    })
    @PostMapping(value = "/del", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase del(Integer hzsxId, Integer catalogId) {
        return hzsxService.del(hzsxId, catalogId);
    }
}
