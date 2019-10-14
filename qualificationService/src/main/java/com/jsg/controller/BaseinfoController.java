package com.jsg.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jeanson 进生
 * @date 2019/10/14 15:45
 */

@RestController
@RequestMapping("/staffBaseinfo")
@Api(value = "/staffBaseinfo", tags = "基础信息")
@Slf4j
public class BaseinfoController {
}
