package com.jsg.dao.mysql;

import com.jsg.entity.Examine;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jeanson 进生
 * @date 2019/10/17 10:02
 */
@Repository
public interface ExamineMapper {
    List<Examine> selectByCode(String xmCode);

    int add(Examine examine);

    List<Examine> list(String queryKey, String xmlxCode, String jyTypeCode, String yblxCode);

    int edi(Examine examine);

    int del(Integer examineId);

}
