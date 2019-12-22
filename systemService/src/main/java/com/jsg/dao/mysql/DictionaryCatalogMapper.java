package com.jsg.dao.mysql;

import com.jsg.entity.DictionaryCatalog;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jeanson 进生
 * @date 2019/10/11 21:31
 */
@Repository
public interface DictionaryCatalogMapper {
    void addDictionaryType(DictionaryCatalog dictionaryCatalog);

    int ediDictionaryType(DictionaryCatalog dictionaryCatalog);

    DictionaryCatalog findOneByDictionaryCatalogId(@Param("dictionaryCatalogId") Integer dictionaryCatalogId);

    List<DictionaryCatalog> listDictionaryType(@Param("dictionaryCatalogId") Integer dictionaryCatalogId);

    int DelDictionaryType(@Param("dictionaryTypeId") Integer dictionaryTypeId);

    List<DictionaryCatalog> search(DictionaryCatalog dictionaryCatalog);
}
