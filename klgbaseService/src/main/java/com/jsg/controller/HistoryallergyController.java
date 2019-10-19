package com.jsg.controller;

import com.jsg.base.result.ResultBase;
import com.jsg.entity.Historyallergy;
import com.jsg.entity.Pageable;
import com.jsg.service.HistoryallergyService;
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
 * @date 2019/10/17 11:23
 */
@RestController
@RequestMapping("/historyallergy")
@Api(value = "/historyallergy", tags = "过敏史表")
@Slf4j
public class HistoryallergyController {
    @Autowired
    private HistoryallergyService historyallergyService;


    @ApiOperation(value = "添加过敏史")
    @PostMapping(value = "/add", consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase add(@RequestBody @Validated Historyallergy historyallergy) {
        return historyallergyService.add(historyallergy);
    }


    @ApiOperation(value = "检索列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "catalogId", value = "分类Id", dataType = "int"),
            @ApiImplicitParam(name = "queryKey", value = "编码/名称", dataType = "string"),

    })
    @PostMapping(value = "/list", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase list(Integer catalogId, String queryKey, Pageable pageable) {
        return historyallergyService.list(catalogId, queryKey, pageable);
    }

    @ApiOperation(value = "编辑过敏史")
    @PostMapping(value = "/edi", consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase edi(@RequestBody @Validated Historyallergy historyallergy) {
        return historyallergyService.edi(historyallergy);
    }

    @ApiOperation(value = "删除过敏史")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "historyallergyId", value = "对象id", dataType = "int"),
            @ApiImplicitParam(name = "catalogId", value = "分类id", dataType = "int")
    })
    @PostMapping(value = "/del", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase del(Integer historyallergyId, Integer catalogId) {
        return historyallergyService.del(historyallergyId, catalogId);
    }
}
