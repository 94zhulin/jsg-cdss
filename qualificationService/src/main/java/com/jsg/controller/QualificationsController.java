package com.jsg.controller;

import com.jsg.service.QualificationsService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jeanson 进生
 * @date 2019/10/14 15:16
 */

@RestController
@RequestMapping("/qualifications")
@Api(value = "/qualifications", tags = "人员资质")
@Slf4j
public class QualificationsController {
    @Autowired
    private QualificationsService staffQualificationsService;


}
