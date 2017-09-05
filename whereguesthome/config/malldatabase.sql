/*
Navicat MySQL Data Transfer

Source Server         : 本地MSQ
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : malldatabase

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-09-05 10:00:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `p_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '地址id',
  `u_id` int(11) NOT NULL COMMENT '用户id',
  `p_address` varchar(50) NOT NULL COMMENT '收货地址',
  `p_phone` varchar(11) NOT NULL COMMENT '收货电话',
  `p_realname` varchar(32) NOT NULL COMMENT '收货人姓名',
  `p_zip` varchar(32) NOT NULL COMMENT '邮编',
  PRIMARY KEY (`p_id`),
  KEY `p_u_id` (`u_id`),
  CONSTRAINT `p_u_id` FOREIGN KEY (`u_id`) REFERENCES `user` (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `a_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `a_name` varchar(20) NOT NULL COMMENT '用户名',
  `a_passwor` varchar(20) NOT NULL COMMENT '密码',
  PRIMARY KEY (`a_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `g_id` int(32) NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `g_name` varchar(32) NOT NULL COMMENT '商品名称',
  `g_price` double NOT NULL COMMENT '原价',
  `g_saleprice` double NOT NULL COMMENT '销售价格',
  `g_describes` text NOT NULL COMMENT '商品描述',
  `g_contents` text COMMENT '商品介绍',
  `g_photo` varchar(100) DEFAULT NULL COMMENT '商品照片',
  `g_repertory` int(11) NOT NULL COMMENT '商品储量',
  `g_saledate` date NOT NULL COMMENT '上货时间',
  `s_id` int(11) NOT NULL COMMENT '类别id',
  `g_status` int(2) NOT NULL COMMENT '状态',
  PRIMARY KEY (`g_id`),
  KEY `g_s_id` (`s_id`),
  CONSTRAINT `g_s_id` FOREIGN KEY (`s_id`) REFERENCES `sort` (`s_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for items
-- ----------------------------
DROP TABLE IF EXISTS `items`;
CREATE TABLE `items` (
  `o_id` int(11) NOT NULL COMMENT '订单编号',
  `g_id` int(11) NOT NULL COMMENT '商品编号',
  `i_count` int(11) NOT NULL COMMENT '数量',
  KEY `i_g_id` (`g_id`),
  KEY `i_o_id` (`o_id`),
  CONSTRAINT `i_g_id` FOREIGN KEY (`g_id`) REFERENCES `goods` (`g_id`),
  CONSTRAINT `i_o_id` FOREIGN KEY (`o_id`) REFERENCES `order` (`o_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `o_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单编号',
  `u_id` int(11) NOT NULL COMMENT '用户id',
  `o_realname` varchar(32) NOT NULL COMMENT '收货姓名',
  `o_address` varchar(100) NOT NULL COMMENT '收货地址',
  `o_zip` varchar(32) DEFAULT NULL COMMENT '邮编',
  `o_phone` varchar(11) NOT NULL COMMENT '收货电话',
  `o_payment` varchar(32) NOT NULL COMMENT '支付方式',
  `o_remarks` varchar(100) DEFAULT NULL COMMENT '备注',
  `o_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '下单时间',
  `o_tag` varchar(32) DEFAULT NULL COMMENT '是否发货',
  `o_price` double NOT NULL COMMENT '价格',
  `o_orderId` varchar(32) NOT NULL COMMENT '唯一订单号',
  PRIMARY KEY (`o_id`),
  KEY `o_u_id` (`u_id`),
  CONSTRAINT `o_u_id` FOREIGN KEY (`u_id`) REFERENCES `user` (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for shopcar
-- ----------------------------
DROP TABLE IF EXISTS `shopcar`;
CREATE TABLE `shopcar` (
  `u_id` int(11) NOT NULL COMMENT '用户ID',
  `g_id` int(11) NOT NULL COMMENT '商品id',
  `s_num` int(11) DEFAULT NULL COMMENT '购买数量',
  PRIMARY KEY (`u_id`,`g_id`),
  KEY `FK_g_id` (`g_id`),
  CONSTRAINT `FK_g_id` FOREIGN KEY (`g_id`) REFERENCES `goods` (`g_id`),
  CONSTRAINT `FK_u_id` FOREIGN KEY (`u_id`) REFERENCES `user` (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sort
-- ----------------------------
DROP TABLE IF EXISTS `sort`;
CREATE TABLE `sort` (
  `s_id` int(32) NOT NULL AUTO_INCREMENT COMMENT '类别id',
  `s_name` varchar(32) NOT NULL COMMENT '类别名',
  PRIMARY KEY (`s_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `u_id` int(32) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `u_name` varchar(32) NOT NULL COMMENT '用户名',
  `u_sex` varchar(10) DEFAULT NULL COMMENT '性别',
  `u_password` varchar(32) NOT NULL COMMENT '密码',
  `u_phone` varchar(11) NOT NULL COMMENT '电话',
  `u_email` varchar(32) NOT NULL COMMENT '邮箱',
  `u_account` varchar(32) NOT NULL COMMENT '账号',
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
SET FOREIGN_KEY_CHECKS=1;
