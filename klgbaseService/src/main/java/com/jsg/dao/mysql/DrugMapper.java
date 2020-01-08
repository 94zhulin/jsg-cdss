package com.jsg.dao.mysql;

import com.jsg.entity.Drug;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jeanson 进生
 * @date 2019/10/17 10:02
 */
@Repository
public interface DrugMapper {
    int add(Drug drug);

    List<Drug> list(@Param("catalogId") Integer catalogId, @Param("queryKey") String queryKey, @Param("jxCode") String jxCode, @Param("pcCode") String pcCode, @Param("gyfsCode") String gyfsCode, @Param("yysjCode") String yysjCode);

    int edi(Drug drug);

    int del(@Param("drugId") Integer drugId);

    List<Drug> selectDrugs(Drug drug);

    List<Drug> listByName(@Param("queryKey") String queryKey);
}
