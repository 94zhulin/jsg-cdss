package com.jsg.service.impl;

import com.jsg.base.result.ResultBase;
import com.jsg.base.result.ResultUtil;
import com.jsg.dao.mysql.DictionaryCatalogMapper;
import com.jsg.dao.mysql.DictionaryMapper;
import com.jsg.entity.Dictionary;
import com.jsg.entity.DictionaryCatalog;
import com.jsg.entity.Pageable;
import com.jsg.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jeanson 进生
 * @date 2019/10/9 15:39
 */
@Service
public class DictionaryServiceImpl implements DictionaryService {

    @Autowired
    private DictionaryMapper dictionaryMapper;

    @Autowired
    private DictionaryCatalogMapper dictionaryCatalogMapper;

    @Value("${apiStatus.failure}")
    private Integer failure;

    @Value("${apiStatus.exc}")
    private Integer exc;

    @Value("${apiStatus.success}")
    private Integer success;

    @Override
    public ResultBase addDictionaryType(DictionaryCatalog dictionaryCatalog) {
        List<DictionaryCatalog> lists = dictionaryMapper.search(dictionaryCatalog);
        ResultBase resultBase = ResultUtil.success(null, dictionaryCatalog);
        if (lists.size() > 0) {
            resultBase.setStatus(failure);
            resultBase.setMsg("编码或名称");
        } else {
            dictionaryCatalogMapper.addDictionaryType(dictionaryCatalog);
        }
        return resultBase;
    }

    @Override
    public ResultBase ediDictionaryType(DictionaryCatalog dictionaryCatalog) {
        return null;
    }

    @Override
    public ResultBase DelDictionaryType(Integer dictionaryTypeId) {
        return null;
    }

    @Override
    public ResultBase listDictionaryType(Integer dictionaryCatalogId, String queryKey, Pageable pageable) {
        return null;
    }

    @Override
    public ResultBase listDictionary(Integer dictionaryCatalogId, Integer status, String queryKey, Pageable pageable) {
        return null;
    }

    @Override
    public ResultBase addDictionary(Dictionary dictionary) {
        return null;
    }

    @Override
    public ResultBase delDictionary(Integer dictionaryId) {
        return null;
    }

    @Override
    public ResultBase ediDictionary(Dictionary dictionary) {
        return null;
    }
}
