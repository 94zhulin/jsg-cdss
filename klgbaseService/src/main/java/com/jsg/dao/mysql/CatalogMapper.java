package com.jsg.dao.mysql;

import com.jsg.entity.Catalog;
import org.springframework.stereotype.Repository;

/**
 * @author jeanson 进生
 * @date 2019/10/17 10:01
 */
@Repository
public interface CatalogMapper {
    Catalog selectOneById(Integer catalogId);

    int edi(Catalog catalog);

}
