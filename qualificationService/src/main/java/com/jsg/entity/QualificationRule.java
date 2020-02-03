package com.jsg.entity;

import lombok.Data;

import java.util.List;

/**
 * @author jeanson 进生
 * @date 2020/1/13 15:43
 * 资质关联的列表
 */
@Data
public class QualificationRule {
    private String catalogCode;
    private String zzmcCode;
    private String catalogName;
    private String zzmc;
    private List<String> ruleNames;
}
