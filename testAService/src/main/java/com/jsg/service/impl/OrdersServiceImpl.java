package com.jsg.service.impl;


import com.jsg.base.result.ResultBase;
import com.jsg.base.result.ResultUtil;
import com.jsg.dao.mysql.TOrdersMapper;
import com.jsg.entity.mysql.TOrders;
import com.jsg.service.OrdersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service("OrdersService")
@Transactional
public class OrdersServiceImpl implements OrdersService {
    private static Logger logger = LoggerFactory.getLogger(OrdersServiceImpl.class);

    @Autowired
    private TOrdersMapper orderMapper;

    /**
     * 添加订单信息
     *
     * @return
     * @throws Exception
     */

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResultBase addOrder(Integer id, String orderNum) throws Exception {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        TOrders order = new TOrders();
        order.setId(id);
        order.setOrderNum(orderNum);
        order.setCreateTime(new Date());
        orderMapper.insert(order);

		/*order = new TOrders();
		//order.setId(11111111111);
		order.setOrderNum(orderNum);
		order.setCreateTime(new Date());
		orderMapper.insert(order);*/

        return ResultUtil.success("添加订单成功！", null);
    }

}
