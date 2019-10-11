package com.jsg.controller;

import com.jsg.base.result.ResultBase;
import com.jsg.entity.Hospital;
import com.jsg.service.HospitalService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
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
@RequestMapping("/hospital")
@Api(value = "/hospital", tags = "医院信息")
@Slf4j
public class HospitalController {


    @Autowired
    private HospitalService hospitalService;


    @ApiOperation(value = "添加医院信息")
    @PostMapping(value = "/add", consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase add(@RequestBody @Validated Hospital hospital) {
        return hospitalService.add(hospital);
    }


    @ApiOperation(value = "查询医院")
    @ApiImplicitParam(name = "hospitalId", value = "医院ID", dataType = "int")
    @PostMapping(value = "/find", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase find(Integer hospitalId) {
        return hospitalService.find(hospitalId);
    }


    @ApiOperation(value = "编辑医院信息")
    @PostMapping(value = "/edi", consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase edi(@RequestBody Hospital hospital) {
        return hospitalService.edi(hospital);
    }


    @ApiOperation(value = "删除医院信息")
    @ApiImplicitParam(name = "hospitalId", value = "医院ID", dataType = "int")
    @PostMapping(value = "/del", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase del(Integer hospitalId) {
        return hospitalService.del(hospitalId);
    }

}
