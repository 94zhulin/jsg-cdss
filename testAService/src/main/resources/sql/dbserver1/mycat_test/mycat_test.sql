/*
Navicat MySQL Data Transfer

Source Server         : master(192.168.198.129)
Source Server Version : 50640
Source Host           : 192.168.198.129:3306
Source Database       : mycat_test

Target Server Type    : MYSQL
Target Server Version : 50640
File Encoding         : 65001

Date: 2019-06-10 18:59:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_family_1`
-- ----------------------------
DROP TABLE IF EXISTS `t_family_1`;
CREATE TABLE `t_family_1` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `age` int(3) NOT NULL,
  `create_time` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_family_1
-- ----------------------------

-- ----------------------------
-- Table structure for `t_family_10`
-- ----------------------------
DROP TABLE IF EXISTS `t_family_10`;
CREATE TABLE `t_family_10` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `age` int(3) NOT NULL,
  `create_time` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_family_10
-- ----------------------------

-- ----------------------------
-- Table structure for `t_family_11`
-- ----------------------------
DROP TABLE IF EXISTS `t_family_11`;
CREATE TABLE `t_family_11` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `age` int(3) NOT NULL,
  `create_time` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_family_11
-- ----------------------------

-- ----------------------------
-- Table structure for `t_family_12`
-- ----------------------------
DROP TABLE IF EXISTS `t_family_12`;
CREATE TABLE `t_family_12` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `age` int(3) NOT NULL,
  `create_time` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_family_12
-- ----------------------------

-- ----------------------------
-- Table structure for `t_family_2`
-- ----------------------------
DROP TABLE IF EXISTS `t_family_2`;
CREATE TABLE `t_family_2` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `age` int(3) NOT NULL,
  `create_time` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_family_2
-- ----------------------------

-- ----------------------------
-- Table structure for `t_family_3`
-- ----------------------------
DROP TABLE IF EXISTS `t_family_3`;
CREATE TABLE `t_family_3` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `age` int(3) NOT NULL,
  `create_time` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_family_3
-- ----------------------------

-- ----------------------------
-- Table structure for `t_family_4`
-- ----------------------------
DROP TABLE IF EXISTS `t_family_4`;
CREATE TABLE `t_family_4` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `age` int(3) NOT NULL,
  `create_time` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_family_4
-- ----------------------------

-- ----------------------------
-- Table structure for `t_family_5`
-- ----------------------------
DROP TABLE IF EXISTS `t_family_5`;
CREATE TABLE `t_family_5` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `age` int(3) NOT NULL,
  `create_time` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_family_5
-- ----------------------------

-- ----------------------------
-- Table structure for `t_family_6`
-- ----------------------------
DROP TABLE IF EXISTS `t_family_6`;
CREATE TABLE `t_family_6` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `age` int(3) NOT NULL,
  `create_time` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_family_6
-- ----------------------------
INSERT INTO `t_family_6` VALUES ('1', 'Tom', '20', '2019-06-10');

-- ----------------------------
-- Table structure for `t_family_7`
-- ----------------------------
DROP TABLE IF EXISTS `t_family_7`;
CREATE TABLE `t_family_7` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `age` int(3) NOT NULL,
  `create_time` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_family_7
-- ----------------------------

-- ----------------------------
-- Table structure for `t_family_8`
-- ----------------------------
DROP TABLE IF EXISTS `t_family_8`;
CREATE TABLE `t_family_8` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `age` int(3) NOT NULL,
  `create_time` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_family_8
-- ----------------------------

-- ----------------------------
-- Table structure for `t_family_9`
-- ----------------------------
DROP TABLE IF EXISTS `t_family_9`;
CREATE TABLE `t_family_9` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `age` int(3) NOT NULL,
  `create_time` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_family_9
-- ----------------------------

-- ----------------------------
-- Table structure for `t_hzxxmdm`
-- ----------------------------
DROP TABLE IF EXISTS `t_hzxxmdm`;
CREATE TABLE `t_hzxxmdm` (
  `id` bigint(20) DEFAULT NULL COMMENT '原始表主键',
  `CJGZRQ` varchar(20) DEFAULT NULL COMMENT '参加工作日期',
  `CSD` varchar(120) DEFAULT NULL COMMENT '出生地',
  `CSRQ` date DEFAULT NULL COMMENT '出生日期',
  `DHHM` varchar(24) DEFAULT NULL COMMENT '电话号码',
  `DZYJDZ` varchar(40) DEFAULT NULL COMMENT '电子邮件地址',
  `GJ` varchar(10) DEFAULT NULL COMMENT '国籍 填写GB/T2659-2000标准三位阿拉伯代码',
  `GZDWDHHM` varchar(20) DEFAULT NULL COMMENT '工作单位电话号码',
  `GZDWDZ` varchar(128) DEFAULT NULL COMMENT '工作单位地址',
  `GZDWMC` varchar(128) DEFAULT NULL COMMENT '工作单位名称',
  `GZDWYB` varchar(6) DEFAULT NULL COMMENT '工作单位邮编',
  `HKDZ` varchar(128) DEFAULT NULL COMMENT '户口地址',
  `HKDZYB` varchar(6) DEFAULT NULL COMMENT '户口地址邮编',
  `HYZK` varchar(2) DEFAULT NULL COMMENT '婚姻状况 填写GB2261.2-2003代码',
  `HZLX` varchar(1) DEFAULT NULL COMMENT '患者类型 CV09.00.404患者类型代码表',
  `JKDABH` varchar(36) DEFAULT NULL COMMENT '健康档案编号',
  `JKKKH` varchar(36) DEFAULT NULL COMMENT '居民健康卡卡号',
  `JZDZ` varchar(128) DEFAULT NULL COMMENT '居住地址',
  `KH` varchar(64) NOT NULL COMMENT '卡号',
  `KLX` varchar(16) NOT NULL COMMENT '卡类型',
  `LXDH_LB` varchar(20) DEFAULT NULL COMMENT '联系电话-类别',
  `LXDH_LBDM` varchar(2) DEFAULT NULL COMMENT '联系电话-类别代码  01：本人电话；02：配偶电话；03：监护人电话；04：家庭电话；05：本人工作单位电话；06：居委会电话；99：其他',
  `LXRDH` varchar(128) DEFAULT NULL COMMENT '联系人电话',
  `LXRDZ` varchar(128) DEFAULT NULL COMMENT '联系人地址',
  `LXRGX` varchar(4) DEFAULT NULL COMMENT '联系人关系 代码，GB/T 4761-2008家庭关系代码',
  `LXRXM` varchar(50) DEFAULT NULL COMMENT '联系人姓名',
  `LXRYB` varchar(6) DEFAULT NULL COMMENT '联系人邮编',
  `MJ` varchar(16) DEFAULT NULL COMMENT '密级',
  `MZ` varchar(2) DEFAULT NULL COMMENT '民族  填写GBT3304-1991标准字母代码',
  `NLS` text COMMENT '年龄（岁）',
  `NLY` text COMMENT '年龄（月）',
  `SFZHM` varchar(18) DEFAULT NULL COMMENT '居民身份证号码',
  `SJHM` varchar(24) DEFAULT NULL COMMENT '手机号码',
  `SOURCEFROM` varchar(10) DEFAULT NULL COMMENT '来源系统',
  `TBRQ` date DEFAULT NULL COMMENT '数据生成时间',
  `XB` varchar(1) DEFAULT NULL COMMENT '性别',
  `XGBZ` varchar(1) DEFAULT NULL COMMENT '修改标志 0：正常（选填默认）；1：撤销',
  `XM` varchar(50) DEFAULT NULL COMMENT '姓名',
  `YLJGDM` varchar(22) NOT NULL COMMENT '医疗机构代码',
  `ZJHM` varchar(18) DEFAULT NULL COMMENT '证件号码',
  `ZJLX` varchar(2) DEFAULT NULL COMMENT '证件类型 填写CV02.01.101标准代码',
  `mid` bigint(20) NOT NULL COMMENT '主键',
  `qxsj` date DEFAULT NULL COMMENT '清洗时间',
  PRIMARY KEY (`mid`),
  KEY `IDX_t_hzxxmdm_01` (`id`) USING BTREE,
  KEY `index_mid` (`mid`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COMMENT='主索引';

-- ----------------------------
-- Records of t_hzxxmdm
-- ----------------------------
INSERT INTO `t_hzxxmdm` VALUES ('1', '-', '510802', '1953-08-20', '-', '-', '156', '-', '-', '-', '-', '四川省广元市昭化区青牛乡莲池村二组64号', '-', '20', '1', '20171130000229', '20171130000229', '四川省广元市昭化区青牛乡莲池村二组64号', '20171130000229', '99', '-', '99', '15282083899', '-', '9', '-', '-', '0', '56', '64', '1', '510802195308208676', '-', 'HIS', '2017-11-30', '1', '0', '王兴强', 'G5331874-8', '510802195308208676', '01', '13183808', '2019-03-20');
INSERT INTO `t_hzxxmdm` VALUES ('2', '-', '533221', '1988-08-28', '-', '-', '156', '-', '-', '-', '-', '云南省丽江市玉龙纳西族自治县龙蟠乡新联村委会红专村二组11号', '-', '10', '1', '20180808000088', '20180808000088', '云南省丽江市玉龙纳西族自治县龙蟠乡新联村委会红专村二组11号', '20180808000088', '99', '-', '99', '15583180119', '-', '9', '-', '-', '0', '27', '29', '1', '533221198808284727', '13881226073', 'HIS', '2018-08-08', '2', '0', '和泽英', 'G5331874-8', '533221198808284727', '01', '13183810', '2019-03-20');
INSERT INTO `t_hzxxmdm` VALUES ('3', '-', '广元市利州区上西坝', '2018-06-28', '-', '-', '156', '-', '-', '-', '-', '广元市利州区上西坝', '-', '10', '1', '20190312000051', '20190312000051', '广元市利州区上西坝', '20190312000051', '99', '-', '99', '18011153108', '-', '9', '-', '-', '0', '22', '8', '1', '-', '-', 'HIS', '2019-03-12', '1', '0', '鲜辰熙', 'G5331874-8', '-', '99', '13183812', '2019-03-20');
INSERT INTO `t_hzxxmdm` VALUES ('4', '-', '533124', '1991-07-14', '-', '-', '156', '-', '-', '-', '-', '云南省德宏傣族景颇族自治州陇川县王子树乡邦东村民委员会邦东景颇寨', '-', '20', '1', '20180319000091', '20180319000091', '云南省德宏傣族景颇族自治州陇川县王子树乡邦东村民委员会邦东景颇寨', '20180319000091', '99', '-', '99', '18181030612', '-', '9', '-', '-', '0', '28', '26', '1', '53312419910714122X', '-', 'HIS', '2018-03-19', '2', '0', '许木栽', 'G5331874-8', '53312419910714122X', '01', '13183814', '2019-03-20');
INSERT INTO `t_hzxxmdm` VALUES ('5', '-', '干部', '1967-06-13', '-', '-', '156', '-', '-', '-', '-', '干部', '-', '20', '1', '20170615000040', '20170615000040', '干部', '20170615000040', '99', '-', '99', '13320730685', '-', '9', '-', '-', '0', '53', '50', '1', '-', '13320730685', 'HIS', '2017-06-15', '1', '0', '李勇东', 'G5331874-8', '-', '99', '13183816', '2019-03-20');
INSERT INTO `t_hzxxmdm` VALUES ('6', '-', '救助站', '1953-09-21', '-', '-', '156', '-', '-', '-', '-', '救助站', '-', '90', '1', '20120923000059', '20120923000059', '救助站', '20120923000059', '99', '-', '99', '-', '-', '9', '-', '-', '0', '16', '59', '1', '-', null, 'HIS', '2012-09-23', '2', '0', '丁农秀', 'G5331874-8', '-', '99', '13183818', '2019-03-20');
INSERT INTO `t_hzxxmdm` VALUES ('7', '-', '广元市东坝莲花村', '2013-08-25', '-', '-', '156', '-', '-', '-', '-', '广元市东坝莲花村', '-', '10', '1', '20190206000023', '20190206000023', '广元市东坝莲花村', '20190206000023', '99', '-', '04', '15183991881', '-', '0000', '-', '-', '0', '16', '5', '1', '-', '-', 'HIS', '2019-02-06', '2', '0', '杨思华', 'G5331874-8', '-', '99', '13183820', '2019-03-20');
INSERT INTO `t_hzxxmdm` VALUES ('8', '-', '532727', '1976-02-16', '-', '-', '156', '-', '-', '-', '-', '云南省普洱市江城哈尼族彝族自治县国庆乡络捷村民委员会对门寨一社', '-', '20', '1', '20180618000065', '20180618000065', '云南省普洱市江城哈尼族彝族自治县国庆乡络捷村民委员会对门寨一社', '20180618000065', '99', '-', '99', '15283918348', '-', '9', '-', '-', '0', '16', '42', '1', '532727197602160964', '-', 'HIS', '2018-06-18', '2', '0', '王秀珍', 'G5331874-8', '532727197602160964', '01', '13183822', '2019-03-20');
INSERT INTO `t_hzxxmdm` VALUES ('9', '-', '432926', '1980-11-07', '-', '-', '156', '-', '-', '-', '-', '湖南省江华瑶族自治县河路口镇老车村', '-', '20', '1', '20150610000083', '20150610000083', '湖南省江华瑶族自治县河路口镇老车村', '20150610000083', '99', '-', '99', '15283992880', '-', '9', '-', '-', '0', '13', '34', '1', '432926198011074410', '15283992880', 'HIS', '2015-06-10', '1', '0', '任胜枝', 'G5331874-8', '432926198011074410', '01', '13183824', '2019-03-20');
INSERT INTO `t_hzxxmdm` VALUES ('10', '-', '452427', '1994-07-06', '-', '-', '156', '-', '-', '-', '-', '广西钟山县红花镇黄羌111-3号', '-', '20', '1', '20160717000046', '20160717000046', '广西钟山县红花镇黄羌111-3号', '20160717000046', '99', '-', '99', '15351415990', '-', '9', '-', '-', '0', '13', '24', '1', '452427199407063942', '18089560022', 'HIS', '2016-07-17', '2', '0', '莫玉凤', 'G5331874-8', '452427199407063942', '01', '13183826', '2019-03-20');
INSERT INTO `t_hzxxmdm` VALUES ('11', '-', '522125', '1995-12-21', '-', '-', '156', '-', '-', '-', '-', '贵州省道真仡佬族苗族自治县河口乡石桥村干田堡组', '-', '20', '1', '20160104000047', '20160104000047', '贵州省道真仡佬族苗族自治县河口乡石桥村干田堡组', '20160104000047', '99', '-', '99', '15282014195', '-', '9', '-', '-', '0', '37', '22', '1', '522125199512211029', '15282014195', 'HIS', '2016-01-04', '2', '0', '汪留永', 'G5331874-8', '522125199512211029', '01', '13183828', '2019-03-20');
INSERT INTO `t_hzxxmdm` VALUES ('12', '-', '广元市精神卫生中心', '1990-08-24', '-', '-', '156', '-', '-', '-', '-', '广元市精神卫生中心', '-', '10', '1', '20130826000143', '20130826000143', '广元市精神卫生中心', '20130826000143', '99', '-', '99', '-', '-', '9', '-', '-', '0', '05', '23', '1', '-', '-', 'HIS', '2013-08-26', '2', '0', '何雨蔓', 'G5331874-8', '-', '99', '13183830', '2019-03-20');
INSERT INTO `t_hzxxmdm` VALUES ('13', '-', '653222', '1992-07-01', '-', '-', '156', '-', '-', '-', '-', '新疆墨玉县阔其乡阔克亚村1组24号', '-', '10', '1', '20161121000138', '20161121000138', '新疆墨玉县阔其乡阔克亚村1组24号', '20161121000138', '99', '-', '99', '-', '-', '9', '-', '-', '0', '05', '24', '1', '65322219920701421x', '-', 'HIS', '2016-11-21', '1', '0', '阿卜杜合力力.吉力力', 'G5331874-8', '65322219920701421x', '01', '13183832', '2019-03-20');
INSERT INTO `t_hzxxmdm` VALUES ('14', '-', '新疆阜康市', '2008-06-06', '-', '-', '156', '-', '-', '-', '-', '新疆阜康市', '-', '10', '1', '20170608000041', '20170608000041', '新疆阜康市', '20170608000041', '99', '-', '99', '18793973068', '-', '9', '-', '-', '0', '05', '9', '1', '-', '-', 'HIS', '2017-06-08', '1', '0', '杜满亮', 'G5331874-8', '-', '99', '13183834', '2019-03-20');
INSERT INTO `t_hzxxmdm` VALUES ('15', '-', '652122', '1983-01-14', '-', '-', '156', '-', '-', '-', '-', '新疆鄯善县新城东路966号附1号楼1单元202室', '-', '20', '1', '20180225000106', '20180225000106', '新疆鄯善县新城东路966号附1号楼1单元202室', '20180225000106', '99', '-', '99', '18308383086', '-', '9', '-', '-', '0', '05', '35', '1', '652122198301140027', '-', 'HIS', '2018-02-25', '2', '0', '热孜万古丽·依买尔', 'G5331874-8', '652122198301140027', '01', '13183836', '2019-03-20');

-- ----------------------------
-- Table structure for `t_msg_1`
-- ----------------------------
DROP TABLE IF EXISTS `t_msg_1`;
CREATE TABLE `t_msg_1` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `subject` varchar(50) NOT NULL,
  `content` text NOT NULL,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_msg_1
-- ----------------------------
INSERT INTO `t_msg_1` VALUES ('2', 's2222', 'thank you!', '2019-06-10 18:01:59');

-- ----------------------------
-- Table structure for `t_msg_2`
-- ----------------------------
DROP TABLE IF EXISTS `t_msg_2`;
CREATE TABLE `t_msg_2` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `subject` varchar(50) NOT NULL,
  `content` text NOT NULL,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_msg_2
-- ----------------------------
INSERT INTO `t_msg_2` VALUES ('1', 's1111', 'hello,nice to meet you!', '2019-06-10 18:01:37');
INSERT INTO `t_msg_2` VALUES ('3', 's3333', 'goodbye!', '2019-06-10 18:03:05');

-- ----------------------------
-- Table structure for `t_msg_3`
-- ----------------------------
DROP TABLE IF EXISTS `t_msg_3`;
CREATE TABLE `t_msg_3` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `subject` varchar(50) NOT NULL,
  `content` text NOT NULL,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_msg_3
-- ----------------------------

-- ----------------------------
-- Table structure for `t_orders`
-- ----------------------------
DROP TABLE IF EXISTS `t_orders`;
CREATE TABLE `t_orders` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `order_num` varchar(100) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_orders
-- ----------------------------
INSERT INTO `t_orders` VALUES ('5', 'A005', '2019-06-10 17:09:54');
INSERT INTO `t_orders` VALUES ('6', 'A006', '2019-06-10 17:10:02');
INSERT INTO `t_orders` VALUES ('8', 'A008', '2019-06-10 17:10:32');
INSERT INTO `t_orders` VALUES ('14', 'A014', '2019-06-10 00:00:00');

-- ----------------------------
-- Table structure for `t_users`
-- ----------------------------
DROP TABLE IF EXISTS `t_users`;
CREATE TABLE `t_users` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_users
-- ----------------------------
INSERT INTO `t_users` VALUES ('2', '李四');
