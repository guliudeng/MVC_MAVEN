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

 Date: 05/05/2022 00:34:57
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bs_order
-- ----------------------------
DROP TABLE IF EXISTS `bs_order`;
CREATE TABLE `bs_order`  (
  `order_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `tenant_id` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '租户id',
  `user_name` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户名',
  `user_phone` varchar(13) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户号码',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `order_status` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '订单状态；已下单，已接单，配送中，配送完成',
  `product_id` int(11) NULL DEFAULT NULL COMMENT '商品id',
  `product_name` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '商品名称',
  `product_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '商品价格',
  `product_num` int(11) NULL DEFAULT NULL COMMENT '商品数量',
  `order_sum_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '订单总价',
  `order_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '订单地址',
  `create_time` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建时间',
  `tran_time` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '配送时间',
  `finish_time` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '完成时间',
  `delete_flag` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '0' COMMENT '删除标识',
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bs_order
-- ----------------------------
INSERT INTO `bs_order` VALUES (1, 'CC', 'gg', '18726341500', 4, '已下单', 2, '防灾科技学院', 66.00, 1, 66.00, '燕郊爱民路', '2022-05-04 03:02:00', NULL, NULL, '0');
INSERT INTO `bs_order` VALUES (2, 'CC', 'gg', '18726341500', 4, '已下单', 4, '设计图', 44.00, 1, 44.00, '北京顺义', '2022-05-04 03:10:00', NULL, NULL, '0');
INSERT INTO `bs_order` VALUES (3, 'CC', 'cc', '158', 1, '已下单', 2, '防灾科技学院', 66.00, 1, 66.00, '燕郊爱民路', '2022-05-04 03:11:00', NULL, NULL, '0');

SET FOREIGN_KEY_CHECKS = 1;
