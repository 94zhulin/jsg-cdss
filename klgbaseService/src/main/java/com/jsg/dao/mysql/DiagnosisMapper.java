package com.jsg.dao.mysql;

import com.jsg.entity.Diagnosis;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jeanson 进生
 * @date 2019/10/17 10:02
 */
@Repository
public interface DiagnosisMapper {
    int del(@Param("diagnosisId") Integer diagnosisId);

    List<Diagnosis> selectByIcd10Code(@Param("icd10Code") String icd10Code);

    int edi(Diagnosis diagnosis);

    int add(Diagnosis diagnosis);

    List<Diagnosis> list(@Param("catalogId") Integer catalogId, @Param("queryKey") String queryKey, @Param("type") Integer type, @Param("zzdFlagCode") String zzdFlagCode);

    List<Diagnosis> listByName(@Param("queryKey") String queryKey);
}
