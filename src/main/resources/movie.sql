/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50635
Source Host           : localhost:3306
Source Database       : movie

Target Server Type    : MYSQL
Target Server Version : 50635
File Encoding         : 65001

Date: 2018-04-22 23:46:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for film
-- ----------------------------
DROP TABLE IF EXISTS `film`;
CREATE TABLE `film` (
  `id` int(11) NOT NULL,
  `film_name` varchar(255) NOT NULL DEFAULT '',
  `director` varchar(255) NOT NULL DEFAULT '',
  `actor` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of film
-- ----------------------------

-- ----------------------------
-- Table structure for show
-- ----------------------------
DROP TABLE IF EXISTS `show`;
CREATE TABLE `show` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL DEFAULT '',
  `show_name` varchar(255) NOT NULL DEFAULT '',
  `director` varchar(100) NOT NULL DEFAULT '',
  `actor` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of show
-- ----------------------------
