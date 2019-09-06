package com.jsg.service.impl;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.jsg.base.result.ResultBase;
import com.jsg.base.result.ResultUtil;
import com.jsg.dao.sqlserver.UserMapper;
import com.jsg.dto.BankDTO;
import com.jsg.dto.UserDTO;
import com.jsg.feign.TestAClient;
import com.jsg.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户信息查询接口实现
 *
 * @author weidong
 * @date 2019/6/3
 */

@Service("UserService")
@Transactional
public class UserServiceImpl implements UserService {
    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    TestAClient testAClient;

    @Autowired
    private UserMapper userMapper;

    /**
     * 获取用户信息列表
     *
     * @return
     * @throws Exception
     */
    @Override
    public ResultBase getUsers() throws Exception {
        return ResultUtil.success(ResultUtil.SUCCESS, "用户信息列表", userMapper.selectAll());
    }

    /**
     * 获取用户信息
     *
     * @return
     * @throws Exception
     */
    @Override
    public ResultBase getUser(UserDTO dto) throws Exception {
        return ResultUtil.success(ResultUtil.SUCCESS, "用户信息", userMapper.selectById(dto));
    }


    /**
     * 创建家庭成员
     *
     * @return
     * @throws Exception
     */
    @Transactional
    @LcnTransaction//表明使用lcn模式
    @Override
    public ResultBase saveBank(BankDTO dto) throws Exception {
        UserDTO user = new UserDTO();
        user.setId(dto.getUserId());
        user.setName(dto.getName());
        logger.info("user:" + user);
        userMapper.updateById(user);
        return testAClient.addBank(dto);
    }
}
