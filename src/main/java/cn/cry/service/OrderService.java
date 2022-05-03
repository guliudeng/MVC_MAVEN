package cn.cry.service;

import cn.cry.bo.base.Rsp;
import cn.cry.bo.base.RspList;
import cn.cry.bo.order.AddOrderReqBO;
import cn.cry.bo.order.QueryOrderReqBO;
import cn.cry.bo.order.UpdateOrderReqBO;
import cn.cry.bo.product.UpdateProductReqBO;

public interface OrderService {
    /**
     * 新增订单
     * @param reqBO
     * @return
     */
    Rsp add(AddOrderReqBO reqBO);

    /**
     * 修改订单
     * @param reqBO
     * @return
     */
    Rsp update(UpdateOrderReqBO reqBO);

    /**
     * 查询订单
     * @param reqBO
     * @return
     */
    RspList query(QueryOrderReqBO reqBO);

    /**
     * 删除订单
     * @param orderId
     * @return
     */
    Rsp delete(Integer orderId);
}
