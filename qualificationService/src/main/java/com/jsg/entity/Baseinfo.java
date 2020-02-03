package com.jsg.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * qlf_staff_baseinfo
 *
 * @author
 */
@Data
public class Baseinfo {

    @ApiModelProperty(position = 0, value = "id")
    private Integer id;


    @ApiModelProperty(position = 1, value = "姓名", required = true)
    private String fullName;


    @ApiModelProperty(position = 2, value = "性别：1-男；2-女；9-未知", required = true)
    private Integer sex;


    @ApiModelProperty(position = 3, value = "年龄", required = true)
    private Integer age;


    @ApiModelProperty(position = 4, value = "医生编码", required = true)
    private String ysCode;


    @ApiModelProperty(position = 5, value = "科室编码", required = true)
    private String ksCode;


    @ApiModelProperty(position = 6, value = "科室名称", required = true)
    private String ksName;

    /**
     * 人员类型：：1-医生；2-护士；3-医技；99-其他；
     */
    private Integer staffType;

    /**
     * 手机号
     */
    private String mobileNum;

    /**
     * 职务编码
     */
    private String jobTitleCode;

    /**
     * 职务名称
     */
    private String jobTitleName;

    /**
     * 职称编码
     */
    private String profTitleCode;

    /**
     * 职称名称
     */
    private String profTitleName;

    /**
     * 入职日期
     */
    private Date joinDate;

    /**
     * 医学专业编码
     */
    private String yxzyCode;

    /**
     * 医学专业名称
     */
    private String yxzyName;

    /**
     * 医师级别编码
     */
    private String ysjbCode;

    /**
     * 医师级别名称
     */
    private String ysjbName;

    /**
     * 资格证书编号
     */
    private String zgzsBh;

    /**
     * 执业证书编号
     */
    private String zyzsBh;

    /**
     * 执业类别编码
     */
    private String zylbCode;

    /**
     * 执业类别名称
     */
    private String zylbName;

    /**
     * 执业科目编码
     */
    private String zykmCode;

    /**
     * 执业科目名称
     */
    private String zykmName;

    /**
     * 执业状态编码
     */
    private String zyztCode;

    /**
     * 执业状态名称
     */
    private String zyztName;

    /**
     * 备注
     */
    private String comment;

    /**
     * 是否有一般资质：1-有；0-无；
     */
    private Integer hasYbZz;

    /**
     * 是否有执业医师资质：1-有；0-无；
     */
    private Integer hasZyysZz;

    /**
     * 是否有特殊资质：1-有；0-无；
     */
    private Integer hasTsZz;

    /**
     * 是否有其他资质：1-有；0-无；
     */
    private Integer hasQtZz;

    /**
     * 是否有医疗技术资质：1-有；0-无；
     */
    private Integer hasYljsZz;

    /**
     * 是否有手术资质：1-有；0-无；
     */
    private Integer hasSsZz;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人
     */
    private Integer createUserId;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 修改人
     */
    private Integer updateUserid;

}