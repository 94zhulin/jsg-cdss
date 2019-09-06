package com.jsg.dao.mysql;

import com.jsg.entity.mysql.HzxxMdm;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 患者信息Mapper
 *
 * @author weidong
 * @date 2019/6/3
 */
@Repository
public interface HzxxMdmMapper {

    /**
     * 查询
     *
     * @return
     */
    List<HzxxMdm> selectAll();

}
