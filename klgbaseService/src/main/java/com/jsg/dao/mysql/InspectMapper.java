package com.jsg.dao.mysql;

import com.jsg.entity.Diagnosis;
import com.jsg.entity.Inspect;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jeanson 进生
 * @date 2019/10/17 10:04
 */
@Repository
public interface InspectMapper {
    int del(@Param("inspectId") Integer inspectId);

    List<Inspect> selectByCode(Inspect inspect);

    int edi(Inspect inspect);

    List<Diagnosis> list(@Param("catalogId") Integer catalogId, @Param("queryKey") String queryKey, @Param("bw") String bw, @Param("jcTypeCode") String jcTypeCode, @Param("yxFlagCode") String yxFlagCode);

    int add(Inspect inspect);

}
