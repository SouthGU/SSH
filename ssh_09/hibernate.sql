/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50617
Source Host           : localhost:3306
Source Database       : hibernate

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2019-10-25 01:17:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for orderitem_ssh09
-- ----------------------------
DROP TABLE IF EXISTS `orderitem_ssh09`;
CREATE TABLE `orderitem_ssh09` (
  `order_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `purchase` double NOT NULL,
  PRIMARY KEY (`order_id`,`product_id`,`quantity`,`purchase`),
  KEY `FK9hf5k6fmdeygqmoi1l9sqw8bj` (`product_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderitem_ssh09
-- ----------------------------
INSERT INTO `orderitem_ssh09` VALUES ('1', '1', '100', '6000');
INSERT INTO `orderitem_ssh09` VALUES ('1', '2', '200', '3000');
INSERT INTO `orderitem_ssh09` VALUES ('2', '3', '30', '3300');
INSERT INTO `orderitem_ssh09` VALUES ('2', '3', '60', '6200');

-- ----------------------------
-- Table structure for order_ssh09
-- ----------------------------
DROP TABLE IF EXISTS `order_ssh09`;
CREATE TABLE `order_ssh09` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `realname` varchar(12) DEFAULT NULL,
  `toatal` double DEFAULT NULL,
  `phone` varchar(12) DEFAULT NULL,
  `address` varchar(12) DEFAULT NULL,
  `postcode` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_ssh09
-- ----------------------------
INSERT INTO `order_ssh09` VALUES ('1', '李浩然', '1200000', '13015978361', '广大华软', '510990');
INSERT INTO `order_ssh09` VALUES ('2', '李明', '471000', '1591238362', '清华大学', '530250');

-- ----------------------------
-- Table structure for person
-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(12) NOT NULL,
  `age` int(11) DEFAULT NULL,
  `sno` varchar(255) DEFAULT NULL,
  `sex` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of person
-- ----------------------------
INSERT INTO `person` VALUES ('5', 'John', null, null, '\0');
INSERT INTO `person` VALUES ('2', 'Jack', '39', '200192001', '男');
INSERT INTO `person` VALUES ('4', 'John', '22', '20192001', '女');

-- ----------------------------
-- Table structure for person_demo08
-- ----------------------------
DROP TABLE IF EXISTS `person_demo08`;
CREATE TABLE `person_demo08` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(15) NOT NULL,
  `username` varchar(12) NOT NULL,
  `sex` varchar(1) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `sno` varchar(10) DEFAULT NULL,
  `school` varchar(50) DEFAULT NULL,
  `wno` varchar(10) DEFAULT NULL,
  `salary` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of person_demo08
-- ----------------------------
INSERT INTO `person_demo08` VALUES ('12', 'person_demo08', '何洁', '女', '23', null, null, null, null);
INSERT INTO `person_demo08` VALUES ('13', 'work_demo08', '李然', '女', '28', null, null, 'SD0001', '6000');
INSERT INTO `person_demo08` VALUES ('14', 'student_demo08', '王浩', '男', '19', 'SD0001', '广大华软', null, null);
INSERT INTO `person_demo08` VALUES ('15', 'person_demo08', '何洁', '女', '23', null, null, null, null);
INSERT INTO `person_demo08` VALUES ('16', 'work_demo08', '李然', '女', '28', null, null, 'SD0001', '6000');
INSERT INTO `person_demo08` VALUES ('17', 'student_demo08', '王浩', '男', '19', 'SD0001', '广大华软', null, null);
INSERT INTO `person_demo08` VALUES ('18', 'person_demo08', '何洁', '女', '23', null, null, null, null);
INSERT INTO `person_demo08` VALUES ('19', 'work_demo08', '李然', '女', '28', null, null, 'SD0001', '6000');
INSERT INTO `person_demo08` VALUES ('20', 'student_demo08', '王浩', '男', '19', 'SD0001', '广大华软', null, null);
INSERT INTO `person_demo08` VALUES ('21', 'person_demo08', '何洁', '女', '23', null, null, null, null);
INSERT INTO `person_demo08` VALUES ('22', 'work_demo08', '李然', '女', '28', null, null, 'SD0001', '6000');
INSERT INTO `person_demo08` VALUES ('23', 'student_demo08', '王浩', '男', '19', 'SD0001', '广大华软', null, null);

-- ----------------------------
-- Table structure for person_demo08_03
-- ----------------------------
DROP TABLE IF EXISTS `person_demo08_03`;
CREATE TABLE `person_demo08_03` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(12) NOT NULL,
  `sex` varchar(1) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of person_demo08_03
-- ----------------------------
INSERT INTO `person_demo08_03` VALUES ('1', '何洁', '女', '23');
INSERT INTO `person_demo08_03` VALUES ('2', '李然', '女', '28');
INSERT INTO `person_demo08_03` VALUES ('3', '王浩', '男', '19');
INSERT INTO `person_demo08_03` VALUES ('4', '何洁', '女', '23');
INSERT INTO `person_demo08_03` VALUES ('5', '李然', '女', '28');
INSERT INTO `person_demo08_03` VALUES ('6', '王浩', '男', '19');
INSERT INTO `person_demo08_03` VALUES ('7', '何洁', '女', '23');
INSERT INTO `person_demo08_03` VALUES ('8', '李然', '女', '28');
INSERT INTO `person_demo08_03` VALUES ('9', '王浩', '男', '19');
INSERT INTO `person_demo08_03` VALUES ('10', '何洁', '女', '23');
INSERT INTO `person_demo08_03` VALUES ('11', '李然', '女', '28');
INSERT INTO `person_demo08_03` VALUES ('12', '王浩', '男', '19');

-- ----------------------------
-- Table structure for person_ssh_14
-- ----------------------------
DROP TABLE IF EXISTS `person_ssh_14`;
CREATE TABLE `person_ssh_14` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of person_ssh_14
-- ----------------------------
INSERT INTO `person_ssh_14` VALUES ('1', '赵六');
INSERT INTO `person_ssh_14` VALUES ('2', '张三');
INSERT INTO `person_ssh_14` VALUES ('3', 'AAA');
INSERT INTO `person_ssh_14` VALUES ('8', '张三');
INSERT INTO `person_ssh_14` VALUES ('6', '赵六');
INSERT INTO `person_ssh_14` VALUES ('7', 'AAA');
INSERT INTO `person_ssh_14` VALUES ('9', '李四');
INSERT INTO `person_ssh_14` VALUES ('10', '王五');
INSERT INTO `person_ssh_14` VALUES ('11', '赵六');

-- ----------------------------
-- Table structure for product_ssh_09
-- ----------------------------
DROP TABLE IF EXISTS `product_ssh_09`;
CREATE TABLE `product_ssh_09` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `description` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product_ssh_09
-- ----------------------------
INSERT INTO `product_ssh_09` VALUES ('1', 'ThinkPad笔记本电脑', '6780', 'ThinkPad笔记本电脑散热性能好');
INSERT INTO `product_ssh_09` VALUES ('2', '32寸长虹彩电', '3699', '长虹彩电的性价比高');
INSERT INTO `product_ssh_09` VALUES ('3', '39寸TCL彩电', '3600', 'TCL彩电的性价比天下无敌');

-- ----------------------------
-- Table structure for register
-- ----------------------------
DROP TABLE IF EXISTS `register`;
CREATE TABLE `register` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(12) NOT NULL,
  `password` varchar(16) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of register
-- ----------------------------
INSERT INTO `register` VALUES ('1', '1', '1');
INSERT INTO `register` VALUES ('2', '2', '2');
INSERT INTO `register` VALUES ('3', '3', '3');
INSERT INTO `register` VALUES ('4', '4', '4');
INSERT INTO `register` VALUES ('5', '12', '11');
INSERT INTO `register` VALUES ('6', '44', '44');
INSERT INTO `register` VALUES ('7', 'xgl', '1');
INSERT INTO `register` VALUES ('8', '55', '55');
INSERT INTO `register` VALUES ('9', 'ee', 'ee');
INSERT INTO `register` VALUES ('10', 'qw', 'qw');
INSERT INTO `register` VALUES ('11', '', '1');
INSERT INTO `register` VALUES ('12', '', '');
INSERT INTO `register` VALUES ('13', '4', '');
INSERT INTO `register` VALUES ('14', '', '');
INSERT INTO `register` VALUES ('15', '3', '');
INSERT INTO `register` VALUES ('16', '44', '');
INSERT INTO `register` VALUES ('17', '1', '5');
INSERT INTO `register` VALUES ('18', '1', '1');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('14', '李四');
INSERT INTO `student` VALUES ('13', '张三');
INSERT INTO `student` VALUES ('10', '李四');

-- ----------------------------
-- Table structure for student_demo08_02
-- ----------------------------
DROP TABLE IF EXISTS `student_demo08_02`;
CREATE TABLE `student_demo08_02` (
  `id` int(11) NOT NULL,
  `name` varchar(12) NOT NULL,
  `sex` varchar(1) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `sno` varchar(10) NOT NULL,
  `school` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student_demo08_02
-- ----------------------------
INSERT INTO `student_demo08_02` VALUES ('2', '王浩', '男', '19', 'SP001', '广大华软');
INSERT INTO `student_demo08_02` VALUES ('4', '王浩', '男', '19', 'SP001', '广大华软');

-- ----------------------------
-- Table structure for student_demo08_03
-- ----------------------------
DROP TABLE IF EXISTS `student_demo08_03`;
CREATE TABLE `student_demo08_03` (
  `sid` int(11) NOT NULL,
  `sno` varchar(10) DEFAULT NULL,
  `school` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student_demo08_03
-- ----------------------------
INSERT INTO `student_demo08_03` VALUES ('3', 'PD001', '广大华软');
INSERT INTO `student_demo08_03` VALUES ('6', 'PD001', '广大华软');
INSERT INTO `student_demo08_03` VALUES ('9', 'PD001', '广大华软');
INSERT INTO `student_demo08_03` VALUES ('12', 'PD001', '广大华软');

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `sex` varchar(2) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', '郑敏', '2019-10-21 23:26:54', '人', '武汉');
INSERT INTO `tb_user` VALUES ('2', '王五', '2019-10-30 23:31:33', '男', '广州');
INSERT INTO `tb_user` VALUES ('4', 'HIBERNATE', '2019-10-21 23:41:09', '妖', 'BEIJING');
INSERT INTO `tb_user` VALUES ('5', 'HIBERNATE', '2019-10-23 18:19:07', '妖', 'BEIJING');

-- ----------------------------
-- Table structure for worker_demo08_03
-- ----------------------------
DROP TABLE IF EXISTS `worker_demo08_03`;
CREATE TABLE `worker_demo08_03` (
  `wid` int(11) NOT NULL,
  `wno` varchar(10) DEFAULT NULL,
  `salary` double DEFAULT NULL,
  PRIMARY KEY (`wid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of worker_demo08_03
-- ----------------------------
INSERT INTO `worker_demo08_03` VALUES ('2', 'SD0001', '6000');
INSERT INTO `worker_demo08_03` VALUES ('5', 'SD0001', '6000');
INSERT INTO `worker_demo08_03` VALUES ('8', 'SD0001', '6000');
INSERT INTO `worker_demo08_03` VALUES ('11', 'SD0001', '6000');

-- ----------------------------
-- Table structure for work_demo08_02
-- ----------------------------
DROP TABLE IF EXISTS `work_demo08_02`;
CREATE TABLE `work_demo08_02` (
  `id` int(11) NOT NULL,
  `name` varchar(12) NOT NULL,
  `sex` varchar(1) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `wno` varchar(10) NOT NULL,
  `salary` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of work_demo08_02
-- ----------------------------
INSERT INTO `work_demo08_02` VALUES ('1', '李然', '女', '28', 'P00001', '6000');
INSERT INTO `work_demo08_02` VALUES ('3', '李然', '女', '28', 'P00001', '6000');
