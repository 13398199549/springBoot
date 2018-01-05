/*
Navicat MySQL Data Transfer

Source Server         : amoeba
Source Server Version : 50145
Source Host           : 192.168.43.100:8066
Source Database       : amoeba

Target Server Type    : MYSQL
Target Server Version : 50145
File Encoding         : 65001

Date: 2018-01-02 17:04:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `login_name` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `gender` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', '小黄峰', 'p', '123456', '1');
INSERT INTO `t_user` VALUES ('2', '张龙', 'zl', '123456', '1');
INSERT INTO `t_user` VALUES ('4', '李斯', 'ls', '123456', '1');
INSERT INTO `t_user` VALUES ('5', '大黄峰', 'p', '123456', '1');
