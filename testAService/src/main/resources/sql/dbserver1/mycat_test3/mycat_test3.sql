/*
Navicat MySQL Data Transfer

Source Server         : master(192.168.198.129)
Source Server Version : 50640
Source Host           : 192.168.198.129:3306
Source Database       : mycat_test3

Target Server Type    : MYSQL
Target Server Version : 50640
File Encoding         : 65001

Date: 2019-06-10 19:00:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_orders`
-- ----------------------------
DROP TABLE IF EXISTS `t_orders`;
CREATE TABLE `t_orders` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `order_num` varchar(100) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_orders
-- ----------------------------
INSERT INTO `t_orders` VALUES ('4', 'A004', '2019-06-10 17:09:50');
INSERT INTO `t_orders` VALUES ('7', 'A007', '2019-06-10 17:10:27');
INSERT INTO `t_orders` VALUES ('11', 'A011', '2019-06-10 00:00:00');
