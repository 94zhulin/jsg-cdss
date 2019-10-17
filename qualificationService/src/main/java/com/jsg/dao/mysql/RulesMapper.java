package com.jsg.dao.mysql;

import com.jsg.entity.Baseinfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jeanson 进生
 * @date 2019/10/14 15:43
 */
@Repository
public interface RulesMapper {
    int del(Integer qualificationId);

    List<Baseinfo> listByassociationListQualification(String queryKey, Integer staffId, Integer qualificationId);

}
