package com.jsg.service.impl;


import com.jsg.base.result.ResultBase;
import com.jsg.base.result.ResultUtil;
import com.jsg.dao.mysql.HzxxMdmMapper;
import com.jsg.service.HzxxMdmService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 患者信息查询接口实现
 *
 * @author weidong
 * @date 2019/6/3
 */

@Service("HzxxMdmService")
@Transactional
public class HzxxMdmServiceImpl implements HzxxMdmService {
    private static Logger logger = LoggerFactory.getLogger(HzxxMdmServiceImpl.class);

    @Autowired
    private HzxxMdmMapper hzMapper;


    /**
     * 获取患者信息列表
     *
     * @return
     * @throws Exception
     */
    public ResultBase getHzxx() throws Exception {
        return ResultUtil.success("患者信息列表", hzMapper.selectAll());
    }

}
