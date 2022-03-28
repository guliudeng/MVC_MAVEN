package cn.cry.po;

import java.math.BigDecimal;
import lombok.Data;

/**
    * 商品信息表
    */
@Data
public class BsProduct {
    /**
    * 商品主键
    */
    private Integer productId;

    /**
    * 商品名称
    */
    private String productName;

    /**
    * 商品价格
    */
    private BigDecimal productPrice;

    /**
    * 租户id
    */
    private String tenantId;

    /**
    * 商品照片
    */
    private String productPhoto;

    /**
    * 商品类型
    */
    private String productType;

    /**
    * 商品状态,up-上架,down-下架
    */
    private String productStatus;

    /**
    * 删除标识
    */
    private String deleteFlag;

    /**
    * 创建时间
    */
    private String createTime;

    /**
    * 更新时间
    */
    private String updateTime;
}