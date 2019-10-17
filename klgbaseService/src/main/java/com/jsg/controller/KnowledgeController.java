package com.jsg.controller;

/**
 * @author jeanson 进生
 * @date 2019/10/17 10:56
 */

import com.jsg.base.result.ResultBase;
import com.jsg.entity.Catalog;
import com.jsg.entity.Pageable;
import com.jsg.service.KnowledgeService;
import io.swagger.annotations.Api;
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
@RequestMapping("/knowledge")
@Api(value = "/knowledge", tags = "知识库")
@Slf4j
public class KnowledgeController {


    @Autowired
    private KnowledgeService knowledgeService;


    @ApiOperation(value = "添加新的分类")
    @PostMapping(value = "/add-class", consumes = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase addClass(@RequestBody @Validated Catalog catalog) {
        return knowledgeService.addClass(catalog);
    }

    @ApiOperation(value = "编辑分类")
    @PostMapping(value = "/edi-class", consumes = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase ediClass(@RequestBody @Validated Catalog catalog) {
        return knowledgeService.ediClass(catalog);
    }

    @ApiOperation(value = "全部分类列表")
    @PostMapping(value = "/list/class", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase list(Pageable pageable) {
        return knowledgeService.classList(pageable);
    }


}
