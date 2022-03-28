CREATE TABLE `bs_product` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品主键',
  `product_name` varchar(255) NOT NULL COMMENT '商品名称',
  `product_price` decimal(10,2) NOT NULL COMMENT '商品价格',
  `tenant_id` varchar(40) NOT NULL COMMENT '租户id',
  `product_photo` varchar(255) DEFAULT NULL COMMENT '商品照片',
  `product_type` varchar(10) DEFAULT NULL COMMENT '商品类型',
  `product_status` varchar(10) NOT NULL DEFAULT 'down' COMMENT '商品状态,up-上架,down-下架',
  `delete_flag` varchar(2) NOT NULL DEFAULT '0' COMMENT '删除标识',
  `create_time` varchar(20) NOT NULL COMMENT '创建时间',
  `update_time` varchar(20) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品信息表';