package cn.cry.controller;

import cn.cry.bo.base.RspList;
import cn.cry.bo.order.QueryOrderReqBO;
import cn.cry.bo.waiMai.QueryWaiMaiReqBO;
import cn.cry.constant.RoleConstant;
import cn.cry.po.BsUser;
import cn.cry.service.WaiMaiService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.annotation.Resource;

@Controller
public class WaiMaiController {
    @Resource
    private WaiMaiService waiMaiService;

    @RequestMapping(value = "qryWaiMai",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public RspList qryWaiMai(QueryWaiMaiReqBO reqBO, @SessionAttribute("userInfo") BsUser userInfo){
        /**
         * 商家传入租户id，管理员不传租户id，用户没有操作菜单不用考虑
         */
            if (RoleConstant.ADMIN_ROLE.equals(userInfo.getRole())) {
                reqBO.setTenantId(userInfo.getShopCode());
            }
        return  waiMaiService.query(reqBO);
    }
}
