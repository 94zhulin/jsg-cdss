package com.jsg.service;

import com.jsg.base.result.ResultBase;

public interface OrdersService {
    ResultBase addOrder(Integer id, String orderNum) throws Exception;
}
