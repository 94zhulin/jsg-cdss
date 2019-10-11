package com.jsg.dao.mysql;

import com.jsg.entity.DictionaryCatalog;
import org.springframework.stereotype.Repository;

/**
 * @author jeanson 进生
 * @date 2019/10/11 21:31
 */
@Repository
public interface DictionaryCatalogMapper {
    void addDictionaryType(DictionaryCatalog dictionaryCatalog);

}
