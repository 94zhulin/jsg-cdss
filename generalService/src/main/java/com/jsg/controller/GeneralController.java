package com.jsg.controller;

/**
 * @author jeanson 进生
 * @date 2019/10/26 17:14
 */

import com.jsg.base.result.ResultBase;
import com.jsg.entity.Pageable;
import com.jsg.service.GeneralService;
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
 * @date 2019/10/21 10:12
 */
@RestController
@RequestMapping("/general")
@Api(value = "/general", tags = "通用的小接口")
@Slf4j
public class GeneralController {


    @Autowired
    private GeneralService generalService;


    @ApiOperation(value = "全部科室")
    @ApiImplicitParam(name = "queryKey", value = "编码/名称", dataType = "string")
    @PostMapping(value = "/department", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase department(String queryKey,Pageable pageable) {
        return generalService.department(queryKey,pageable);
    }


    @ApiOperation(value = "查询指定词典信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "queryKey", value = "编码/名称", dataType = "string"),
            @ApiImplicitParam(name = "catalogId", value = "字典类型", dataType = "string")
    })
    @PostMapping(value = "/dictionary", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase dictionary( String queryKey,String catalogId, Pageable pageable) {
        return generalService.dictionary(queryKey, catalogId, pageable);
    }


}
