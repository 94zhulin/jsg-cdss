package com.jsg.dao.mysql;

import com.jsg.entity.Diagnosis;
import com.jsg.entity.Hzsx;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jeanson 进生
 * @date 2019/10/17 10:03
 */
@Repository
public interface HzsxMapper {
    int del(@Param("hzsxId") Integer hzsxId);

    List<Hzsx> selectByCode(@Param("code") String code);

    int edi(Hzsx hzsx);

    List<Diagnosis> list(@Param("queryKey") String queryKey, @Param("valueType") Integer valueType);

    int add(Hzsx hzsx);
}
