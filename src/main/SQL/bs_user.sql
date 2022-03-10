CREATE TABLE `bs_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_name` varchar(20) DEFAULT NULL COMMENT '用户名称',
  `password` varchar(20) DEFAULT NULL COMMENT '密码',
  `phone` varchar(20) DEFAULT NULL COMMENT '电话',
  `sex` varchar(10) DEFAULT NULL COMMENT '性别',
  `address` varchar(50) DEFAULT NULL COMMENT '地址',
  `shop_code` varchar(30) DEFAULT NULL COMMENT '店铺编码，只有商家才有值',
  `create_time` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `delete_flag` varchar(10) DEFAULT NULL COMMENT '删除标识',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;