package com.jsg.service.impl;


import com.codingapi.txlcn.tc.annotation.DTXPropagation;
import com.codingapi.txlcn.tc.annotation.TxcTransaction;
import com.jsg.base.result.ResultBase;
import com.jsg.base.result.ResultUtil;
import com.jsg.dao.mysql.TBankMapper;
import com.jsg.dto.BankDTO;
import com.jsg.entity.mysql.TBank;
import com.jsg.service.BankService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("BankService")
@Transactional
public class BankServiceImpl implements BankService {
    private static Logger logger = LoggerFactory.getLogger(BankServiceImpl.class);

    @Autowired
    private TBankMapper fyMapper;


    /**
     * 添加
     *
     * @return
     * @throws Exception
     */
    @Override
    @TxcTransaction(propagation = DTXPropagation.SUPPORTS)
    @Transactional
    public ResultBase add(BankDTO dto) throws Exception {
        TBank model = new TBank();
        model.setUserId(dto.getUserId());
        model.setMoney(dto.getMoney());

        logger.info("model:" + model);
//        int m=10/0; //测试异常回滚
        fyMapper.insert(model);
        return ResultUtil.success(ResultUtil.SUCCESS, "添加成功！", null);
    }

    /**
     * 获取家庭成员列表
     *
     * @return
     * @throws Exception
     */
    public ResultBase getAll() throws Exception {
        return ResultUtil.success(ResultUtil.SUCCESS, "列表", fyMapper.selectAll());
    }

}
