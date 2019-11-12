package com.jsg.controller;

import com.jsg.base.result.ResultBase;
import com.jsg.base.result.ResultUtil;
import com.jsg.dto.BankDTO;
import com.jsg.dto.FamilyDTO;
import com.jsg.dto.OrderDTO;
import com.jsg.dto.SolrQueryDTO;
import com.jsg.service.*;
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
    //private static final String  SOLR_URL ="http://192.168.198.129:8983/solr/";
    //private static final String  SOLR_CORE_NAME ="demo_core";

    @Autowired
    private HzxxMdmService hzService;


    @Autowired
    private OrdersService orderService;

    @Autowired
    private FamilyService fyService;

    @Autowired
    private BankService bankService;

    @Autowired
    private SolrService solrService;

    @GetMapping("/hzxx/list")
    @ResponseBody
    public ResultBase list() throws Exception {
        long startTime = System.currentTimeMillis(); // 获取开始时间
        ResultBase resultBase = new ResultBase();
        try {
            resultBase = hzService.getHzxx();
        } catch (Exception e) {
            resultBase = ResultUtil.exception( e.getMessage());
        }
        long endTime = System.currentTimeMillis(); // 获取结束时间
        logger.info("程序运行时间： " + (endTime - startTime) + "ms");
        return resultBase;
    }


    @PostMapping("/order/new")
    @ResponseBody
    public ResultBase addOrder(@RequestBody OrderDTO dto) throws Exception {
        long startTime = System.currentTimeMillis(); // 获取开始时间
        ResultBase resultBase = new ResultBase();
        try {
            resultBase = orderService.addOrder(dto.getId(), dto.getOrderNum());
        } catch (Exception e) {
            resultBase = ResultUtil.exception( e.getMessage());
        }
        long endTime = System.currentTimeMillis(); // 获取结束时间
        logger.info("程序运行时间： " + (endTime - startTime) + "ms");
        return resultBase;
    }

    @GetMapping("/family/list")
    @ResponseBody
    public ResultBase familyList() throws Exception {
        long startTime = System.currentTimeMillis(); // 获取开始时间
        ResultBase resultBase = new ResultBase();
        try {
            resultBase = fyService.getAll();
        } catch (Exception e) {
            resultBase = ResultUtil.exception(e.getMessage());
        }
        long endTime = System.currentTimeMillis(); // 获取结束时间
        logger.info("程序运行时间： " + (endTime - startTime) + "ms");
        return resultBase;
    }

    @PostMapping("/family/new")
    @ResponseBody
    public ResultBase addFamily(@RequestBody FamilyDTO dto) throws Exception {
        long startTime = System.currentTimeMillis(); // 获取开始时间
        ResultBase resultBase = new ResultBase();
        logger.info("dto:" + dto);
        try {
            resultBase = fyService.add(dto);
        } catch (Exception e) {
            logger.info("Exception:" + e);
            resultBase = ResultUtil.exception( e.getMessage());
        }
        long endTime = System.currentTimeMillis(); // 获取结束时间
        logger.info("程序运行时间： " + (endTime - startTime) + "ms");
        return resultBase;
    }


//    @PostMapping("/search")
//    @ResponseBody
//    public ResultBase Search(@RequestBody SolrQueryDTO dto) {
//        long startTime = System.currentTimeMillis(); // 获取开始时间
//        ResultBase resultBase = new ResultBase();
//        //SolrUtils solr = new SolrUtils(SOLR_URL,SOLR_CORE_NAME);
//        try {
//            //resultBase = ResultUtil.success(ResultUtil.SUCCESS,"查询成功！",solr.queryByOneParam(dto.getKeyName(),dto.getKeyVal()));
//            resultBase = solrService.search(dto);
//        } catch (Exception e) {
//            resultBase = ResultUtil.exception(ResultUtil.EXCEPTION, e.getMessage());
//        }
//        long endTime = System.currentTimeMillis(); // 获取结束时间
//        logger.info("程序运行时间： " + (endTime - startTime) + "ms");
//        return resultBase;
//    }

    @GetMapping("/bank/list")
    @ResponseBody
    public ResultBase bankList() throws Exception {
        long startTime = System.currentTimeMillis(); // 获取开始时间
        ResultBase resultBase = new ResultBase();
        try {
            resultBase = bankService.getAll();
        } catch (Exception e) {
            resultBase = ResultUtil.exception( e.getMessage());
        }
        long endTime = System.currentTimeMillis(); // 获取结束时间
        logger.info("程序运行时间： " + (endTime - startTime) + "ms");
        return resultBase;
    }

    /**
     * 新增银行信息 (该方法将会被其他服务调用，故需抛出异常，不可捕获之！)
     * @param dto
     * @return
     * @throws Exception
     */
    @PostMapping("/bank/new")
    @ResponseBody
    public ResultBase addBank(@RequestBody BankDTO dto) throws Exception {
        long startTime = System.currentTimeMillis(); // 获取开始时间
        ResultBase resultBase = new ResultBase();
        logger.info("dto:" + dto);
//        try {
        resultBase = bankService.add(dto);

//        } catch (Exception e) {
//            logger.info("Exception:" + e);
//            resultBase = ResultUtil.exception(ResultUtil.EXCEPTION, "添加异常！");
//        }
        long endTime = System.currentTimeMillis(); // 获取结束时间
        logger.info("程序运行时间： " + (endTime - startTime) + "ms");
        return resultBase;
    }
}
