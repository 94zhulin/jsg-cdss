package com.jsg.dao.mysql;

import com.jsg.entity.RuleCatalog;
import com.jsg.entity.RuleCatalogKey;
import org.springframework.stereotype.Repository;

@Repository
public interface RuleCatalogMapper {
    int deleteByPrimaryKey(RuleCatalogKey key);

    int insert(RuleCatalog record);

    int insertSelective(RuleCatalog record);

    RuleCatalog selectByPrimaryKey(RuleCatalogKey key);

    int updateByPrimaryKeySelective(RuleCatalog record);

    int updateByPrimaryKey(RuleCatalog record);
}