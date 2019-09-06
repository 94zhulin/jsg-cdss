package com.jsg.dao.mysql;

import com.jsg.entity.mysql.TFamily;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 家庭信息Mapper
 *
 * @author weidong
 * @date 2019/6/3
 */
@Repository
public interface TFamilyMapper {

    /**
     * 插入
     *
     * @return
     */
    int insert(TFamily family);

    /**
     * 查询
     *
     * @return
     */
    List<TFamily> selectAll();

}
