package cn.cry.controller;

import cn.cry.bo.base.Rsp;
import cn.cry.bo.base.RspList;
import cn.cry.bo.order.AddOrderReqBO;
import cn.cry.bo.order.QueryOrderReqBO;
import cn.cry.bo.order.UpdateOrderReqBO;
import cn.cry.bo.product.QryShopProductReqBO;
import cn.cry.constant.RoleConstant;
import cn.cry.po.BsUser;
import cn.cry.service.OrderService;
import cn.cry.utils.BaseRspUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.annotation.Resource;

/**
 * 订单controller
 */
@Controller
public class OrderController {

    @Resource
    private OrderService orderService;

    @RequestMapping(value = "qryOrder",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public RspList qryOrder(QueryOrderReqBO reqBO, @SessionAttribute("userInfo") BsUser userInfo){
        /**
         * 用户身份根据用户的id去匹配订单信息
         * 商家身份根据租户id去匹配订单信息
         * 管理员可以看到全部未删除的订单，但是不可以操作
         */
        System.out.println("session="+userInfo);
        if (RoleConstant.ADMIN_ROLE.equals(userInfo.getRole())) {
            reqBO.setTenantId(userInfo.getShopCode());
        }else if (RoleConstant.STUDENT_ROLE.equals(userInfo.getRole())){
            reqBO.setUserId(userInfo.getUserId());
        }

        RspList rspList = orderService.query(reqBO);
        return rspList;
    }

    @RequestMapping(value = "addOrder",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Rsp addOrder(@RequestBody AddOrderReqBO reqBO, @SessionAttribute("userInfo") BsUser userInfo){
        reqBO.setUserId(userInfo.getUserId());
        if (StringUtils.isEmpty(reqBO.getUserName())) {
            reqBO.setUserName(userInfo.getUserName());
        }
       if (StringUtils.isEmpty(reqBO.getUserPhone())) {
           reqBO.setUserPhone(userInfo.getPhone());
       }
        reqBO.setOrderSumPrice(reqBO.getProductPrice());
        reqBO.setProductNum(1);

        Rsp rsp = orderService.add(reqBO);
        return rsp;
    }
    @RequestMapping(value = "updateOrder",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Rsp updateOrder(@RequestBody UpdateOrderReqBO reqBO) {
        Rsp update = orderService.update(reqBO);
        return update;
    }
}
