package com.jsg.feigh;

import com.jsg.entity.Patients;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@FeignClient(value = "qualification", path = "cdss/qualification-api/baseinfo")
public interface QualificationService {

    @ApiOperation(value = "人员资质列表")
    @PostMapping(value = "list/{ysCode}", produces = APPLICATION_JSON_UTF8_VALUE)
    List<Patients> listByYsCode(String ysCode);
}