package com.jsg.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jsg.base.result.ResultBase;
import com.jsg.base.result.ResultUtil;
import com.jsg.dao.mysql.*;
import com.jsg.entity.*;
import com.jsg.service.KnowledgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author jeanson 进生
 * @date 2019/10/17 11:02
 */
@Service
public class KnowledgeServiceImpl implements KnowledgeService {

    @Autowired
    private CatalogMapper catalogMapper;
    @Autowired
    private ExamineMapper examineMapper;
    @Autowired
    private InspectMapper inspectMapper;

    @Autowired
    private DrugMapper drugMapper;
    @Autowired
    private DiagnosisMapper diagnosisMapper;

    private HistoryallergyMapper historyallergyMapper;

    @Value("${apiStatus.failure}")
    private Integer failure;

    @Value("${apiStatus.exc}")
    private Integer exc;

    @Value("${apiStatus.success}")
    private Integer success;

    @Override
    public ResultBase addClass(Catalog catalog) {
        List<Catalog> catalogList = catalogMapper.selectByCode(catalog);
        ResultBase resultBase = ResultUtil.success(null, catalog);
        if (catalogList.size() > 0) {
            resultBase.setStatus(failure);
            resultBase.setMsg("编码重复！");
        } else {
            int opFlag = catalogMapper.add(catalog);
            if (catalog.getId() != null) {
                childNumAdd(catalog.getParentId());
            }
        }
        return resultBase;
    }

    @Override
    public ResultBase ediClass(Catalog catalog) {
        List<Catalog> catalogList = catalogMapper.selectByCode(catalog);
        ResultBase resultBase = ResultUtil.success(null, catalog);
        if (catalogList.size() > 1) {
            resultBase.setStatus(failure);
            resultBase.setMsg("编码重复！");
        } else {

            Catalog odlCatalog = catalogMapper.selectOneById(catalog.getId());
            int opFlag = catalogMapper.edi(catalog);
            if (catalog.getId() != null) {
                int newParentId = catalog.getParentId();
                int odlParentId = odlCatalog.getParentId();
                if (newParentId != odlParentId) {
                    //TODO  旧目录进行减一
                    childNumSub(odlCatalog.getParentId());
                    //TODO 新目录进行加一
                    childNumAdd(catalog.getParentId());
                }

            }
        }
        return resultBase;
    }

    @Override
    public ResultBase classList(String parentId, Pageable pageable) {
        PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
        List<Catalog> list = catalogMapper.list(parentId);
        PageInfo<Catalog> pageInfo = new PageInfo<>(list);
        return ResultUtil.success(null, pageInfo);
    }

    @Override
    public ResultBase itemNumAdd(Integer catalogId) {
        //TODO 删除的时候要加1 对应目录的  知识项数量
        Catalog catalog = catalogMapper.selectOneById(catalogId);
        Integer itemNum = catalog.getItemNum();
        itemNum++;
        catalog.setId(catalogId);
        catalog.setItemNum(itemNum);
        int edi = catalogMapper.edi(catalog);
        return ResultUtil.success(null, catalog);
    }

    @Override
    public ResultBase itemNumSub(Integer catalogId) {
        //TODO 删除的时候要减去 对应目录的  知识项数量
        Catalog catalog = catalogMapper.selectOneById(catalogId);
        Integer itemNum = catalog.getItemNum();
        itemNum--;
        if (itemNum<0){
            itemNum = 0;
        }
        catalog.setId(catalogId);
        catalog.setItemNum(itemNum);
        int edi = catalogMapper.edi(catalog);
        return ResultUtil.success(null, catalog);
    }

    @Override
    public ResultBase childNumSub(Integer catalogId) {
        //TODO 删除的时候要减去 对应目录的  知识项数量
        Catalog catalog = catalogMapper.selectOneById(catalogId);
        Integer childNum = catalog.getChildNum();
        childNum--;
        catalog.setId(catalogId);
        catalog.setChildNum(childNum);
        int edi = catalogMapper.edi(catalog);
        return ResultUtil.success(null, catalog);
    }

    @Override
    public ResultBase del(Integer catalogId) {
        Catalog catalog = catalogMapper.selectOneById(catalogId);
        Integer childNum = catalog.getChildNum();
        ResultBase resultBase = ResultUtil.success(null, catalog);
        if (childNum > 0) {
            resultBase.setStatus(failure);
            resultBase.setMsg("包含子目录无法删除!");
        } else {
            int i = catalogMapper.del(catalogId);
            if (i > 0) {
                childNumSub(catalog.getParentId());
            }
        }
        return resultBase;
    }

    @Override
    public ResultBase hisItems(String type, String queryKey, Pageable pageable) {
        //"JC检查 JY检验 YP药品 ZD诊断 GMS过敏史
        if (queryKey == null) {
            return ResultUtil.success(null, null);
        }
        ResultBase success = ResultUtil.success(null, null);
        PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
        switch (type) {
            case "JY":
                List<Map<String, Object>> maps = examineMapper.listByName(queryKey);
                PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(maps);
                success.setData(pageInfo);
                break;
            case "JC":
                List<Inspect> inspects = inspectMapper.listByName(queryKey);
                PageInfo<Inspect> pageInfo1 = new PageInfo<>(inspects);
                success.setData(pageInfo1);
                break;
            case "YP":
                List<Drug> drugs = drugMapper.listByName(queryKey);
                PageInfo<Drug> pageInfo2 = new PageInfo<>(drugs);
                success.setData(pageInfo2);
                break;
            case "ZD":
                List<Diagnosis> diagnosiss = diagnosisMapper.listByName(queryKey);
                PageInfo<Diagnosis> pageInfo3 = new PageInfo<>(diagnosiss);
                success.setData(pageInfo3);
                break;
            case "GMS":
                List<Historyallergy> historyallergys = historyallergyMapper.listByName(queryKey);
                PageInfo<Historyallergy> pageInfo4 = new PageInfo<>(historyallergys);
                success.setData(pageInfo4);
                break;
        }
        return success;

    }


    @Override
    public ResultBase childNumAdd(Integer catalogId) {
        //TODO 删除的时候要加1 对应目录的  知识项数量
        Catalog catalog = catalogMapper.selectOneById(catalogId);
        Integer childNum = catalog.getChildNum();
        childNum++;
        catalog.setId(catalogId);
        catalog.setChildNum(childNum);
        int edi = catalogMapper.edi(catalog);
        return ResultUtil.success(null, catalog);
    }


}
