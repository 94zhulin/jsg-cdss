package com.jsg.dao.mysql;

import com.jsg.entity.Baseinfo;
import com.jsg.entity.QualificationRule;
import com.jsg.entity.Qualifications;
import com.jsg.entity.pojo.Patients;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jeanson 进生
 * @date 2019/10/14 15:20
 */
@Repository
public interface QualificationsMapper {

    int batchEdiStatusQualifications(@Param("staffId") Integer staffId, @Param("status") Integer status);

    void edi(Qualifications qualifications);

    int del(@Param("qualificationId") Integer qualificationId);

    int add(Qualifications qualifications);

    List<QualificationRule> listByassociationListQualification(@Param("queryKey") String queryKey, @Param("staffId") Integer staffId, @Param("catalogCode") String catalogCode);

    List<Qualifications> detailsByQualification(@Param("staffId") Integer staffId);

    List<Patients> listByYsCode(@Param("ysCode") String ysCode);

    Qualifications selectByOne(@Param("qualificationId") Integer qualificationId);

    List<Qualifications> selectByStaffIdAndCatalogCode(@Param("staffId") Integer staffId, @Param("catalogCode") String catalogCode);

    List<Baseinfo> list(@Param("queryKey") String queryKey, @Param("sex") Integer sex, @Param("ksCode") String ksCode, @Param("position") Integer position, @Param("zzName") String zzName);
}
