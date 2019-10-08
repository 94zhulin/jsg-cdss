package com.jsg.service;

import com.jsg.base.result.ResultBase;
import com.jsg.dto.BankDTO;
import com.jsg.dto.UserDTO;

/**
 * 用户信息查询接口
 *
 * @author weidong
 * @date 2019/6/3
 */
public interface UserService {
    /**
     * 获取y用户信息列表
     *
     * @return
     * @throws Exception
     */
    ResultBase getUsers() throws Exception;

    /**
     * 获取用户信息
     *
     * @return
     * @throws Exception
     */
    ResultBase getUser(UserDTO dto) throws Exception;

    /**
     * 创建
     *
     * @return
     * @throws Exception
     */
    ResultBase saveBank(BankDTO dto) throws Exception;
}
