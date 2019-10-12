package com.jsg.controller;

import com.jsg.base.result.ResultBase;
import com.jsg.entity.Dictionary;
import com.jsg.entity.DictionaryCatalog;
import com.jsg.entity.Pageable;
import com.jsg.service.DictionaryService;
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
 * @date 2019/10/8 18:36
 */
@RestController
@RequestMapping("/dictionary")
@Api(value = "/dictionary", tags = "字典管理")
@Slf4j
public class DictionaryController {
    @Autowired
    private DictionaryService dictionaryService;


    @ApiOperation(value = "添加字典类别", notes = "添加字典类别")
    @PostMapping(value = "add/dictionary-type", consumes = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase addDictionaryType(@RequestBody @Validated DictionaryCatalog dictionaryCatalog) {
        return dictionaryService.addDictionaryType(dictionaryCatalog);
    }


    @ApiOperation(value = "查询字典类别", notes = "查询字典类别")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "queryKey", value = "编码/名称", dataType = "string"),
            @ApiImplicitParam(name = "dictionaryCatalogId", value = "字典类别id", dataType = "int")
    })
    @PostMapping(value = "/list/dictionary-type", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase listDictionaryType(Integer dictionaryCatalogId, String queryKey, Pageable pageable) {
        return dictionaryService.listDictionaryType(dictionaryCatalogId, queryKey, pageable);
    }


    @ApiOperation(value = "删除字典类型", notes = "删除字典类型")
    @ApiImplicitParam(name = "dictionaryTypeId", value = "字典类型Id", dataType = "int")
    @PostMapping(value = "/del/dictionaryType", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase delDictionaryType(Integer dictionaryTypeId) {
        return dictionaryService.DelDictionaryType(dictionaryTypeId);
    }


    @ApiOperation(value = "编辑字典类型", notes = "系统管理-模块管理-编辑模块")
    @PostMapping(value = "/edi/dictionary-type", consumes = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase edi(@RequestBody DictionaryCatalog dictionaryCatalog) {
        return dictionaryService.ediDictionaryType(dictionaryCatalog);
    }


    @ApiOperation(value = "查询字典", notes = "查询字典")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "queryKey", value = "编码/名称", dataType = "string"),
            @ApiImplicitParam(name = "dictionaryCatalogId", value = "字典类别id", dataType = "int"),
            @ApiImplicitParam(name = "status", value = "是否启动", dataType = "int")
    })
    @PostMapping(value = "/list/dictionary", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase listDictionary(Integer dictionaryCatalogId, Integer status, String queryKey, Pageable pageable) {
        return dictionaryService.listDictionary(dictionaryCatalogId, status, queryKey, pageable);
    }


    @ApiOperation(value = "添加字典")
    @PostMapping(value = "add/dictionary", consumes = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase addDictionary(@RequestBody @Validated Dictionary dictionary) {
        return dictionaryService.addDictionary(dictionary);
    }


    @ApiOperation(value = "删除字典", notes = "删除字典")
    @ApiImplicitParams(
            {@ApiImplicitParam(name = "dictionaryId", value = "字典id", dataType = "int"),
                    @ApiImplicitParam(name = "dictionaryCatalogId", value = "字典类型", dataType = "int")
            })
    @PostMapping(value = "/del/dictionary", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase delDictionary(Integer dictionaryId, Integer dictionaryCatalogId) {
        return dictionaryService.delDictionary(dictionaryId, dictionaryCatalogId);
    }

    @ApiOperation(value = "编辑字典")
    @PostMapping(value = "/edi/dictionary", consumes = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase ediDictionary(@RequestBody Dictionary dictionary) {
        return dictionaryService.ediDictionary(dictionary);
    }
}
