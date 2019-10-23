package com.jsg.dao.mysql;

import com.jsg.entity.RuleCatalog;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RuleCatalogMapper {


    List<RuleCatalog> selectByCode(RuleCatalog catalog);

    int add(RuleCatalog catalog);

    RuleCatalog selectOneById(@Param("id") Integer id);

    int edi(RuleCatalog catalog);

    List<RuleCatalog> list(@Param("parentId") String parentId);

    int del(@Param("catalogId") Integer catalogId);
}