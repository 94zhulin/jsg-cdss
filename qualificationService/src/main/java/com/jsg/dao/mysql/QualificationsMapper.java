package com.jsg.dao.mysql;

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

    List<Qualifications> listByassociationListQualification(@Param("queryKey") String queryKey, @Param("staffId") Integer staffId, @Param("qualificationId") Integer qualificationId);

    List<Qualifications> detailsByQualification(@Param("staffId") Integer staffId);

    List<Patients> listByYsCode(@Param("ysCode") String ysCode);

}
