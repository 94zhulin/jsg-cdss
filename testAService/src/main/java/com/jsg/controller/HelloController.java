package com.jsg.controller;

import com.jsg.base.result.ResultBase;
import com.jsg.base.result.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试入口
 *
 * @author weidong
 * @date 2019/6/3
 */
@RestController
@RequestMapping("/heartbeat")
public class HelloController {
    private static Logger logger = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/hello")
    public ResultBase helloworld() {
        ResultBase resultBase = ResultUtil.success("开发环境hello", "");
        try {
            return resultBase;
        } catch (Exception e) {
            resultBase = ResultUtil.exception(e.getMessage());
        }
        return resultBase;
    }
}
