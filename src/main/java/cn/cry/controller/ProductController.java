package cn.cry.controller;

import cn.cry.bo.base.Rsp;
import cn.cry.bo.base.RspList;
import cn.cry.bo.product.AddProductReqBO;
import cn.cry.bo.product.QryShopProductReqBO;
import cn.cry.bo.product.UpdateProductReqBO;
import cn.cry.bo.user.LoginUserInfoBO;
import cn.cry.constant.RoleConstant;
import cn.cry.po.BsUser;
import cn.cry.service.ProductService;
import cn.cry.utils.BaseRspUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 *商品控制器
 */
@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    /**
     * 查询商品
     * @return
     */
    @RequestMapping(value = "qryProduct",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public RspList qryProduct(QryShopProductReqBO reqBO, @SessionAttribute("userInfo") BsUser userInfo){
        System.out.println("session="+userInfo);
        if (null == userInfo || !RoleConstant.ADMIN_ROLE.equals(userInfo.getRole()) ) {
            return BaseRspUtils.createErrorRspList("权限获取失败，无法执行添加操作");
        }
             reqBO.setTenantId(userInfo.getShopCode());
        RspList rspList = productService.qryShopProduct(reqBO);
        return rspList;
    }

    /**
     * 添加商品
     * @return
     */
    @RequestMapping(value = "addProductInterface",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Rsp addProduct(@RequestBody AddProductReqBO reqBO, @SessionAttribute("userInfo") BsUser userInfo ){
        System.out.println("session="+userInfo);
        if (null == userInfo || !RoleConstant.ADMIN_ROLE.equals(userInfo.getRole()) ) {
            return BaseRspUtils.createErrorRsp("权限获取失败，无法执行添加操作");
        }
        reqBO.setTenantId(userInfo.getShopCode());
       Rsp rsp = productService.addProduct(reqBO);
        return rsp;
    }

    @RequestMapping(value = "qryShop" ,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public RspList qryShop() {
        RspList rspList = productService.qryShop();
        return rspList;
    }

    @RequestMapping(value = "updateProduct",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Rsp update(@RequestBody UpdateProductReqBO reqBO) {
        return productService.updateProduct(reqBO);
    }

    @RequestMapping(value = "deleteProduct",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Rsp delete(Integer productId) {
        return productService.deleteProduct(productId);
    }

    @RequestMapping(value = "qryProductUser",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public RspList qryProductUser(@RequestParam("tenantId") String tenantId){
        /**
         * 用户查询商铺下已上架的商铺
         */
        RspList rspList = productService.qryShopUpProduct(tenantId);
        return rspList;
    }
}
