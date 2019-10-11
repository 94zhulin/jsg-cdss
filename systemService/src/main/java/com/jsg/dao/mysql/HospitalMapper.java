package com.jsg.dao.mysql;

import com.jsg.entity.Hospital;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jeanson 进生
 * @date 2019/10/8 19:53
 */
@Repository
public interface HospitalMapper {
    int add(Hospital hospital);

    List<Hospital> find(@Param("hospitalId") Integer hospitalId);

    int edi(Hospital hospital);

    int del(@Param("hospitalId") Integer hospitalId);
}
