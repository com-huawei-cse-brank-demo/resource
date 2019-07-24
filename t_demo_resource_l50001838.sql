/*
 Navicat MySQL Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : localhost:3306
 Source Schema         : paasdemo

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : 65001

 Date: 24/07/2019 18:04:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_demo_resource_l50001838
-- ----------------------------
DROP TABLE IF EXISTS `t_demo_resource_l50001838`;
CREATE TABLE `t_demo_resource_l50001838` (
  `resource_id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` int(11) DEFAULT NULL,
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT 'FREE',
  PRIMARY KEY (`resource_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_demo_resource_l50001838
-- ----------------------------
BEGIN;
INSERT INTO `t_demo_resource_l50001838` VALUES (1, NULL, 'FREE');
INSERT INTO `t_demo_resource_l50001838` VALUES (2, NULL, 'FREE');
INSERT INTO `t_demo_resource_l50001838` VALUES (3, NULL, 'FREE');
INSERT INTO `t_demo_resource_l50001838` VALUES (4, NULL, 'FREE');
INSERT INTO `t_demo_resource_l50001838` VALUES (5, NULL, 'FREE');
INSERT INTO `t_demo_resource_l50001838` VALUES (6, NULL, 'FREE');
INSERT INTO `t_demo_resource_l50001838` VALUES (7, NULL, 'FREE');
INSERT INTO `t_demo_resource_l50001838` VALUES (8, NULL, 'FREE');
INSERT INTO `t_demo_resource_l50001838` VALUES (9, NULL, 'FREE');
INSERT INTO `t_demo_resource_l50001838` VALUES (10, NULL, 'FREE');
INSERT INTO `t_demo_resource_l50001838` VALUES (11, NULL, 'FREE');
INSERT INTO `t_demo_resource_l50001838` VALUES (12, NULL, 'FREE');
INSERT INTO `t_demo_resource_l50001838` VALUES (13, NULL, 'FREE');
INSERT INTO `t_demo_resource_l50001838` VALUES (14, NULL, 'FREE');
INSERT INTO `t_demo_resource_l50001838` VALUES (15, NULL, 'FREE');
INSERT INTO `t_demo_resource_l50001838` VALUES (16, NULL, 'FREE');
INSERT INTO `t_demo_resource_l50001838` VALUES (17, NULL, 'FREE');
INSERT INTO `t_demo_resource_l50001838` VALUES (18, NULL, 'FREE');
INSERT INTO `t_demo_resource_l50001838` VALUES (19, NULL, 'FREE');
INSERT INTO `t_demo_resource_l50001838` VALUES (20, NULL, 'FREE');
INSERT INTO `t_demo_resource_l50001838` VALUES (21, NULL, 'FREE');
INSERT INTO `t_demo_resource_l50001838` VALUES (22, NULL, 'FREE');
INSERT INTO `t_demo_resource_l50001838` VALUES (23, NULL, 'FREE');
INSERT INTO `t_demo_resource_l50001838` VALUES (24, NULL, 'FREE');
INSERT INTO `t_demo_resource_l50001838` VALUES (25, NULL, 'FREE');
INSERT INTO `t_demo_resource_l50001838` VALUES (26, NULL, 'FREE');
INSERT INTO `t_demo_resource_l50001838` VALUES (27, NULL, 'FREE');
INSERT INTO `t_demo_resource_l50001838` VALUES (28, NULL, 'FREE');
INSERT INTO `t_demo_resource_l50001838` VALUES (29, NULL, 'FREE');
INSERT INTO `t_demo_resource_l50001838` VALUES (30, NULL, 'FREE');
INSERT INTO `t_demo_resource_l50001838` VALUES (31, NULL, 'FREE');
INSERT INTO `t_demo_resource_l50001838` VALUES (32, NULL, 'FREE');
INSERT INTO `t_demo_resource_l50001838` VALUES (33, NULL, 'FREE');
INSERT INTO `t_demo_resource_l50001838` VALUES (34, NULL, 'FREE');
INSERT INTO `t_demo_resource_l50001838` VALUES (35, NULL, 'FREE');
INSERT INTO `t_demo_resource_l50001838` VALUES (36, NULL, 'FREE');
INSERT INTO `t_demo_resource_l50001838` VALUES (37, NULL, 'FREE');
INSERT INTO `t_demo_resource_l50001838` VALUES (38, NULL, 'FREE');
INSERT INTO `t_demo_resource_l50001838` VALUES (39, NULL, 'FREE');
INSERT INTO `t_demo_resource_l50001838` VALUES (40, NULL, 'FREE');
INSERT INTO `t_demo_resource_l50001838` VALUES (41, NULL, 'FREE');
INSERT INTO `t_demo_resource_l50001838` VALUES (42, NULL, 'FREE');
INSERT INTO `t_demo_resource_l50001838` VALUES (43, NULL, 'FREE');
INSERT INTO `t_demo_resource_l50001838` VALUES (44, NULL, 'FREE');
INSERT INTO `t_demo_resource_l50001838` VALUES (45, NULL, 'FREE');
INSERT INTO `t_demo_resource_l50001838` VALUES (46, NULL, 'FREE');
INSERT INTO `t_demo_resource_l50001838` VALUES (47, NULL, 'FREE');
INSERT INTO `t_demo_resource_l50001838` VALUES (48, NULL, 'FREE');
INSERT INTO `t_demo_resource_l50001838` VALUES (49, NULL, 'FREE');
INSERT INTO `t_demo_resource_l50001838` VALUES (50, NULL, 'FREE');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
