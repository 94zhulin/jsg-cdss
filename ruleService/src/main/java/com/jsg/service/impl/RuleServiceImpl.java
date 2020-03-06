package com.jsg.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.stuxuhai.jpinyin.PinyinException;
import com.jsg.base.result.ResultBase;
import com.jsg.base.result.ResultUtil;
import com.jsg.dao.mysql.*;
import com.jsg.entity.*;
import com.jsg.service.RuleService;
import com.jsg.utils.DateUtils;
import com.jsg.utils.GenerateRulesUtils;
import com.jsg.utils.KnowledgeUtils;
import com.jsg.utils.ReflectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @author jeanson 进生
 * @date 2019/10/21 14:23
 */
@Service
public class RuleServiceImpl implements RuleService {

    @Autowired
    private RuleCatalogMapper catalogMapper;
    @Autowired
    private RuleBaseMapper ruleBaseMapper;
    @Autowired
    private RuleItemsMapper ruleItemsMapper;
    @Autowired
    private RuleValueBooleanMapper ruleValueBooleanMapper;
    @Autowired
    private RuleValueDateMapper ruleValueDateMapper;
    @Autowired
    private RuleValueDaterangeMapper ruleValueDaterangeMapper;
    @Autowired
    private RuleValueListMapper ruleValueListMapper;
    @Autowired
    private RuleValueNumberMapper ruleValueNumberMapper;
    @Autowired
    private RuleValueNumberrangeMapper ruleValueNumberrangeMapper;
    @Autowired
    private RuleValueStringMapper ruleValueStringMapper;
    @Autowired
    private RuleDroolsMapper ruleDroolsMapper;
    @Autowired
    private SysRuleaccessLogMapper sysRuleaccessLogMapper;


    @Value("${apiStatus.failure}")
    private Integer failure;

    @Value("${apiStatus.exc}")
    private Integer exc;

    @Value("${apiStatus.success}")
    private Integer success;

    @Override
    public ResultBase addClass(RuleCatalog catalog) {
        List<RuleCatalog> catalogList = catalogMapper.selectByCode(catalog);
        ResultBase resultBase = ResultUtil.success(null, catalog);
        if (catalogList.size() > 0) {
            resultBase.setStatus(failure);
            resultBase.setMsg("编码重复！");
        } else {
            catalog.setCreateTime(new Date());
            catalog.setUpdateTime(new Date());
            int opFlag = catalogMapper.add(catalog);
            if (catalog.getId() != null) {
                childNumAdd(catalog.getParentId());
            }
        }
        return resultBase;
    }

    @Override
    public ResultBase ediClass(RuleCatalog catalog) {
        List<RuleCatalog> catalogList = catalogMapper.selectByCode(catalog);
        ResultBase resultBase = ResultUtil.success(null, catalog);
        if (catalogList.size() > 1) {
            resultBase.setStatus(failure);
            resultBase.setMsg("编码重复！");
        } else {

            RuleCatalog odlCatalog = catalogMapper.selectOneById(catalog.getId());
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
        List<RuleCatalog> list = catalogMapper.list(parentId);
        PageInfo<RuleCatalog> pageInfo = new PageInfo<>(list);
        return ResultUtil.success(null, pageInfo);
    }

    @Override
    public ResultBase ruleNumAdd(Integer catalogId) {
        //TODO 删除的时候要加1 对应目录的  知识项数量
        RuleCatalog catalog = catalogMapper.selectOneById(catalogId);
        Integer itemNum = catalog.getRuleNum();
        itemNum++;
        catalog.setId(catalogId);
        catalog.setRuleNum(itemNum);
        int edi = catalogMapper.edi(catalog);
        return ResultUtil.success(null, catalog);
    }

    @Override
    public ResultBase ruleNumSub(Integer catalogId) {
        //TODO 删除的时候要减去 对应目录的  知识项数量
        RuleCatalog catalog = catalogMapper.selectOneById(catalogId);
        Integer itemNum = catalog.getRuleNum();
        itemNum--;
        catalog.setId(catalogId);
        catalog.setRuleNum(itemNum);
        int edi = catalogMapper.edi(catalog);
        return ResultUtil.success(null, catalog);
    }

    @Override
    public ResultBase childNumSub(Integer catalogId) {
        //TODO 删除的时候要减去 对应目录的  知识项数量
        RuleCatalog catalog = catalogMapper.selectOneById(catalogId);
        Integer childNum = catalog.getChildNum();
        childNum--;
        catalog.setId(catalogId);
        catalog.setChildNum(childNum);
        int edi = catalogMapper.edi(catalog);
        return ResultUtil.success(null, catalog);
    }

    @Override
    public ResultBase del(Integer catalogId) {
        RuleCatalog catalog = catalogMapper.selectOneById(catalogId);
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
    public ResultBase childNumAdd(Integer catalogId) {
        //TODO 删除的时候要加1 对应目录的  知识项数量
        RuleCatalog catalog = catalogMapper.selectOneById(catalogId);
        Integer childNum = catalog.getChildNum();
        childNum++;
        catalog.setId(catalogId);
        catalog.setChildNum(childNum);
        int edi = catalogMapper.edi(catalog);
        return ResultUtil.success(null, catalog);
    }

    @Override
    public ResultBase addRule(RuleBase ruleBase) throws PinyinException, UnsupportedEncodingException {
        //TODO 根据code 查询历史版本号
        int i1 = ruleBaseMapper.selectByVersion(ruleBase.getCode(), ruleBase.getPolicyType() + "");
        StringBuilder der = new StringBuilder();
        for (int x = 1; x <= i1; x++) {
            der.append(x + "").append("-");
        }
        ruleBase.setVersion(i1 + 1);
        ruleBase.setRelatedRuleIds(der.toString());
        int add = ruleBaseMapper.add(ruleBase);
        //TODO 规则分类表 中的  rule_num 规则数量 加1
        ruleNumAdd(ruleBase.getCatalogId());

        String trueItemCode = ruleBase.getTrueItemCode();
        if (trueItemCode != null && trueItemCode.length() > 0) {
            //条件真的项目id
            RuleItems itemTrue = new RuleItems();
            itemTrue.setRuleId(ruleBase.getId()); //TODO  规则id
            itemTrue.setRuleItemType(2); //'规则项类型：1-满足条件项目；2-条件真关联项目；3-条件假关联项目'
            itemTrue.setKlgCatalogId(ruleBase.getConditionsTrueTypeId());//知识库类别ID
            itemTrue.setConditionType(ruleBase.getConditionsTrueTypeId());
            itemTrue.setKlgItemCode(ruleBase.getTrueItemCode());
            itemTrue.setKlgItemName(ruleBase.getTrueItemName());
            ruleItemsMapper.add(itemTrue);
        }

        String falseItemCode = ruleBase.getFalseItemCode();
        if (falseItemCode != null && falseItemCode.length() > 0) {
            //条件假的项目id
            RuleItems itemFalse = new RuleItems();
            itemFalse.setRuleId(ruleBase.getId()); //TODO  规则id
            itemFalse.setRuleItemType(3); //'规则项类型：1-满足条件项目；2-条件真关联项目；3-条件假关联项目'
            itemFalse.setKlgCatalogId(ruleBase.getConditionsFalseTypeId());//知识库类别ID
            itemFalse.setConditionType(ruleBase.getConditionsFalseTypeId());
            itemFalse.setKlgItemCode(ruleBase.getFalseItemCode());
            itemFalse.setKlgItemName(ruleBase.getFalseItemName());
            ruleItemsMapper.add(itemFalse);
        }

        //'规则项类型：1-满足条件项目；2-条件真关联项目；3-条件假关联项目'
        //'满足条件类型:1-人资，2-患者，99-其他',
        //TODO 人资集合
        List<Patients> staffPatients = ruleBase.getStaffPatients();
        setData(staffPatients, ruleBase, 1);
        //TODO 患者集合
        List<Patients> hzPatients = ruleBase.getHzPatients();
        setData(hzPatients, ruleBase, 1);
        //TODO 其他
        List<Patients> otherPatients = ruleBase.getOtherPatients();
        setData(otherPatients, ruleBase, 1);
        List<Patients> datas = new ArrayList<>();
        datas.addAll(staffPatients);
        datas.addAll(hzPatients);
        datas.addAll(otherPatients);
        rulesStorage(datas, ruleBase, ruleBase.getFeedbackComment());

        return ResultUtil.success(null, ruleBase);
    }

    @Override
    public ResultBase edlRule(RuleBase ruleBase) throws UnsupportedEncodingException, PinyinException {
        //TODO 1新版本  0 不变
        Integer isVersion = ruleBase.getIsVersion();
        //TODO 停用当前规则对象,生成的规则
        RuleDrools record = new RuleDrools();
        record.setRuleBaseid(ruleBase.getId());
        record.setStatus(0);
        int s = ruleDroolsMapper.updateByRuleBaseId(record);
        if (isVersion == 1) {
            //TODO  新增规则
            ResultBase resultBase = addRule(ruleBase);
            //TODO  当前规则对象 假删除
            int i = ruleBaseMapper.isDel(ruleBase.getId());
        } else {
            //TODO ruleBase 执行 update 操作
            ruleBaseMapper.edi(ruleBase);
            //TODO 删除 item 和 rule_value所有的 记录 ,重新生成  . 因为update效率太慢了
            int i = ruleItemsMapper.delByRuleId(ruleBase.getId());
            int i1 = ruleValueBooleanMapper.delByRuleId(ruleBase.getId());
            int i2 = ruleValueDateMapper.delByRuleId(ruleBase.getId());
            int i3 = ruleValueDaterangeMapper.delByRuleId(ruleBase.getId());
            int i4 = ruleValueListMapper.delByRuleId(ruleBase.getId());
            int i5 = ruleValueNumberMapper.delByRuleId(ruleBase.getId());
            int i6 = ruleValueNumberrangeMapper.delByRuleId(ruleBase.getId());
            int i7 = ruleValueStringMapper.delByRuleId(ruleBase.getId());
            //TODO 重新执行 写 操作
            String trueItemCode = ruleBase.getTrueItemCode();
            if (trueItemCode != null && trueItemCode.length() > 0) {
                //条件真的项目id
                RuleItems itemTrue = new RuleItems();
                itemTrue.setRuleId(ruleBase.getId()); //TODO  规则id
                itemTrue.setRuleItemType(2); //'规则项类型：1-满足条件项目；2-条件真关联项目；3-条件假关联项目'
                itemTrue.setKlgCatalogId(ruleBase.getConditionsTrueTypeId());//知识库类别ID
                itemTrue.setConditionType(ruleBase.getConditionsTrueTypeId());
                itemTrue.setKlgItemCode(ruleBase.getTrueItemCode());
                itemTrue.setKlgItemName(ruleBase.getTrueItemName());
                ruleItemsMapper.add(itemTrue);
            }

            String falseItemCode = ruleBase.getFalseItemCode();
            if (falseItemCode != null && falseItemCode.length() > 0) {
                //条件假的项目id
                RuleItems itemFalse = new RuleItems();
                itemFalse.setRuleId(ruleBase.getId()); //TODO  规则id
                itemFalse.setRuleItemType(3); //'规则项类型：1-满足条件项目；2-条件真关联项目；3-条件假关联项目'
                itemFalse.setKlgCatalogId(ruleBase.getConditionsFalseTypeId());//知识库类别ID
                itemFalse.setConditionType(ruleBase.getConditionsFalseTypeId());
                itemFalse.setKlgItemCode(ruleBase.getFalseItemCode());
                itemFalse.setKlgItemName(ruleBase.getFalseItemName());
                ruleItemsMapper.add(itemFalse);
            }

            //'规则项类型：1-满足条件项目；2-条件真关联项目；3-条件假关联项目'
            //'满足条件类型:1-人资，2-患者，99-其他',
            //TODO 人资集合
            List<Patients> staffPatients = ruleBase.getStaffPatients();
            setData(staffPatients, ruleBase, 1);
            //TODO 患者集合
            List<Patients> hzPatients = ruleBase.getHzPatients();
            setData(hzPatients, ruleBase, 1);
            //TODO 其他
            List<Patients> otherPatients = ruleBase.getOtherPatients();
            setData(otherPatients, ruleBase, 1);
            List<Patients> datas = new ArrayList<>();
            datas.addAll(staffPatients);
            datas.addAll(hzPatients);
            datas.addAll(otherPatients);
            rulesStorage(datas, ruleBase, ruleBase.getFeedbackComment());

        }
        return ResultUtil.success(null, ruleBase);

    }

    @Override
    public ResultBase delRule(Integer ruleId, Integer catalogId) {
        //TODO 删除ruleBase 表 ,就行
        int del = ruleBaseMapper.isDel(ruleId);
        if (del > 0) {
            //TODO 规则分类表 中的  rule_num 规则数量 减1
            ruleNumSub(catalogId);
        }
        return ResultUtil.success(null, del);
    }

    @Override
    public ResultBase listRule(Integer catalogId, String queryKey, Integer deployStatus, Pageable pageable) {
        PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
        List<RuleCatalog> list = ruleBaseMapper.listRule(catalogId, queryKey, deployStatus);
        PageInfo<RuleCatalog> pageInfo = new PageInfo<>(list);
        return ResultUtil.success(null, pageInfo);

    }

    @Override
    public ResultBase ruleHistory(String code, String policyType, Pageable pageable) {
        //查询 用户历史
        PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
        List<RuleBase> list = ruleBaseMapper.ruleHistory(code, policyType);
        PageInfo<RuleBase> pageInfo = new PageInfo<>(list);
        return ResultUtil.success(null, pageInfo);
    }

    @Override
    public ResultBase ruleReduction(Integer currentId, Integer reId) {
        //当前正在执行的规则id ,以及要还原的规则id
        ruleBaseMapper.ruleReduction(currentId);
        ruleBaseMapper.ruleReduction(reId);
        //TODO 用户选择部署后, droools 重新加载规则
        return ResultUtil.success(null, null);
    }

    @Override
    public ResultBase operation(RuleBase ruleBase) {
      /*  KieSession kSession = null;
        try {
            // 从数据库根据code查规则
            //  List<RuleDrools> ruleDroolss = ruleDroolsMapper.selectRuleStrByCode(ruleBase.getCode());
            List<RuleDrools> ruleDroolss = null;
            KnowledgeBuilder kb = KnowledgeBuilderFactory.newKnowledgeBuilder();
            boolean flag = true;
            //TODO 拦截等级高的先执行
            for (RuleDrools ruleDrools : ruleDroolss) {
                String str = ruleDrools.getStr();
                kb.add(ResourceFactory.newByteArrayResource(str.getBytes("utf-8")), ResourceType.DRL);
                InternalKnowledgeBase kBase = KnowledgeBaseFactory.newKnowledgeBase();
                kBase.addPackages(kb.getKnowledgePackages());
                // 执行规则
                kSession = kBase.newKieSession();
                HashMap<String, Boolean> resultHashMap = new HashMap<>();
                kSession.setGlobal("resultHashMap", resultHashMap);
                List<Patients> datas = new ArrayList<>();
                datas.addAll(ruleBase.getHzPatients());
                datas.addAll(ruleBase.getOtherPatients());
                datas.addAll(ruleBase.getStaffPatients());
                for (Patients patients : datas) {
                    //TODO  判断数据类型 知识库属性值类型：1-布尔，2-数字，3-数字范围，4-日期，5-日期范围，6-文本，7-列表',
                    Integer klgItemValueType = patients.getKlgItemValueType();
                    String endValue = patients.getEndValue();
                    String ruleName = PinyinHelper.convertToPinyinString(patients.getKlgItemName(), "_", PinyinFormat.WITHOUT_TONE);
                    patients.setPinyin(ruleName);
                    switch (klgItemValueType) {
                        case 1:
                            patients.setEndValueBoo(Boolean.valueOf(endValue).booleanValue());
                            break;
                        case 2:
                            patients.setEndValueNumerical(Double.valueOf(endValue));
                            break;
                        case 3:
                            patients.setEndValueNumerical(Double.valueOf(endValue));
                            break;
                        case 4:
                            break;
                        case 5:
                            break;
                        case 6:
                            patients.setEndValue(endValue);
                            break;
                        case 7:
                            break;
                    }
                    //TODO  类型转换
                    kSession.insert(patients);
                }
                int i = kSession.fireAllRules();
                System.out.println("执行规则数量:" + i);
                Set<String> keys = resultHashMap.keySet();
                for (String key : keys) {
                    Boolean value = resultHashMap.get(key);
                    System.out.println("key：" + key + "---" + "value:" + value);
                }
            }

        } catch (Exception e) {
            System.out.println("规则执行异常" + e);
        } finally {
            if (null != kSession)
                kSession.dispose();
        }*/
        return null;
    }

    @Override
    public ResultBase operation1(HisBase hisBase) {
        RuleDrools ruleDrools2 = new RuleDrools();
        ruleDrools2.setFlag(true);
        ruleDrools2.setCode(hisBase.getItemCode());
        ruleDrools2.setPolicyType(2);
        ruleDrools2.setFeedback("测试测试测试！！！！！！！！！！！！");
        //   return ResultUtil.success(null, ruleDrools2);

        List<Patients> datas = new ArrayList<>();
        String itemCode = hisBase.getItemCode();
        List<RuleDrools> ruleDroolss = ruleDroolsMapper.selectRuleStrByCode(itemCode);
        //拆分成 rule可识别的规则
        String ysCode = hisBase.getYsCode();
        //查询医生是否包含该资质
        datas.addAll(ruleDroolsMapper.listByYsCode(ysCode));
        //患者信息
        HisPatients hisPatients = hisBase.getHisPatients();
        datas.addAll(ReflectionUtils.readAttributeValue(hisPatients));
        //项目类别 1 人资 2 患者 3药品 4诊断 5检查 6校验 7过敏史
        Integer itemType = hisBase.getItemType();
        ruleDrools2.setFlag(false);
        switch (itemType) {
            case 3:
                Drug drug = hisBase.getDrug();
                datas.addAll(ReflectionUtils.readAttributeValue(drug));
                //TODO 查询该规则中的其他项目
                break;
            case 4:
                Diagnosis diagnosis = hisBase.getDiagnosis();
                datas.addAll(ReflectionUtils.readAttributeValue(diagnosis));
                break;
            case 5:
                Inspect inspect = hisBase.getInspect();
                datas.addAll(ReflectionUtils.readAttributeValue(inspect));
                break;
            case 6:
                Examine examine = hisBase.getExamine();
                datas.addAll(ReflectionUtils.readAttributeValue(examine));
                break;
            case 7:
                Historyallergy historyallergy = hisBase.getHistoryallergy();
                datas.addAll(ReflectionUtils.readAttributeValue(historyallergy));
                break;
        }
        boolean flag = true;
        //拦截
        boolean intercept = false;
        //警告
        boolean warning = false;
        //建议
        boolean advice = false;


        //TODO 拦截等级高的先执行
        for (RuleDrools ruleDrools : ruleDroolss) {
            if (intercept) {
                ruleDrools.setFlag(false);
                return ResultUtil.success(null, ruleDrools);
            }
            if (warning) {
                ruleDrools.setFlag(true);
                return ResultUtil.success(null, ruleDrools);
            }
            if (advice) {
                ruleDrools.setFlag(false);
                return ResultUtil.success(null, ruleDrools);
            }
            //规则id
            Integer ruleBaseid = ruleDrools.getRuleBaseid();
            Integer ruleCount = ruleDrools.getCount();
            //1-拦截；2-警告；3-建议；
            Integer policyType = ruleDrools.getPolicyType();
            //由于,比较复杂. 这个我们将项目类型为 3药品 4诊断 5检查 6校验 7过敏史 的条件单独拿出
            List<RuleItems> items = ruleDroolsMapper.selectByItemCode(ruleBaseid, itemCode);
            String str = ruleDrools.getStr();
            HashMap<String, Boolean> match = KnowledgeUtils.match(str, datas);
            System.out.println("Drools执行规则数量:" + match.size());
            int total = match.size();
            System.out.println("通过数据相加,总执行质量:" + total);
            //1-拦截；2-警告；3-建议；
            SysRuleaccessLog record = new SysRuleaccessLog();
            record.setResultName("暂无条件");
            if (policyType == 1) {
                //拦截 = true, 符合拦截状态, 不在执行;
                if (total >= ruleCount) {
                    intercept = true;
                    record.setResultName("拦截");
                }

            } else if (policyType == 2) {
                //警告 = false 或true 都执行
                if (total >= ruleCount) {
                    warning = true;
                    record.setResultName("警告");
                }

            } else if (policyType == 3) {
                //  建议 = false 或true 都执行
                if (total >= ruleCount) {
                    advice = true;
                    record.setResultName("建议");
                }

            }
            record.setAccessTime(new Date());
            record.setAppCode("HIS");
            record.setAppName("HIS");
            record.setClientType(1);
            record.setIp("1270.0.01");
            record.setRuleCatalogName("检查");
            record.setRuleName(ruleDrools.getName());
            record.setRuleId(ruleDrools.getId());
            sysRuleaccessLogMapper.insert(record);
        }
        return ResultUtil.success(null, ruleDrools2);
    }

    @Override
    public ResultBase ruleDetails(Integer id) {
        RuleBase ruleBase = ruleBaseMapper.findByRuleBase(id);
        if (ruleBase == null) {
            return ResultUtil.fail("暂无该规则");
        }
        //查询 项目真
        List<RuleItems> itemTrues = ruleItemsMapper.selectItems(id, 2, null);
        if (itemTrues.size() > 0) {
            StringBuilder klgItemCodeStr = new StringBuilder();
            StringBuilder klgItemNameStr = new StringBuilder();
            RuleItems ruleItems = itemTrues.get(0);
            ruleBase.setConditionsTrueTypeId(ruleItems.getConditionType());
            for (RuleItems ruleItem : itemTrues) {
                String klgItemCode = ruleItem.getKlgItemCode();
                klgItemCodeStr.append(klgItemCode).append(",");
                String klgItemName = ruleItem.getKlgItemName();
                klgItemNameStr.append(klgItemName).append(",");
            }
            String codeStr = klgItemCodeStr.toString();
            String codeStrNew = codeStr.substring(0, codeStr.length() - 1);
            String nameStr = klgItemNameStr.toString();
            String nameStrNew = nameStr.substring(0, nameStr.length() - 1);
            ruleBase.setTrueItemCode(codeStrNew);
            ruleBase.setTrueItemName(nameStrNew);
        }

        //查询 项目假
        List<RuleItems> itemFases = ruleItemsMapper.selectItems(id, 3, null);
        if (itemFases.size() > 0) {
            StringBuilder klgItemCodeStr = new StringBuilder();
            StringBuilder klgItemNameStr = new StringBuilder();
            RuleItems ruleItems = itemFases.get(0);
            ruleBase.setConditionsFalseTypeId(ruleItems.getConditionType());
            for (RuleItems ruleItem : itemFases) {
                String klgItemCode = ruleItem.getKlgItemCode();
                klgItemCodeStr.append(klgItemCode).append(",");
                String klgItemName = ruleItem.getKlgItemName();
                klgItemNameStr.append(klgItemName).append(",");
            }
            String codeStr = klgItemCodeStr.toString();
            String codeStrNew = codeStr.substring(0, codeStr.length() - 1);
            String nameStr = klgItemNameStr.toString();
            String nameStrNew = nameStr.substring(0, nameStr.length() - 1);
            ruleBase.setFalseItemCode(codeStrNew);
            ruleBase.setFalseItemName(nameStrNew);
        }
        //查询 人资信息
        List<RuleItems> rzs = ruleItemsMapper.selectItems(id, 1, 1);
        List<Patients> staffPatients = new ArrayList<>();
        for (RuleItems rz : rzs) {
            Patients newRz = new Patients();
            newRz.setKlgItemName(rz.getKlgItemName());
            newRz.setKlgCatalogId(rz.getKlgCatalogId());
            newRz.setConditionType(rz.getConditionType());
            newRz.setKlgItemCode(rz.getKlgItemCode());
            newRz.setKlgItemValueType(rz.getKlgItemValuetype());
            newRz.setKlgItemPropName(rz.getKlgItemPropName());
            newRz.setKlgItemPropValue(rz.getKlgItemPropValue());
            newRz.setOpIndex(rz.getOpIndex());
            // 查询属性值,比较符
            getItems(newRz, rz.getId(), rz.getKlgItemValuetype());
            staffPatients.add(newRz);
        }
        ruleBase.setStaffPatients(staffPatients);

        //查询 患者信息
        List<RuleItems> hzs = ruleItemsMapper.selectItems(id, 1, 2);
        List<Patients> hzPatients = new ArrayList<>();
        for (RuleItems hz : hzs) {
            Patients newHz = new Patients();
            newHz.setKlgItemName(hz.getKlgItemName());
            newHz.setConditionType(hz.getConditionType());
            newHz.setKlgItemCode(hz.getKlgItemCode());
            newHz.setKlgCatalogId(hz.getKlgCatalogId());
            newHz.setKlgItemValueType(hz.getKlgItemValuetype());
            newHz.setKlgItemName(hz.getKlgItemName());
            newHz.setRootCompare(hz.getOperator());
            newHz.setOpIndex(hz.getOpIndex());
            newHz.setKlgItemPropName(hz.getKlgItemPropName());
            newHz.setKlgItemPropValue(hz.getKlgItemPropValue());

            //根据类型查询对应的数据库表
            getItems(newHz, hz.getId(), hz.getKlgItemValuetype());
            hzPatients.add(newHz);
        }
        ruleBase.setHzPatients(hzPatients);

        //查询其他
        List<RuleItems> others = ruleItemsMapper.selectItemsByOther(id, 1);
        List<Patients> otherPatients = new ArrayList<>();
        for (RuleItems otherItem : others) {
            Patients other = new Patients();
            other.setKlgItemName(otherItem.getKlgItemName());
            other.setConditionType(otherItem.getConditionType());
            other.setKlgItemCode(otherItem.getKlgItemCode());
            other.setKlgCatalogId(otherItem.getKlgCatalogId());
            other.setKlgItemValueType(otherItem.getKlgItemValuetype());
            other.setKlgItemName(otherItem.getKlgItemName());
            other.setRootCompare(otherItem.getOperator());
            other.setOpIndex(otherItem.getOpIndex());
            other.setKlgItemPropName(otherItem.getKlgItemPropName());
            other.setKlgItemPropValue(otherItem.getKlgItemPropValue());
            //根据类型查询对应的数据库表
            getItems(other, otherItem.getId(), otherItem.getKlgItemValuetype());
            otherPatients.add(other);
        }
        ruleBase.setOtherPatients(otherPatients);
        return ResultUtil.success("", ruleBase);
    }

    @Override
    public ResultBase ruleDeployment(Integer ruleId, Integer deploy_status, Integer policy_type) {
        RuleBase byRuleBase = ruleBaseMapper.findByRuleBase(ruleId);
        String code = byRuleBase.getCode();
        //停用所有
        ruleBaseMapper.updateDeployStatus(code, policy_type);
        ruleDroolsMapper.updateStatus(code, policy_type);

        // 规则启用
        RuleBase ruleBase = new RuleBase();
        ruleBase.setId(ruleId);
        ruleBase.setDeployStatus(deploy_status);
        ruleBaseMapper.edi(ruleBase);
        //drools 启用
        //TODO 状态：0-停用；1-启用
        RuleDrools record = new RuleDrools();
        record.setRuleBaseid(ruleId);
        record.setStatus(deploy_status);
        int i = ruleDroolsMapper.updateByPrimaryKeySelective(record);
        return ResultUtil.success("", i);
    }

    private void setData(List<Patients> hzPatients, RuleBase ruleBase, Integer ruleItemType) {
        for (Patients hzPatient : hzPatients) {
            RuleItems item = new RuleItems();
            item.setRuleId(ruleBase.getId()); //TODO  规则id
            item.setRuleItemType(ruleItemType); //'规则项类型：1-满足条件项目；2-条件真关联项目；3-条件假关联项目'
            item.setConditionType(hzPatient.getConditionType());//'满足条件类型:1-人资，2-患者，99-其他',
            item.setKlgCatalogId(hzPatient.getKlgCatalogId());//知识库类别ID
            item.setKlgItemCode(hzPatient.getKlgItemCode());
            item.setKlgItemName(hzPatient.getKlgItemName());
            item.setKlgItemPropName(hzPatient.getKlgItemPropName());
            item.setKlgItemPropValue(hzPatient.getKlgItemPropValue());
            item.setKlgItemValuetype(hzPatient.getKlgItemValueType());
            //TODO 最外层的连接符
            item.setOperator(hzPatient.getRootCompare());
            item.setOpIndex(hzPatient.getOpIndex());
            ruleItemsMapper.add(item);
            Integer klgItemValueType = hzPatient.getKlgItemValueType();
            //'知识库属性值类型：1-布尔，2-数字，3-数字范围，4-日期，5-日期范围，6-文本，7-列表'
            switch (klgItemValueType) {
                case 1:
                    RuleValueBoolean boo = new RuleValueBoolean();
                    boo.setOperator(hzPatient.getEndOp());
                    boo.setRuleId(ruleBase.getId());
                    boo.setRuleItemId(item.getId());
                    String endValue = hzPatient.getEndValue();
                    if ("true".equals(endValue)) {
                        boo.setValue(1);
                    } else {
                        boo.setValue(0);
                    }

                    ruleValueBooleanMapper.add(boo);
                    break;
                case 2:
                    RuleValueNumber number = new RuleValueNumber();
                    number.setOperator(hzPatient.getEndOp());
                    number.setRuleId(ruleBase.getId());
                    number.setRuleItemId(item.getId());
                    number.setValue(Integer.valueOf(hzPatient.getEndValue()));
                    ruleValueNumberMapper.add(number);
                    break;
                case 3:
                    RuleValueNumberrange range = new RuleValueNumberrange();
                    range.setStartOp(hzPatient.getStartOp());
                    range.setRuleId(ruleBase.getId());
                    range.setRuleItemId(item.getId());
                    range.setStartValue(Double.valueOf(hzPatient.getStartValue()));
                    range.setEndOp(hzPatient.getEndOp());
                    range.setEndValue(Double.valueOf(hzPatient.getEndValue()));
                    ruleValueNumberrangeMapper.add(range);
                    break;
                case 4:
                    RuleValueDate date = new RuleValueDate();
                    date.setOperator(hzPatient.getEndOp());
                    date.setRuleId(ruleBase.getId());
                    date.setRuleItemId(item.getId());
                    Date date1 = DateUtils.strToDate(hzPatient.getEndValue());
                    date.setValue(date1);
                    ruleValueDateMapper.add(date);
                    break;
                case 5:
                    RuleValueDaterange daterange = new RuleValueDaterange();
                    daterange.setStartOp(hzPatient.getStartOp());
                    daterange.setRuleId(ruleBase.getId());
                    daterange.setRuleItemId(item.getId());
                    daterange.setStartValue(hzPatient.getStartValueDate());
                    daterange.setEndOp(hzPatient.getEndOp());
                    daterange.setEndValue(hzPatient.getEndValueDate());
                    ruleValueDaterangeMapper.add(daterange);
                    break;
                case 6:
                    RuleValueString string = new RuleValueString();
                    string.setRuleId(ruleBase.getId());
                    string.setRuleItemId(item.getId());
                    string.setValue(hzPatient.getEndValue());
                    ruleValueStringMapper.add(string);
                    break;
                case 7:
                    RuleValueList listStr = new RuleValueList();
                    listStr.setRuleId(ruleBase.getId());
                    listStr.setRuleItemId(item.getId());
                    listStr.setValue(hzPatient.getEndValue());
                    ruleValueListMapper.add(listStr);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + klgItemValueType);
            }

        }

    }

    private void rulesStorage(List<Patients> datas, RuleBase ruleBase, String feedback) throws UnsupportedEncodingException, PinyinException {
        //TODO 规则生成成功,进行入库
        String strRule = GenerateRulesUtils.generateRules(datas);
        System.out.println("规则信息:   " + strRule);
        RuleDrools ruleDrools = new RuleDrools();
        ruleDrools.setRuleBaseid(ruleBase.getId());
        ruleDrools.setName(ruleBase.getName());
        ruleDrools.setCode(ruleBase.getCode());
        ruleDrools.setPolicyType(ruleBase.getPolicyType());
        //TODO 状态：0-停用；1-启用
        ruleDrools.setStatus(0);
        ruleDrools.setStr(strRule);
        ruleDrools.setCount(datas.size());
        ruleDrools.setFeedback(feedback);
        ruleDrools.setVersion(ruleBase.getVersion());
        ruleDrools.setCreateTime(new Date());
        ruleDrools.setUpdateTime(new Date());
        ruleDrools.setUpdateUserid(ruleBase.getUpdateUserid());
        ruleDrools.setCreateUserId(ruleBase.getCreateUserId());
        ruleDroolsMapper.insert(ruleDrools);
    }


    private void getItems(Patients patient, Integer itemId, Integer itemValueType) {
        //知识库属性值类型：1-布尔，2-数字，3-数字范围，4-日期，5-日期范围，6-文本，7-列表'
        switch (itemValueType) {
            case 1:
                RuleValueBoolean vb = ruleValueBooleanMapper.selectByItemId(itemId);
                patient.setEndOp(vb.getOperator());
                patient.setEndValue(vb.getValue() + "");
                break;
            case 2:
                RuleValueNumber valueNumber = ruleValueNumberMapper.selectByItemId(itemId);
                patient.setEndOp(valueNumber.getOperator());
                patient.setEndValue(valueNumber.getValue() + "");
                break;
            case 3:
                RuleValueNumberrange valueNumberrange = ruleValueNumberrangeMapper.selectByItemId(itemId);
                patient.setStartOp(valueNumberrange.getStartOp());
                patient.setStartValue(valueNumberrange.getStartValue() + "");
                patient.setEndOp(valueNumberrange.getEndOp());
                patient.setEndValue(valueNumberrange.getEndValue() + "");
                break;
            case 4:
                RuleValueDate valueDate = ruleValueDateMapper.selectByItemId(itemId);
                patient.setEndOp(valueDate.getOperator());
                String dateStr = DateUtils.dateToString(valueDate.getValue());
                patient.setEndValue(dateStr);
                break;
            case 5:
                RuleValueDaterange valueDaterange = ruleValueDaterangeMapper.selectByItemId(itemId);
                patient.setStartOp(valueDaterange.getStartOp());
                String startDateStr = DateUtils.dateToString(valueDaterange.getStartValue());
                patient.setStartValue(startDateStr);
                patient.setEndOp(valueDaterange.getEndOp());
                String endDateStr = DateUtils.dateToString(valueDaterange.getEndValue());
                patient.setEndValue(endDateStr);
                break;
            case 6:
                RuleValueString valueString = ruleValueStringMapper.selectByItemId(itemId);
                patient.setEndOp("=");
                patient.setEndValue(valueString.getValue() + "");
                break;
            case 7:
                RuleValueList valueList = ruleValueListMapper.selectByItemId(itemId);
                patient.setEndOp("=");
                patient.setEndValue(valueList.getValue());
                break;
        }


    }

}
