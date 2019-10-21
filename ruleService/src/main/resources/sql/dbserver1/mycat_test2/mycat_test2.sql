/*
Navicat MySQL Data Transfer

Source Server         : master(192.168.198.129)
Source Server Version : 50640
Source Host           : 192.168.198.129:3306
Source Database       : mycat_test2

Target Server Type    : MYSQL
Target Server Version : 50640
File Encoding         : 65001

Date: 2019-06-10 19:00:10
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
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_orders
-- ----------------------------
INSERT INTO `t_orders` VALUES ('1', 'A001', '2019-06-10 17:09:07');
INSERT INTO `t_orders` VALUES ('2', 'A002', '2019-06-10 17:09:13');
INSERT INTO `t_orders` VALUES ('3', 'A003', '2019-06-10 17:09:19');
INSERT INTO `t_orders` VALUES ('9', 'A009', '2019-06-10 17:10:37');
INSERT INTO `t_orders` VALUES ('10', 'A010', '2019-06-10 17:10:45');
INSERT INTO `t_orders` VALUES ('15', 'A015', '2019-06-10 00:00:00');

-- ----------------------------
-- Table structure for `t_users`
-- ----------------------------
DROP TABLE IF EXISTS `t_users`;
CREATE TABLE `t_users` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_users
-- ----------------------------
INSERT INTO `t_users` VALUES ('1', '张三');
INSERT INTO `t_users` VALUES ('3', '王五');
