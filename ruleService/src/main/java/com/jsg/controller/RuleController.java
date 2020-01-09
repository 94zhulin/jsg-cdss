package com.jsg.controller;

import com.github.stuxuhai.jpinyin.PinyinException;
import com.jsg.base.result.ResultBase;
import com.jsg.entity.Pageable;
import com.jsg.entity.RuleBase;
import com.jsg.entity.RuleCatalog;
import com.jsg.service.RuleService;
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

import java.io.UnsupportedEncodingException;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

/**
 * @author jeanson 进生
 * @date 2019/10/21 10:12
 */

@RestController
@RequestMapping("/rule")
@Api(value = "/rule", tags = "规则模块")
@Slf4j
public class RuleController {


    @Autowired
    private RuleService ruleService;


    @ApiOperation(value = "添加新的分类")
    @PostMapping(value = "/add-class", consumes = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase addClass(@RequestBody @Validated RuleCatalog catalog) {
        return ruleService.addClass(catalog);
    }

    @ApiOperation(value = "编辑分类")
    @PostMapping(value = "/edi-class", consumes = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase ediClass(@RequestBody @Validated RuleCatalog catalog) {
        return ruleService.ediClass(catalog);
    }

    @ApiOperation(value = "全部分类列表")
    @PostMapping(value = "/list/class", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase list(String parentId, Pageable pageable) {
        return ruleService.classList(parentId, pageable);
    }


    @ApiOperation(value = "删除分类")
    @ApiImplicitParam(name = "catalogId", value = "分类Id", dataType = "int")
    @PostMapping(value = "/del", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase addClass(Integer catalogId) {
        return ruleService.del(catalogId);
    }


    @ApiOperation(value = "添加规则")
    @PostMapping(value = "/add-rule", consumes = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase addRule(@RequestBody @Validated RuleBase ruleBase) {
        ResultBase resultBase = new ResultBase();
        try {
            resultBase = ruleService.addRule(ruleBase);
        } catch (PinyinException e) {
            e.printStackTrace();
            resultBase.setStatus(500);
            resultBase.setMsg(e.getMessage());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            resultBase.setStatus(500);
            resultBase.setMsg(e.getMessage());
        }
        return resultBase;
    }


    @ApiOperation(value = "编辑规则")
    @PostMapping(value = "/edl-rule", consumes = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase edlRule(@RequestBody @Validated RuleBase ruleBase) {
        ResultBase resultBase = new ResultBase();
        try {
            resultBase = ruleService.addRule(ruleBase);
        } catch (PinyinException e) {
            e.printStackTrace();
            resultBase.setStatus(500);
            resultBase.setMsg(e.getMessage());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            resultBase.setStatus(500);
            resultBase.setMsg(e.getMessage());
        }
        return resultBase;
    }

    @ApiOperation(value = "删除规则")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ruleId", value = "规则id", dataType = "int"),
            @ApiImplicitParam(name = "catalogId", value = "分类id", dataType = "int")
    })
    @PostMapping(value = "/del-rule", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase delRule(Integer ruleId, Integer catalogId) {
        return ruleService.delRule(ruleId, catalogId);
    }


    @ApiOperation(value = "规则列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "catalogId", value = "分类Id", dataType = "int"),
            @ApiImplicitParam(name = "queryKey", value = "编码/名称", dataType = "string"),
            @ApiImplicitParam(name = "deployStatus", value = "状态：1-已部署；0-未部署", dataType = "int"),

    })
    @PostMapping(value = "/list-rule", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase listRule(Integer catalogId, String queryKey, Integer deployStatus, Pageable pageable) {
        return ruleService.listRule(catalogId, queryKey, deployStatus, pageable);
    }

    @ApiOperation(value = "规则历史列表")
    @PostMapping(value = "/rule-history", produces = APPLICATION_JSON_UTF8_VALUE)
    @ApiImplicitParam(name = "ids", value = "相关联的版本规则ID", dataType = "int")
    public ResultBase ruleHistory(String ids, Pageable pageable) {
        return ruleService.ruleHistory(ids, pageable);
    }


    @ApiOperation(value = "规则版本还原")
    @PostMapping(value = "/rule-reduction", produces = APPLICATION_JSON_UTF8_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currentId", value = "当前规则id", dataType = "int"),
            @ApiImplicitParam(name = "reId", value = "还原的规则Id", dataType = "int")
    })
    public ResultBase ruleReduction(Integer currentId, Integer reId) {
        return ruleService.ruleReduction(currentId, reId);
    }

    @ApiOperation(value = "规则匹配")
    @PostMapping(value = "/operation", consumes = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase operation(@RequestBody @Validated RuleBase ruleBase) {
        log.info(" parameter:{} ", "规则运算", "/operation", ruleBase.toString());
        return ruleService.operation(ruleBase);
    }


    @ApiOperation(value = "规则匹配")
    @PostMapping(value = "/operation-1", consumes = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase operation1(@RequestBody @Validated RuleBase ruleBase) {
        log.info(" parameter:{} ", "规则运算", "/operation", ruleBase.toString());
        return ruleService.operation(ruleBase);
    }



}
