package com.jsg.service;

import com.jsg.base.result.ResultBase;
import com.jsg.entity.UserGenera;

/**
 * @author jeanson 进生
 * @date 2019/10/26 17:16
 */
public interface GeneralService {

    ResultBase login(String userName, String password);

    ResultBase edlPassword(Integer userId, String password, String odlPassword);

    ResultBase add(UserGenera user);

    ResultBase findUser(Integer userId);

}
