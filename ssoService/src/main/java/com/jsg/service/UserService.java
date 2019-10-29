package com.jsg.service;

import com.jsg.base.result.ResultBase;
import com.jsg.entity.User;

/**
 * 用户信息查询接口
 *
 * @author weidong
 * @date 2019/6/3
 */
public interface UserService {

    ResultBase login(String userName, String password);

    ResultBase edlPassword(Integer userId, String password, String odlPassword);

    ResultBase add(User user);

    ResultBase findUser(Integer userId);
}
