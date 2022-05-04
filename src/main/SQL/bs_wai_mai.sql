/*
 Navicat Premium Data Transfer

 Source Server         : Mysql-1
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 05/05/2022 00:35:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bs_wai_mai
-- ----------------------------
DROP TABLE IF EXISTS `bs_wai_mai`;
CREATE TABLE `bs_wai_mai`  (
  `wai_mai_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '外卖人员id',
  `wai_mai_name` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '外卖人员姓名',
  `wai_mai_phone` varchar(13) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '外卖人员电话',
  `wai_mai_address` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '外卖人员地址',
  `tenant_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '租户id',
  `delete_flag` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '0' COMMENT '删除标识',
  `create_time` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`wai_mai_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bs_wai_mai
-- ----------------------------
INSERT INTO `bs_wai_mai` VALUES (1, '谷谷', '187', '北京', 'CC', '0', '2022-05-05 00:25:00');
INSERT INTO `bs_wai_mai` VALUES (2, '丽丽', '158', '浙江', 'CC', '0', '2022-05-05 00:25:00');

SET FOREIGN_KEY_CHECKS = 1;
