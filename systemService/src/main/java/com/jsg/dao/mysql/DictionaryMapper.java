package com.jsg.dao.mysql;

import com.jsg.entity.Dictionary;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jeanson 进生
 * @date 2019/10/8 19:54
 */
@Repository
public interface DictionaryMapper {
    List<Dictionary> search(Dictionary dictionary);

    int ediDictionary(Dictionary dictionary);

    int delDictionary(@Param("dictionaryId") Integer dictionaryId);

    int addDictionary(Dictionary dictionary);

    List<Dictionary> listDictionary(@Param("dictionaryCatalogId") Integer dictionaryCatalogId, @Param("status") Integer status, @Param("queryKey") String queryKey);

    Dictionary findOneByDictionaryId(@Param("dictionaryId") Integer dictionaryId);

}
