package com.jsg.controller;

import com.jsg.base.result.ResultBase;
import com.jsg.base.result.ResultUtil;
import com.jsg.dto.BankDTO;
import com.jsg.dto.UserDTO;
import com.jsg.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 患者信息服务入口
 *
 * @author weidong
 * @date 2019/6/3
 */
@RestController
@RequestMapping("/")
public class MainController {
    private static Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/user/list")
    @ResponseBody
    public ResultBase userList() throws Exception {
        long startTime = System.currentTimeMillis(); // 获取开始时间
        ResultBase resultBase = new ResultBase();
        try {
            resultBase = userService.getUsers();
        } catch (Exception e) {
            resultBase = ResultUtil.exception(ResultUtil.EXCEPTION, e.getMessage());
        }
        long endTime = System.currentTimeMillis(); // 获取结束时间
        logger.info("程序运行时间： " + (endTime - startTime) + "ms");
        return resultBase;
    }

    @PostMapping("/user/get")
    @ResponseBody
    public ResultBase getUser(@RequestBody UserDTO dto) throws Exception {
        long startTime = System.currentTimeMillis(); // 获取开始时间
        ResultBase resultBase = new ResultBase();
        try {
            resultBase = userService.getUser(dto);
        } catch (Exception e) {
            resultBase = ResultUtil.exception(ResultUtil.EXCEPTION, e.getMessage());
        }
        long endTime = System.currentTimeMillis(); // 获取结束时间
        logger.info("程序运行时间： " + (endTime - startTime) + "ms");
        return resultBase;
    }

    @PostMapping("/bank/save")
    @ResponseBody
    public ResultBase saveFamily(@RequestBody BankDTO dto) throws Exception {
        long startTime = System.currentTimeMillis(); // 获取开始时间
        ResultBase resultBase = new ResultBase();
        logger.info("dto:" + dto);
        try {
            resultBase = userService.saveBank(dto);
        } catch (Exception e) {
            logger.info("Exception:" + e);
            resultBase = ResultUtil.exception(ResultUtil.EXCEPTION, e.getMessage());
        }
        long endTime = System.currentTimeMillis(); // 获取结束时间
        logger.info("程序运行时间： " + (endTime - startTime) + "ms");
        return resultBase;
    }

}
