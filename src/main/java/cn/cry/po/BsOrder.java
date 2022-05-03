package cn.cry.po;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class BsOrder {
    /**
    * 订单id
    */
    private Integer orderId;

    /**
    * 租户id
    */
    private String tenantId;

    /**
    * 用户名
    */
    private String userName;

    /**
    * 用户号码
    */
    private String userPhone;

    /**
    * 用户id
    */
    private Integer userId;

    /**
    * 订单状态；已下单，已接单，配送中，配送完成
    */
    private String orderStatus;

    /**
    * 商品id
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
    * 商品数量
    */
    private Integer productNum;

    /**
    * 订单总价
    */
    private BigDecimal orderSumPrice;

    /**
    * 订单地址
    */
    private String orderAddress;

    /**
    * 创建时间
    */
    private String createTime;

    /**
    * 配送时间
    */
    private String tranTime;

    /**
    * 完成时间
    */
    private String finishTime;

    /**
    * 删除标识
    */
    private String deleteFlag;
}