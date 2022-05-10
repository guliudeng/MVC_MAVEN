package cn.cry.service.imp;

import cn.cry.bo.base.Rsp;
import cn.cry.bo.base.RspList;
import cn.cry.bo.order.AddOrderReqBO;
import cn.cry.bo.order.QueryOrderReqBO;
import cn.cry.bo.order.UpdateOrderReqBO;
import cn.cry.bo.product.UpdateProductReqBO;
import cn.cry.constant.OrderConstant;
import cn.cry.mapper.BsOrderMapper;
import cn.cry.po.BsOrder;
import cn.cry.service.OrderService;
import cn.cry.utils.BaseRspUtils;
import cn.cry.utils.DateUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderServiceImp implements OrderService {

    @Resource
    private BsOrderMapper bsOrderMapper;

    @Override
    public Rsp add(AddOrderReqBO reqBO) {
        System.out.println("新增订单入参="+reqBO);
        BsOrder po = new BsOrder();
        po.setCreateTime(DateUtils.timeForm());
        po.setOrderAddress(reqBO.getOrderAddress());
        po.setOrderStatus(OrderConstant.ORDER_STATUS_01);
        po.setOrderSumPrice(new BigDecimal(reqBO.getOrderSumPrice()));

        po.setProductId(reqBO.getProductId());
        po.setProductName(reqBO.getProductName());
        po.setProductNum(reqBO.getProductNum());
        po.setProductPrice(new BigDecimal(reqBO.getProductPrice()));

        po.setUserId(reqBO.getUserId());
        po.setUserName(reqBO.getUserName());
        po.setUserPhone(reqBO.getUserPhone());
        po.setTenantId(reqBO.getTenantId());
        int i = bsOrderMapper.insertSelective(po);
        if (i>0 ){
            return BaseRspUtils.createSuccessRsp("订单添加成功");
        }
        return BaseRspUtils.createErrorRsp("订单添加失败");
    }

    @Override
    public Rsp update(UpdateOrderReqBO reqBO) {
        /**
         * 用户只可以修改订单的电话，地址，后续可以添加取消订单状态
         * 商家可以修改订单的状态
         */
        System.out.println("修改订单入参="+reqBO);
        BsOrder po = new BsOrder();
        po.setOrderId(reqBO.getOrderId());
        po.setUserPhone(reqBO.getUserPhone());
        po.setOrderAddress(reqBO.getOrderAddress());
        po.setOrderStatus(reqBO.getOrderStatus());
        int i = bsOrderMapper.updateByPrimaryKeySelective(po);
        if (i>0) {
            return BaseRspUtils.createSuccessRsp("修改订单成功");
        }
        return BaseRspUtils.createErrorRsp("修改订单失败");
    }

    @Override
    public RspList query(QueryOrderReqBO reqBO) {
        System.out.println("查询订单入参="+reqBO);
        BsOrder po = new BsOrder();
        po.setUserPhone(reqBO.getUserPhone());
        po.setUserName(reqBO.getUserName());
        po.setUserId(reqBO.getUserId());
        po.setTenantId(reqBO.getTenantId());
      po.setProductName(reqBO.getProductName());
        List<BsOrder> orderList = bsOrderMapper.selectActive(po);
        //分页
        return BaseRspUtils.createSuccessRspList(orderList);
    }

    @Override
    public Rsp delete(Integer orderId) {
        BsOrder bsOrder = new BsOrder();
        bsOrder.setOrderId(orderId);
        bsOrder.setDeleteFlag("1");
        int i = bsOrderMapper.updateByPrimaryKeySelective(bsOrder);
        if (i>0) {
            return BaseRspUtils.createSuccessRsp("删除成功");
        }
        return BaseRspUtils.createErrorRsp("删除失败");
    }
}
