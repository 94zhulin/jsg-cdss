package com.jsg.dao.mysql;

import com.jsg.entity.Examine;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jeanson 进生
 * @date 2019/10/17 10:02
 */
@Repository
public interface ExamineMapper {
    List<Examine> selectByCode(@Param("xmCode") String xmCode);

    int add(Examine examine);

    List<Examine> list(@Param("catalogId") Integer catalogId, @Param("queryKey") String queryKey, @Param("xmlxCode") String xmlxCode, @Param("jyTypeCode") String jyTypeCode, @Param("yblxCode") String yblxCode);

    int edi(Examine examine);

    int del(@Param("examineId") Integer examineId);

}
