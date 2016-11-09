/*
Navicat MySQL Data Transfer

Source Server         : localhost215
Source Server Version : 50525
Source Host           : localhost:3306
Source Database       : touna

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2016-11-09 15:56:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for ad
-- ----------------------------
DROP TABLE IF EXISTS `ad`;
CREATE TABLE `ad` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `doNotDisturb` int(11) DEFAULT '0',
  `imgUrl` varchar(255) DEFAULT NULL,
  `sequence` varchar(255) DEFAULT '',
  `title` varchar(255) DEFAULT '',
  `status` int(11) DEFAULT '0',
  `type` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ad
-- ----------------------------

-- ----------------------------
-- Table structure for config
-- ----------------------------
DROP TABLE IF EXISTS `config`;
CREATE TABLE `config` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ip` varchar(255) DEFAULT '',
  `port` int(11) DEFAULT NULL,
  `time` int(11) DEFAULT NULL,
  `data` varchar(255) DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of config
-- ----------------------------
INSERT INTO `config` VALUES ('1', '192.168.80.238', '8080', null, '');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `amount` int(11) DEFAULT '0',
  `apr` decimal(25,0) DEFAULT '0',
  `beginTime` int(11) DEFAULT '0',
  `buyerSum` int(11) DEFAULT '0',
  `desc` varchar(255) DEFAULT '',
  `key` varchar(255) DEFAULT '',
  `minTender` int(11) DEFAULT '0',
  `name` varchar(255) DEFAULT '',
  `period` varchar(255) DEFAULT '',
  `sbAmt` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `subscribe` int(11) DEFAULT NULL,
  `url` varchar(255) DEFAULT '',
  `tags` varchar(510) DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', '10', '0', '0', '0', '', '', '0', '', '', null, null, null, '', '');
INSERT INTO `product` VALUES ('2', '20', '0', '0', '0', '', '', '0', '', '', null, null, null, '', '');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT '',
  `password` varchar(255) DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'liujun', '123456');
INSERT INTO `user` VALUES ('2', 'liang', '123123');
