package com.jsg.dao.mysql;

import com.jsg.entity.HzsxList;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jeanson 进生
 * @date 2019/10/17 10:03
 */
@Repository
public interface HzsxListMapper {
    int add(@Param("emps") List<HzsxList> emps);

    int del(@Param("propId") Integer propId);

    List<HzsxList> list(@Param("propId") String propId);


}
