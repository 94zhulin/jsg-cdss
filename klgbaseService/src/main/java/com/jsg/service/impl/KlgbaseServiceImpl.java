package com.jsg.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jsg.base.result.ResultBase;
import com.jsg.base.result.ResultUtil;
import com.jsg.dao.mysql.*;
import com.jsg.entity.*;
import com.jsg.service.KlgbaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jeanson 进生
 * @date 2020/1/5 20:07
 */
@Service
public class KlgbaseServiceImpl implements KlgbaseService {
    @Autowired
    private DiagnosisMapper diagnosisMapper;

    @Autowired
    private DrugMapper drugMapper;

    @Autowired
    private ExamineMapper examineMapper;

    @Autowired
    private HistoryallergyMapper historyallergyMapper;

    @Autowired
    private HzsxMapper hzsxMapper;

    @Autowired
    private InspectMapper inspectMapper;

    @Autowired
    private CatalogMapper catalogMapper;

    @Autowired
    private KlgbabeRecommendedProMapper  recommendedProMapper;


    @Override
    public ResultBase list(String catalogCode, String queryKey, Pageable pageable) {
        if (catalogCode == null) {
            return ResultUtil.fail("catalogCode  not null ");
        }
        Catalog catalog = new Catalog();
        catalog.setCode(catalogCode);
        List<Catalog> catalogs = catalogMapper.selectByCode(catalog);
        Catalog catalog1 = catalogs.get(0);
        ResultBase success = ResultUtil.success(null, null);
        switch (catalogCode) {
            case "JY":
                PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
                List<Examine> list = examineMapper.list(catalog1.getId(), queryKey, null, null, null);
                PageInfo<Examine> pageInfo = new PageInfo<>(list);
                success.setData(pageInfo);
                break;
            case "JC":
                PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
                List<Inspect> list1 = inspectMapper.list(catalog1.getId(), queryKey, null, null, null);
                PageInfo<Inspect> pageInfo1 = new PageInfo<>(list1);
                success.setData(pageInfo1);
                break;
            case "GMS":
                PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
                List<Historyallergy> list2 = historyallergyMapper.list(catalog1.getId(), queryKey);
                PageInfo<Historyallergy> pageInfo2 = new PageInfo<>(list2);
                success.setData(pageInfo2);

                break;
            case "YP":
                PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
                List<Drug> list3 = drugMapper.list(catalog1.getId(), queryKey, null, null, null, null);
                PageInfo<Drug> pageInfo3 = new PageInfo<>(list3);
                success.setData(pageInfo3);

                break;
            case "HZ":
                PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
                List<Hzsx> list4 = hzsxMapper.list(catalog1.getId(), queryKey, null);
                PageInfo<Hzsx> pageInfo4 = new PageInfo<>(list4);
                success.setData(pageInfo4);
                break;
            case "ZD":
                PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
                List<Diagnosis> list5 = diagnosisMapper.list(catalog1.getId(), queryKey, null, null);
                PageInfo<Diagnosis> pageInfo5 = new PageInfo<>(list5);
                success.setData(pageInfo5);
                break;
        }

        return success;
    }

    @Override
    public ResultBase RecommendedProject(String zdbm,String xmbm, String xmlx,String  queryKey ) {
         List<KlgbabeRecommendedPro> pros = recommendedProMapper.selectRecommendedProject(zdbm,xmlx);
         StringBuffer tjbmStr = new StringBuffer();
         tjbmStr.append("'"+xmbm+"'").append(",");
         for (KlgbabeRecommendedPro pro:pros){
             String tjbm = pro.getTjbm();
             tjbmStr.append("'"+tjbm+"'").append(",");
         }
         if (tjbmStr.length()>0){
             tjbmStr.subSequence(0,tjbmStr.length()-1);
         }

         if ("5".equals(xmlx)){
             //TODO  先弄点价数据
             tjbmStr.append("'ZH143"+"'").append(",").append("'ZH145"+"'");
         }
        if ("6".equals(xmlx)){
            //TODO  先弄点价数据
            tjbmStr.append("'RBC"+"'").append(",").append("'WBC"+"'");
        }

        SuspectedProject suspectedProject = new SuspectedProject ();
        suspectedProject.setXmlb(xmlx);
        StringBuffer titleOne = new StringBuffer("相似常见");
        StringBuffer titleTo = new StringBuffer();
        StringBuffer titleFive = new StringBuffer();
        //TODO 项目类别 1 人资 2 患者 3药品 4诊断 5检查 6校验 7过敏史
         switch (xmlx){
             case "1":
                 break;
             case "2":
                 break;
             case "3":
                 break;
             case "4":
                 break;
             case "5":
               List<Inspect> inspects  =  inspectMapper.selectByXmCodes(tjbmStr.toString(),queryKey);
               suspectedProject.setDatas(inspects);
                 titleOne.append("检查");
                 titleTo.append("检查");
                 titleFive.append("以上"+"检查"+"为院内常见"+"检查"+"，实际以医生判断为准");
                 if (inspects.size()>0){
                     Inspect inspect = inspects.get(0);
                     String xmName = inspect.getXmName();
                     String lcyy = inspect.getLcyy();
                     suspectedProject.setTitleThree(xmName);
                     suspectedProject.setTitleFour(lcyy);
                 }
                 break;
             case "6":
               List<Examine> examines  =  examineMapper.selectByXmCodes(tjbmStr.toString(),queryKey);
               suspectedProject.setDatas(examines);
                 titleOne.append("检验");
                 titleTo.append("检验").append("解读");
                 titleFive.append("以上"+"检验"+"为院内常见"+"检验"+"，实际以医生判断为准");
                 if (examines.size()>0){
                     Examine examine = examines.get(0);
                     String xmName = examine.getXmName();
                     String lcyy = examine.getLcyy();
                     suspectedProject.setTitleThree(xmName);
                     suspectedProject.setTitleFour(lcyy);
                 }

                 break;
             case "7":
                 break;

         }
        suspectedProject.setTitleOne(titleOne.toString());
        suspectedProject.setTitleTo(titleTo.toString());
        suspectedProject.setTitleFive(titleFive.toString());


        return ResultUtil.success("查询成功",suspectedProject);
    }
}
