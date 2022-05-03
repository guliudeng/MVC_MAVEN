package cn.cry.bo.order;

import lombok.Data;

@Data
public class UpdateOrderReqBO {
    /**
     * 用户号码
     */
    private String userPhone;
    /**
     * 订单地址
     */
    private String orderAddress;
    /**
     * 订单状态，商家才可以修改
     */
    private String orderStatus;
    private Integer orderId;

}
