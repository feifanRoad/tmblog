/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 60011
Source Host           : localhost:3306
Source Database       : kekeblog2

Target Server Type    : MYSQL
Target Server Version : 60011
File Encoding         : 65001

Date: 2015-11-29 02:02:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for keke_[smallBeanName]
-- ----------------------------
DROP TABLE IF EXISTS `keke_[smallBeanName]`;
CREATE TABLE `keke_[smallBeanName]` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `status` int(1) DEFAULT NULL,
  `name` varchar(200) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT NULL,
  `is_delete` int(1) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of keke_[smallBeanName]
-- ----------------------------
INSERT INTO `keke_[smallBeanName]` VALUES ('1', '1', '测试1', '2017-07-29 01:46:38', null, '0', '1', '1');
INSERT INTO `keke_[smallBeanName]` VALUES ('2', '1', '测试2', '2017-07-29 01:46:38', '2015-11-29 01:46:47', '0', '1', '1');
INSERT INTO `keke_[smallBeanName]` VALUES ('3', '1', '测试3', '2017-07-29 01:46:38', '2015-11-29 01:46:47', '0', '1', '1');
INSERT INTO `keke_[smallBeanName]` VALUES ('4', '1', '测试4', '2017-07-29 01:46:38', '2015-11-29 01:46:47', '0', '1', '1');
INSERT INTO `keke_[smallBeanName]` VALUES ('5', '1', '测试5', '2017-07-29 01:46:38', '2015-11-29 01:46:47', '0', '1', '1');
INSERT INTO `keke_[smallBeanName]` VALUES ('6', '1', '测试6', '2017-07-29 01:46:38', '2015-11-29 01:46:47', '0', '1', '1');
INSERT INTO `keke_[smallBeanName]` VALUES ('7', '1', '测试7', '2017-07-29 01:46:38', '2015-11-29 01:46:47', '0', '1', '1');
INSERT INTO `keke_[smallBeanName]` VALUES ('8', '1', '测试8', '2017-07-29 01:46:38', '2015-11-29 01:46:47', '0', '1', '1');
