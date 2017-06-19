/*
Navicat MySQL Data Transfer

Source Server         : zj
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : weather

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-06-19 15:52:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_city
-- ----------------------------
DROP TABLE IF EXISTS `tb_city`;
CREATE TABLE `tb_city` (
  `cityId` int(11) NOT NULL AUTO_INCREMENT,
  `cunname` varchar(255) COLLATE utf8_bin NOT NULL,
  `cityName` varchar(255) COLLATE utf8_bin NOT NULL,
  `districtName` varchar(255) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`cityId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for tb_life
-- ----------------------------
DROP TABLE IF EXISTS `tb_life`;
CREATE TABLE `tb_life` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `day` date DEFAULT NULL,
  `desc` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `status` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `cityId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_constraint_life` (`cityId`),
  CONSTRAINT `fk_constraint_life` FOREIGN KEY (`cityId`) REFERENCES `tb_city` (`cityId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for tb_temp
-- ----------------------------
DROP TABLE IF EXISTS `tb_temp`;
CREATE TABLE `tb_temp` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `hour` int(11) DEFAULT NULL,
  `temp` int(11) DEFAULT NULL,
  `cityId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_constraint_temp` (`cityId`),
  CONSTRAINT `fk_constraint_temp` FOREIGN KEY (`cityId`) REFERENCES `tb_city` (`cityId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for tb_warning
-- ----------------------------
DROP TABLE IF EXISTS `tb_warning`;
CREATE TABLE `tb_warning` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `level` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `pub_date` datetime DEFAULT NULL,
  `title` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `type` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `cityId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_constraint_warning` (`cityId`),
  CONSTRAINT `fk_constraint_warning` FOREIGN KEY (`cityId`) REFERENCES `tb_city` (`cityId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for tb_weather
-- ----------------------------
DROP TABLE IF EXISTS `tb_weather`;
CREATE TABLE `tb_weather` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `day` date DEFAULT NULL,
  `conditionDay` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `tempDay` int(11) DEFAULT NULL,
  `tempNight` int(11) DEFAULT NULL,
  `cityId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_constraint_wea` (`cityId`),
  CONSTRAINT `fk_constraint_wea` FOREIGN KEY (`cityId`) REFERENCES `tb_city` (`cityId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
