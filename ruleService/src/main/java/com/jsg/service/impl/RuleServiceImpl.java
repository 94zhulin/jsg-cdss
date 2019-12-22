package com.jsg.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jsg.base.result.ResultBase;
import com.jsg.base.result.ResultUtil;
import com.jsg.dao.mysql.*;
import com.jsg.entity.*;
import com.jsg.service.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

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
    RuleItemsMapper ruleItemsMapper;
    @Autowired
    RuleValueBooleanMapper ruleValueBooleanMapper;
    @Autowired
    RuleValueDateMapper ruleValueDateMapper;
    @Autowired
    RuleValueDaterangeMapper ruleValueDaterangeMapper;
    @Autowired
    RuleValueListMapper ruleValueListMapper;
    @Autowired
    RuleValueNumberMapper ruleValueNumberMapper;
    @Autowired
    RuleValueNumberrangeMapper ruleValueNumberrangeMapper;
    @Autowired
    RuleValueStringMapper ruleValueStringMapper;


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
    public ResultBase addRule(RuleBase ruleBase) {
        ruleBase.setVersion(1);
        int add = ruleBaseMapper.add(ruleBase);
        //TODO 规则分类表 中的  rule_num 规则数量 加1
        ruleNumAdd(ruleBase.getCatalogId());
        //条件真的项目id
        RuleItems itemTrue = new RuleItems();
        itemTrue.setRuleId(ruleBase.getId()); //TODO  规则id
        itemTrue.setRuleItemType(2); //'规则项类型：1-满足条件项目；2-条件真关联项目；3-条件假关联项目'
        itemTrue.setKlgCatalogId(ruleBase.getConditionsTrueTypeId());//知识库类别ID
        itemTrue.setKlgItemId(ruleBase.getTrueItemId());
        ruleItemsMapper.add(itemTrue);
        //条件假的项目id
        RuleItems itemFalse = new RuleItems();
        itemFalse.setRuleId(ruleBase.getId()); //TODO  规则id
        itemFalse.setRuleItemType(3); //'规则项类型：1-满足条件项目；2-条件真关联项目；3-条件假关联项目'
        itemFalse.setKlgCatalogId(ruleBase.getConditionsFalseTypeId());//知识库类别ID
        itemFalse.setKlgItemId(ruleBase.getFalseItemId());
        ruleItemsMapper.add(itemFalse);
        //'规则项类型：1-满足条件项目；2-条件真关联项目；3-条件假关联项目'
        //'满足条件类型:1-人资，2-患者，99-其他',
        //TODO 人资集合
        List<Patients> staffPatients = ruleBase.getStaffPatients();
        setData(staffPatients, ruleBase,1,1);
        //TODO 患者集合
        List<Patients> hzPatients = ruleBase.getHzPatients();
        setData(hzPatients, ruleBase,1,2);
        //TODO 其他
        List<Patients> otherPatients = ruleBase.getOtherPatients();
        setData(otherPatients, ruleBase,1,99);
        return ResultUtil.success(null, ruleBase);
    }

    @Override
    public ResultBase edlRule(RuleBase ruleBase) {
        //TODO 1新版本  0 不变
        Integer isVersion = ruleBase.getIsVersion();
        if (isVersion == 1) {
            //TODO 根据code 查询历史版本号
            String ids = ruleBaseMapper.selechistoryVersion(ruleBase.getRelatedRuleIds());
            ruleBase.setRelatedRuleIds(ids);
            if (ids != null) {
                //TODO 如果等于空,说明是版本2 , 这时候我们在版本2中保存之前版本的信息
                ruleBase.setRelatedRuleIds(ruleBase.getId() + "-");
            }
            Integer newVersion = ruleBase.getVersion() + 1;
            ruleBase.setVersion(newVersion);
            //TODO  新增规则
            addRule(ruleBase);
            //TODO  当前规则对象 假删除
            int i = ruleBaseMapper.isDel(ruleBase.getId());
        } else {
            //TODO ruleBase 执行 update 操作
            ruleBaseMapper.edi(ruleBase);
            //TODO 删除 item 和 rule_value所有的 记录 ,重新生成  . 因为update效率太慢了
            ruleItemsMapper.delByRuleId(ruleBase.getId());
            ruleValueBooleanMapper.delByRuleId(ruleBase.getId());
            ruleValueDateMapper.delByRuleId(ruleBase.getId());
            ruleValueDaterangeMapper.delByRuleId(ruleBase.getId());
            ruleValueListMapper.delByRuleId(ruleBase.getId());
            ruleValueNumberMapper.delByRuleId(ruleBase.getId());
            ruleValueNumberrangeMapper.delByRuleId(ruleBase.getId());
            ruleValueStringMapper.delByRuleId(ruleBase.getId());

            //TODO 重新执行 写 操作
            //条件真的项目id
            RuleItems itemTrue = new RuleItems();
            itemTrue.setRuleId(ruleBase.getId()); //TODO  规则id
            itemTrue.setRuleItemType(2); //'规则项类型：1-满足条件项目；2-条件真关联项目；3-条件假关联项目'
            itemTrue.setKlgCatalogId(ruleBase.getConditionsTrueTypeId());//知识库类别ID
            itemTrue.setKlgItemId(ruleBase.getTrueItem().getId());
            ruleItemsMapper.add(itemTrue);
            //条件假的项目id
            RuleItems itemFalse = new RuleItems();
            itemFalse.setRuleId(ruleBase.getId()); //TODO  规则id
            itemFalse.setRuleItemType(3); //'规则项类型：1-满足条件项目；2-条件真关联项目；3-条件假关联项目'
            itemFalse.setKlgCatalogId(ruleBase.getConditionsFalseTypeId());//知识库类别ID
            itemFalse.setKlgItemId(ruleBase.getFalseItem().getId());
            ruleItemsMapper.add(itemFalse);
            //'规则项类型：1-满足条件项目；2-条件真关联项目；3-条件假关联项目'
            //'满足条件类型:1-人资，2-患者，99-其他',

            //TODO 人资集合
            List<Patients> staffPatients = ruleBase.getStaffPatients();
            setData(staffPatients, ruleBase, 1, 1);
            //TODO 患者集合
            List<Patients> hzPatients = ruleBase.getHzPatients();
            setData(hzPatients, ruleBase, 1, 2);
            //TODO 其他
            List<Patients> otherPatients = ruleBase.getOtherPatients();
            setData(otherPatients, ruleBase, 1, 99);
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
    public ResultBase ruleHistory(String ids, Pageable pageable) {
        //查询 用户历史
        PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
        //TODO like 匹配开头即可 例如: 2-6-7-8-9  我们只匹配 2开头的就行
        String[] split = ids.split("-");
        List<RuleBase> list = ruleBaseMapper.ruleHistory(split[0]);
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

    private void setData(List<Patients> hzPatients, RuleBase ruleBase, Integer ruleItemType, Integer conditionType) {
        for (Patients hzPatient : hzPatients) {
            RuleItems item = new RuleItems();
            item.setRuleId(ruleBase.getId()); //TODO  规则id
            item.setRuleItemType(ruleItemType); //'规则项类型：1-满足条件项目；2-条件真关联项目；3-条件假关联项目'
            item.setConditionType(conditionType);//'满足条件类型:1-人资，2-患者，99-其他',
            item.setKlgCatalogId(hzPatient.getTypeId());//知识库类别ID
            item.setKlgItemId(hzPatient.getTypeId());
            item.setKlgItemPropname(hzPatient.getName());
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
                    boo.setValue(Integer.valueOf(hzPatient.getEndValue()));
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
                    date.setValue(hzPatient.getEndValueDate());
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


}
