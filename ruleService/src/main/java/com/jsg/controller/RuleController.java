package com.jsg.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jeanson 进生
 * @date 2019/10/21 10:12
 */

@RestController
@RequestMapping("/rule")
@Api(value = "/rule", tags = "规则模块")
@Slf4j
public class RuleController {
}
