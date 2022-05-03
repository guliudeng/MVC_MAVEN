package cn.cry.bo.order;

import lombok.Data;



@Data
public class AddOrderReqBO {
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
    //private String orderStatus;

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
    private String productPrice;

    /**
     * 商品数量
     */
    private Integer productNum;

    /**
     * 订单总价
     */
    private String orderSumPrice;

    /**
     * 订单地址
     */
    private String orderAddress;

}
