package com.jsg.entity;

import lombok.Data;

import java.util.List;

/**
 * @author jeanson 进生
 * @date 2019/10/16 20:09
 */
@Data
public class QualificationsObj {
    private String zzName;
    private String zzCode;
    private List<RuleObj> gzList;
}
