package com.jsg.dao.mysql;


import com.jsg.entity.mysql.TBank;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 银行信息Mapper
 *
 * @author weidong
 * @date 2019/6/3
 */
@Repository
public interface TBankMapper {

    /**
     * 插入
     *
     * @return
     */
    int insert(TBank bank);

    /**
     * 查询
     *
     * @return
     */
    List<TBank> selectAll();

}
