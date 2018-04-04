
CREATE DATABASE ccp_auth DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
Use ccp_auth;
/*
 Navicat Premium Data Transfer

 Source Server         : ccp-admin
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : localhost
 Source Database       : ccp_auth

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : utf-8

 Date: 02/25/2018 14:59:42 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `auth_client`
-- ----------------------------
DROP TABLE IF EXISTS `auth_client`;
CREATE TABLE `auth_client` (
  `id` varchar(36) NOT NULL,
  `code` varchar(255) DEFAULT NULL COMMENT '服务编码',
  `secret` varchar(255) DEFAULT NULL COMMENT '服务密钥',
  `name` varchar(255) DEFAULT NULL COMMENT '服务名',
  `locked` char(1) DEFAULT NULL COMMENT '是否锁定',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `crt_time` datetime DEFAULT NULL COMMENT '创建时间',
  `crt_user` varchar(255) DEFAULT NULL COMMENT '创建人',
  `crt_name` varchar(255) DEFAULT NULL COMMENT '创建人姓名',
  `crt_host` varchar(255) DEFAULT NULL COMMENT '创建主机',
  `upd_time` datetime DEFAULT NULL COMMENT '更新时间',
  `upd_user` varchar(255) DEFAULT NULL COMMENT '更新人',
  `upd_name` varchar(255) DEFAULT NULL COMMENT '更新姓名',
  `upd_host` varchar(255) DEFAULT NULL COMMENT '更新主机',
  `attr1` varchar(255) DEFAULT NULL,
  `attr2` varchar(255) DEFAULT NULL,
  `attr3` varchar(255) DEFAULT NULL,
  `attr4` varchar(255) DEFAULT NULL,
  `attr5` varchar(255) DEFAULT NULL,
  `attr6` varchar(255) DEFAULT NULL,
  `attr7` varchar(255) DEFAULT NULL,
  `attr8` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Records of `auth_client`
-- ----------------------------
BEGIN;
INSERT INTO `auth_client` VALUES ('1', 'ccp-gate', '123456', 'ccp-gate', '0', '服务网关', null, '', '', '', '2017-07-07 21:51:32', '1', '管理员', '0:0:0:0:0:0:0:1', '', '', '', '', '', '', '', ''), ('18', 'ccp-transaction', '123456', 'ccp-transaction', '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('20', 'ccp-dict', '123566', 'ccp-dict', '0', '数据字典服务', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('21', 'ccp-demo-depart-data', '123456', 'ccp-demo-depart-data', '0', '测试服务', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('3', 'ccp-admin', '123456', 'ccp-admin', '0', '', null, null, null, null, '2017-07-06 21:42:17', '1', '管理员', '0:0:0:0:0:0:0:1', null, null, null, null, null, null, null, null), ('6', 'ccp-auth', '123456', 'ccp-auth', '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
COMMIT;

-- ----------------------------
--  Table structure for `auth_client_service`
-- ----------------------------
DROP TABLE IF EXISTS `auth_client_service`;
CREATE TABLE `auth_client_service` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `service_id` varchar(255) DEFAULT NULL,
  `client_id` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `crt_time` datetime DEFAULT NULL,
  `crt_user` varchar(255) DEFAULT NULL,
  `crt_name` varchar(255) DEFAULT NULL,
  `crt_host` varchar(255) DEFAULT NULL,
  `attr1` varchar(255) DEFAULT NULL,
  `attr2` varchar(255) DEFAULT NULL,
  `attr3` varchar(255) DEFAULT NULL,
  `attr4` varchar(255) DEFAULT NULL,
  `attr5` varchar(255) DEFAULT NULL,
  `attr6` varchar(255) DEFAULT NULL,
  `attr7` varchar(255) DEFAULT NULL,
  `attr8` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Records of `auth_client_service`
-- ----------------------------
BEGIN;
INSERT INTO `auth_client_service` VALUES ('21', '4', '5', null, null, null, null, null, null, null, null, null, null, null, null, null), ('43', '3', '16', null, null, null, null, null, null, null, null, null, null, null, null, null), ('45', '12', '16', null, null, null, null, null, null, null, null, null, null, null, null, null), ('46', '18', '18', null, null, null, null, null, null, null, null, null, null, null, null, null), ('53', '3', '6', null, null, null, null, null, null, null, null, null, null, null, null, null), ('61', '3', '1', null, null, null, null, null, null, null, null, null, null, null, null, null), ('62', '6', '1', null, null, null, null, null, null, null, null, null, null, null, null, null), ('63', '20', '1', null, null, null, null, null, null, null, null, null, null, null, null, null), ('65', '3', '21', null, null, null, null, null, null, null, null, null, null, null, null, null);
COMMIT;

-- ----------------------------
--  Table structure for `gateway_route`
-- ----------------------------
DROP TABLE IF EXISTS `gateway_route`;
CREATE TABLE `gateway_route` (
  `id` varchar(50) NOT NULL,
  `path` varchar(255) NOT NULL COMMENT '映射路劲',
  `service_id` varchar(50) DEFAULT NULL COMMENT '映射服务',
  `url` varchar(255) DEFAULT NULL COMMENT '映射外连接',
  `retryable` tinyint(1) DEFAULT NULL COMMENT '是否重试',
  `enabled` tinyint(1) NOT NULL COMMENT '是否启用',
  `strip_prefix` tinyint(1) DEFAULT NULL COMMENT '是否忽略前缀',
  `crt_user_name` varchar(255) DEFAULT NULL COMMENT '创建人',
  `crt_user_id` varchar(36) DEFAULT NULL COMMENT '创建人ID',
  `crt_time` datetime DEFAULT NULL COMMENT '创建时间',
  `upd_user_name` varchar(255) DEFAULT NULL COMMENT '最后更新人',
  `upd_user_id` varchar(36) DEFAULT NULL COMMENT '最后更新人ID',
  `upd_time` datetime DEFAULT NULL COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `gateway_route`
-- ----------------------------
BEGIN;
INSERT INTO `gateway_route` VALUES ('admin', '/admin/**', 'ccp-admin', null, '0', '1', '1', 'Mr.AG', '1', '2018-02-25 14:33:30', 'Mr.AG', '1', '2018-02-25 14:38:31'), ('auth', '/auth/**', 'ccp-auth', null, '0', '1', '1', null, null, null, 'Mr.AG', '1', '2018-02-25 14:29:51'), ('dict', '/dict/**', 'ccp-dict', null, '0', '1', '1', null, null, null, 'Mr.AG', '1', '2018-02-25 14:41:07');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
