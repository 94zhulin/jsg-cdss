package com.jsg.service.impl;


import com.codingapi.txlcn.tc.annotation.DTXPropagation;
import com.codingapi.txlcn.tc.annotation.TxcTransaction;
import com.jsg.base.result.ResultBase;
import com.jsg.base.result.ResultUtil;
import com.jsg.dao.mysql.TFamilyMapper;
import com.jsg.dto.FamilyDTO;
import com.jsg.entity.mysql.TFamily;
import com.jsg.service.FamilyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;

@Service("FamilyService")
@Transactional
public class FamilyServiceImpl implements FamilyService {
    private static Logger logger = LoggerFactory.getLogger(FamilyServiceImpl.class);

    @Autowired
    private TFamilyMapper fyMapper;


    /**
     * 添加家庭成员
     *
     * @return
     * @throws Exception
     */
    @Override
    @TxcTransaction(propagation = DTXPropagation.SUPPORTS)
    @Transactional
    public ResultBase add(FamilyDTO dto) throws Exception {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        TFamily model = new TFamily();
        model.setId(dto.getId());
        model.setName(dto.getName());
        model.setAge(dto.getAge());
        model.setCreateTime(df.parse(dto.getCreateTime()));
        logger.info("model:" + model);
        fyMapper.insert(model);
        return ResultUtil.success("添加家庭成员成功！", null);
    }

    /**
     * 获取家庭成员列表
     *
     * @return
     * @throws Exception
     */
    public ResultBase getAll() throws Exception {
        return ResultUtil.success("家庭成员列表", fyMapper.selectAll());
    }

}
