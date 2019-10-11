package com.jsg.service;

import com.jsg.base.result.ResultBase;
import com.jsg.entity.Dictionary;
import com.jsg.entity.DictionaryCatalog;
import com.jsg.entity.Pageable;

/**
 * @author jeanson 进生
 * @date 2019/10/8 19:49
 */

public interface DictionaryService {
    ResultBase addDictionaryType(DictionaryCatalog dictionaryCatalog);

    ResultBase ediDictionaryType(DictionaryCatalog dictionaryCatalog);

    ResultBase DelDictionaryType(Integer dictionaryTypeId);

    ResultBase listDictionaryType(Integer dictionaryCatalogId, String queryKey, Pageable pageable);

    ResultBase listDictionary(Integer dictionaryCatalogId, Integer status, String queryKey, Pageable pageable);

    ResultBase addDictionary(Dictionary dictionary);

    ResultBase delDictionary(Integer dictionaryId);

    ResultBase ediDictionary(Dictionary dictionary);
}
