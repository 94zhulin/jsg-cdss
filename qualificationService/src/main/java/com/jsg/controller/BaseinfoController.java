package com.jsg.controller;

import com.jsg.base.result.ResultBase;
import com.jsg.entity.Pageable;
import com.jsg.entity.Qualifications;
import com.jsg.entity.Zzs;
import com.jsg.entity.pojo.Patients;
import com.jsg.service.BaseinfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
    @PostMapping(value = "/add", consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
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
    @PostMapping(value = "/del/{qualificationId}", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase del(@PathVariable("qualificationId") Integer qualificationId) {
        return baseinfoService.del(qualificationId);
    }


    @ApiOperation(value = "资质规则关联列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "staffId", value = "人员id", dataType = "int"),
            @ApiImplicitParam(name = "catalogCode", value = "资质分类code  (一般资质,特殊资质的code字段)", dataType = "string"),
            @ApiImplicitParam(name = "queryKey", value = "属性名", dataType = "string"),
    })
    @PostMapping(value = "list/qualification-rules", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase listByassociationListQualification(String queryKey, Integer staffId, String catalogCode, Pageable pageable) {
        return baseinfoService.listByassociationListQualification(queryKey, staffId, catalogCode, pageable);
    }


    @ApiOperation(value = "人员资质详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "staffId", value = "人员id", dataType = "int")
    })
    @PostMapping(value = "list/qualification-details", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase detailsByQualification(Integer staffId) {
        return baseinfoService.detailsByQualification(staffId);
    }

    @ApiOperation(value = "人员资质列表")
    @PostMapping(value = "list/{ysCode}", produces = APPLICATION_JSON_UTF8_VALUE)
    public List<Patients> listByYsCode(String ysCode) {
        return baseinfoService.listByYsCode(ysCode);
    }


    @ApiOperation(value = "资质下拉框")
    @PostMapping(value = "/zzs", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase zzs() {
        ResultBase resultBase = new ResultBase();
        resultBase.setStatus(200);
        ArrayList<Zzs> list = new ArrayList<>();
        Zzs zzs1 = new Zzs();
        zzs1.setCode("RZ-ZZ-YBZZ");
        zzs1.setName("一般资质");


        Zzs zzs2 = new Zzs();
        zzs2.setCode("RZ-ZZ-TSZZ");
        zzs2.setName("特殊资质");


        Zzs zzs3 = new Zzs();
        zzs3.setCode("RZ-ZZ-QTZZ");
        zzs3.setName("其他资质");

        Zzs zzs4 = new Zzs();
        zzs4.setCode("RZ-ZZ-YLJSZZ");
        zzs4.setName("医疗技术资质");

        Zzs zzs5 = new Zzs();
        zzs5.setCode("RZ-ZZ-SSZZ");
        zzs5.setName("手术资质");
        list.add(zzs1);
        list.add(zzs2);
        list.add(zzs3);
        list.add(zzs4);
        list.add(zzs5);
        resultBase.setData(list);
        return resultBase;
    }

}
