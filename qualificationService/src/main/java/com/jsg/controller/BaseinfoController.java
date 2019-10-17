package com.jsg.controller;

import com.jsg.base.result.ResultBase;
import com.jsg.entity.Pageable;
import com.jsg.entity.Qualifications;
import com.jsg.service.BaseinfoService;
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
 * @date 2019/10/14 15:45
 */

@RestController
@RequestMapping("/baseinfo")
@Api(value = "/baseinfo", tags = "人资信息")
@Slf4j
public class BaseinfoController {
    @Autowired
    private BaseinfoService baseinfoService;

    @ApiOperation(value = "人员列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "queryKey", value = "属性名", dataType = "string"),
            @ApiImplicitParam(name = "sex", value = "性别", dataType = "int"),
            @ApiImplicitParam(name = "ksCode", value = "科室编码", dataType = "string"),
            @ApiImplicitParam(name = "position", value = "职务", dataType = "int"),
            @ApiImplicitParam(name = "zzName", value = "资质名称", dataType = "string"),
    })
    @PostMapping(value = "/list", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase list(String queryKey, Integer sex, String ksCode, Integer position, String zzName, Pageable pageable) {
        return baseinfoService.list(queryKey, sex, ksCode, position, zzName, pageable);
    }


    @ApiOperation(value = "停用/启用人员资质")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "staffId", value = "人员id", dataType = "int"),
            @ApiImplicitParam(name = "status", value = "是否启用", dataType = "int")
    })
    @PostMapping(value = "/edi-status-qualifications", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase ediStatusQualifications(Integer staffId, Integer status) {
        return baseinfoService.ediStatusQualifications(staffId, status);
    }


    @ApiOperation(value = "新增资质(医疗技术资质和手术资质下的资质需求传递手术科目id和手术级别id)")
    @PostMapping(value = "/add", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase add(@RequestBody @Validated Qualifications qualifications) {
        return baseinfoService.add(qualifications);
    }

    @ApiOperation(value = "停用/启用资质")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "qualificationsId", value = "资质id", dataType = "int"),
            @ApiImplicitParam(name = "status", value = "是否启用", dataType = "int")
    })
    @PostMapping(value = "/edi-status-zz", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase ediStatusZz(Integer qualificationsId, Integer status) {
        return baseinfoService.ediStatusZz(qualificationsId, status);

    }


    @ApiOperation(value = "编辑资质(医疗技术资质和手术资质下的资质需求传递手术科目id和手术级别id)")
    @PostMapping(value = "/edi", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase edi(@RequestBody @Validated Qualifications qualifications) {
        return baseinfoService.edi(qualifications);
    }


    @ApiOperation(value = "删除资质")
    @ApiImplicitParam(name = "qualificationId", value = "资质id", dataType = "int")
    @PostMapping(value = "/del", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase del(Integer qualificationId) {
        return baseinfoService.del(qualificationId);
    }


    @ApiOperation(value = "资质规则关联列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "staffId", value = "人员id", dataType = "int"),
            @ApiImplicitParam(name = "qualificationId", value = "资质id", dataType = "int"),
            @ApiImplicitParam(name = "queryKey", value = "属性名", dataType = "string"),
    })
    @PostMapping(value = "list/qualification-rules", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase listByassociationListQualification(String queryKey, Integer staffId, Integer qualificationId, Pageable pageable) {
        return baseinfoService.listByassociationListQualification(queryKey, staffId, qualificationId, pageable);
    }

}
