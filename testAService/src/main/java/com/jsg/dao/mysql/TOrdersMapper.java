package com.jsg.dao.mysql;

import com.jsg.entity.mysql.TOrders;
import org.springframework.stereotype.Repository;

/**
 * 订单Mapper
 *
 * @author weidong
 * @date 2019/6/3
 */
@Repository
public interface TOrdersMapper {

    /**
     * 插入
     *
     * @return
     */
    int insert(TOrders order);

}
