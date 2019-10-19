package com.jsg.dao.mysql;

import com.jsg.entity.Catalog;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jeanson 进生
 * @date 2019/10/17 10:01
 */
@Repository
public interface CatalogMapper {
    Catalog selectOneById(@Param("catalogId") Integer catalogId);

    int edi(Catalog catalog);

    List<Catalog> list(@Param("parentId") String parentId);

    List<Catalog> selectByCode(Catalog catalog);

    int add(Catalog catalog);

    int del(@Param("catalogId") Integer catalogId);
}
