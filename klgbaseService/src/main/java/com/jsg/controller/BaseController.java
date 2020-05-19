package com.jsg.controller;

/**
 * @author jeanson 进生
 * @date 2020/1/5 20:01
 */

import com.jsg.base.result.ResultBase;
import com.jsg.entity.Pageable;
import com.jsg.service.KlgbaseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

/**
 * @author jeanson 进生
 * @date 2019/10/17 10:30
 */
@RestController
@RequestMapping("/klgbase")
@Api(value = "/klgbase", tags = "规则库用到的接口")
@Slf4j
public class BaseController {
    @Autowired
    private KlgbaseService klgbaseService;

    @ApiOperation(value = "检索列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "catalogCode", value = "分类Code", dataType = "String"),
            @ApiImplicitParam(name = "queryKey", value = "编码/名称", dataType = "String"),
    })
    @PostMapping(value = "/list", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase list(String catalogCode, String queryKey, Pageable pageable) {
        return klgbaseService.list(catalogCode, queryKey, pageable);
    }




/*    @ApiImplicitParams({
            @ApiImplicitParam(name = "zdbm", value = "项目编码", dataType = "String"),
            @ApiImplicitParam(name = "xmlx", value = "项目类别 1 人资 2 患者 3药品 4诊断 5检查 6校验 7过敏史", dataType = "String"),
    })*/
    @ApiOperation(value = "推荐项目")
    @PostMapping(value = "/recommended-project", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase RecommendedProject(String zdbm, String xmbm,String xmlx ,String queryKey ) {
        return klgbaseService.RecommendedProject(zdbm, xmbm,xmlx,queryKey);
    }


}
