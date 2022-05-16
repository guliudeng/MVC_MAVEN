package cn.cry.controller;

import cn.cry.bo.base.Rsp;
import cn.cry.bo.base.RspList;
import cn.cry.bo.order.QueryOrderReqBO;
import cn.cry.bo.product.AddProductReqBO;
import cn.cry.bo.product.UpdateProductReqBO;
import cn.cry.bo.waiMai.AddWaiMaiReqBO;
import cn.cry.bo.waiMai.QueryWaiMaiReqBO;
import cn.cry.bo.waiMai.UpdateWaiMaiReqBO;
import cn.cry.constant.RoleConstant;
import cn.cry.po.BsUser;
import cn.cry.service.WaiMaiService;
import cn.cry.utils.BaseRspUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.annotation.Resource;

@Controller
public class WaiMaiController {
    @Resource
    private WaiMaiService waiMaiService;

    /**
     * 查询配送人员信息
     * @param reqBO
     * @param userInfo
     * @return
     */
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
    /**
     * 添加外卖人员
     * @return
     */
    @RequestMapping(value = "addWaiMaiInterface",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Rsp addWaiMaiInterface(@RequestBody AddWaiMaiReqBO reqBO, @SessionAttribute("userInfo") BsUser userInfo ){
        System.out.println("session="+userInfo);
        reqBO.setTenantId(userInfo.getShopCode());
        Rsp rsp = waiMaiService.add(reqBO);
        return rsp;
    }

    /**
     * 修改配送人员
     * @param reqBO
     * @return
     */
    @RequestMapping(value = "updateWaiMai",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Rsp updateWaiMai(@RequestBody UpdateWaiMaiReqBO reqBO) {
        return waiMaiService.update(reqBO);
    }

    /**
     * 删除配送人员
     * @param waiMaiId
     * @return
     */
    @RequestMapping(value = "deleteWaiMai",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Rsp deleteWaiMai(Integer waiMaiId) {
        return waiMaiService.delete(waiMaiId);
    }
}
