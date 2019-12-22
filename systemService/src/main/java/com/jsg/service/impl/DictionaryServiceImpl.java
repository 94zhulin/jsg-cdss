package com.jsg.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jsg.base.result.ResultBase;
import com.jsg.base.result.ResultUtil;
import com.jsg.dao.mysql.DictionaryCatalogMapper;
import com.jsg.dao.mysql.DictionaryMapper;
import com.jsg.entity.Dictionary;
import com.jsg.entity.DictionaryCatalog;
import com.jsg.entity.Pageable;
import com.jsg.service.DictionaryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author jeanson 进生
 * @date 2019/10/9 15:39
 */
@Service
@Slf4j
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
        List<DictionaryCatalog> lists = dictionaryCatalogMapper.search(dictionaryCatalog);
        ResultBase resultBase = ResultUtil.success(null, dictionaryCatalog);
        if (lists.size() > 0) {
            resultBase.setStatus(failure);
            resultBase.setMsg("编码或名称重复");
        } else {
            dictionaryCatalogMapper.addDictionaryType(dictionaryCatalog);
            Integer id = dictionaryCatalog.getId();
            if (id != null) {
                DictionaryCatalog newObje = dictionaryCatalogMapper.findOneByDictionaryCatalogId(dictionaryCatalog.getParentId());
                Integer childNum = newObje.getChildNum();
                childNum++;
                newObje.setChildNum(childNum);
                //对上级目录进行修改
                dictionaryCatalogMapper.ediDictionaryType(newObje);
            }

        }
        return resultBase;
    }

    @Override
    public ResultBase ediDictionaryType(DictionaryCatalog dictionaryCatalog) {
        List<DictionaryCatalog> lists = dictionaryCatalogMapper.search(dictionaryCatalog);
        ResultBase resultBase = ResultUtil.success(null, dictionaryCatalog);
        if (lists.size() > 1) {
            resultBase.setStatus(failure);
            resultBase.setMsg("编码或名称重复");
        } else {
            DictionaryCatalog source = dictionaryCatalogMapper.findOneByDictionaryCatalogId(dictionaryCatalog.getId());
            @NotNull(message = "type is notnull") Integer parentId = source.getParentId();
            if (parentId.equals(dictionaryCatalog.getParentId())) {
                //源目录不进行加减操作
                dictionaryCatalogMapper.ediDictionaryType(dictionaryCatalog);
            } else {
                int i = dictionaryCatalogMapper.ediDictionaryType(dictionaryCatalog);
                if (i > 0) {
                    //新目录进行加操作
                    DictionaryCatalog newObje = dictionaryCatalogMapper.findOneByDictionaryCatalogId(dictionaryCatalog.getParentId());
                    Integer childNum = newObje.getChildNum();
                    childNum++;
                    newObje.setChildNum(childNum);
                    //对上级目录进行修改
                    dictionaryCatalogMapper.ediDictionaryType(newObje);
                    //旧目录进行减操作
                    DictionaryCatalog odlObje = dictionaryCatalogMapper.findOneByDictionaryCatalogId(source.getParentId());
                    Integer odlChildNum = odlObje.getChildNum();
                    odlChildNum--;
                    odlObje.setChildNum(odlChildNum);
                    dictionaryCatalogMapper.ediDictionaryType(odlObje);
                }
            }


        }
        return resultBase;
    }


    @Override
    public ResultBase DelDictionaryType(Integer dictionaryTypeId) {
        ResultBase resultBase = ResultUtil.success(null, dictionaryTypeId);
        //TODO 是否二级目录, 有就不能删除
        List<DictionaryCatalog> list = dictionaryCatalogMapper.listDictionaryType(dictionaryTypeId);
        if (list.size() > 0) {
            resultBase.setStatus(failure);
            resultBase.setMsg("存在二级目录无法删除!");
            return resultBase;
        } else {
            //TODO 二级目录,是否存在字典,有就不能删除
            List<Dictionary> dictionaries = dictionaryMapper.listDictionary(dictionaryTypeId, null, null);
            if (dictionaries.size() > 0) {
                resultBase.setStatus(failure);
                resultBase.setMsg("存在多个字典无法删除!");
                return resultBase;
            } else {
                //查询
                DictionaryCatalog oneByDictionaryCatalogId = dictionaryCatalogMapper.findOneByDictionaryCatalogId(dictionaryTypeId);
                // 删除
                int opFlag = dictionaryCatalogMapper.DelDictionaryType(dictionaryTypeId);
                if (opFlag > 0) {
                    //TODO 子类别数量 减一
                    //TODO 有空指针风险
                    DictionaryCatalog parentDictionaryCatalog
                            = dictionaryCatalogMapper.findOneByDictionaryCatalogId(oneByDictionaryCatalogId.getParentId());
                    Integer childNum = parentDictionaryCatalog.getChildNum();
                    childNum--;
                    log.info(childNum + "=========================");
                    parentDictionaryCatalog.setChildNum(childNum);
                    dictionaryCatalogMapper.ediDictionaryType(parentDictionaryCatalog);
                }
            }
        }
        return resultBase;

    }


    @Override
    public ResultBase listDictionaryType(Integer dictionaryCatalogId,Pageable pageable) {
        PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
        if (dictionaryCatalogId == null) {
            dictionaryCatalogId = 1;
        }
        List<DictionaryCatalog> list = dictionaryCatalogMapper.listDictionaryType(dictionaryCatalogId);
        PageInfo<DictionaryCatalog> pageInfo = new PageInfo<>(list);
        return ResultUtil.success(null, pageInfo);
    }

    @Override
    public ResultBase listDictionary(Integer dictionaryCatalogId, Integer status, String queryKey, Pageable pageable) {
        PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
        List<Dictionary> list = dictionaryMapper.listDictionary(dictionaryCatalogId, status, queryKey);
        PageInfo<Dictionary> pageInfo = new PageInfo<>(list);
        return ResultUtil.success(null, pageInfo);
    }

    @Override
    public ResultBase addDictionary(Dictionary dictionary) {
        List<Dictionary> lists = dictionaryMapper.search(dictionary);
        ResultBase resultBase = ResultUtil.success(null, dictionary);
        if (lists.size() > 0) {
            resultBase.setStatus(failure);
            resultBase.setMsg("编码或名称重复");
        } else {
            int i = dictionaryMapper.addDictionary(dictionary);
            Integer id = dictionary.getId();
            if (id != null) {
                DictionaryCatalog newObje = dictionaryCatalogMapper.findOneByDictionaryCatalogId(dictionary.getCatalogId());
                Integer dictNum = newObje.getDictNum();
                dictNum++;
                newObje.setDictNum(dictNum);
                //对上级目录进行修改
                dictionaryCatalogMapper.ediDictionaryType(newObje);
            }

        }
        return resultBase;
    }

    @Override
    public ResultBase delDictionary(Integer dictionaryId, Integer dictionaryCatalogId) {
        int i = dictionaryMapper.delDictionary(dictionaryId);
        if (i > 0) {
            DictionaryCatalog newObje = dictionaryCatalogMapper.findOneByDictionaryCatalogId(dictionaryCatalogId);
            Integer dictNum = newObje.getDictNum();
            dictNum--;
            newObje.setDictNum(dictNum);
            //对上级目录进行修改
            dictionaryCatalogMapper.ediDictionaryType(newObje);
        }
        return ResultUtil.success(null, dictionaryId);
    }

    @Override
    public ResultBase ediDictionary(Dictionary dictionary) {
        List<Dictionary> lists = dictionaryMapper.search(dictionary);
        ResultBase resultBase = ResultUtil.success(null, dictionary);
        if (lists.size() > 1) {
            resultBase.setStatus(failure);
            resultBase.setMsg("编码或名称重复");
        } else {
            //
            Dictionary source = dictionaryMapper.findOneByDictionaryId(dictionary.getId());
            @NotNull(message = "type is notnull") Integer parentId = source.getCatalogId();
            if (parentId.equals(dictionary.getCatalogId())) {
                //源目录不进行加减操作
                dictionaryMapper.ediDictionary(dictionary);
            } else {
                int i = dictionaryMapper.ediDictionary(dictionary);
                if (i > 0) {
                    //新目录进行加操作
                    DictionaryCatalog newObje = dictionaryCatalogMapper.findOneByDictionaryCatalogId(dictionary.getCatalogId());
                    Integer dictNum = newObje.getDictNum();
                    dictNum++;
                    newObje.setDictNum(dictNum);
                    //对上级目录进行修改
                    dictionaryCatalogMapper.ediDictionaryType(newObje);
                    //旧目录进行减操作
                    DictionaryCatalog odlObje = dictionaryCatalogMapper.findOneByDictionaryCatalogId(source.getCatalogId());
                    Integer odlDictNum = odlObje.getDictNum();
                    odlDictNum--;
                    odlObje.setDictNum(odlDictNum);
                    dictionaryCatalogMapper.ediDictionaryType(odlObje);
                }

            }

        }
        return resultBase;
    }
}
