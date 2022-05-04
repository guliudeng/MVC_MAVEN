package cn.cry.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 路由控制器
 */
@Controller
public class RouteController {
    @RequestMapping("adminUserManage")
    public String adminUserManage(){
        return "admin_user_manage";
    }

    /**
     * 编辑用户
     * @return
     */
    @RequestMapping("adminUserEdit")
    public String adminUserEdit(){
        return "admin_user_edit";
    }

    /**
     * 用户主页
     * @return
     */
    @RequestMapping("userIndex")
    public String userIndex(){
        return "user_index";
    }

    /**
     * 商铺列表页
     * @return
     */
    @RequestMapping("userShopIndex")
    public String userShopIndex(){
        return "user_shop_index";
    }

    /**
     * 商家主页
     * @return
     */
    @RequestMapping("shopIndex")
    public String shopIndex(){
        return "shop_index";
    }

    /**
     * 商家展示页面
     * @return
     */
    @RequestMapping("shopShow")
    public String shopShow(){
        return "shop_show";
    }

    /**
     * 商家商品管理页面
     * @return
     */
    @RequestMapping("shopProductManage")
    public String shopProductManage(){
        return "shop_product_manage";
    }

    /**
     * 用户个人信息页面
     * @return
     */
    @RequestMapping("uInfo")
    public String uInfo(){
        return "user_info";
    }

    /**
     * 修改用户信息
     * 测试升级git提交-------可忽略
     * @return
     */
    @RequestMapping("userInfoUpdate")
    public String userInfoUpdate(){
        return "user_info_update";
    }

    /**
     * 编辑商品
     * @return
     */
    @RequestMapping("editProduct")
    public String editProduct(){
        return "edit_product";
    }

    /**
     * 添加商品
     * @return
     */
    @RequestMapping("addProduct")
    public String addProduct(){
        return "add_product";
    }

    /**
     * 用户订单主页
     * @return
     */
    @RequestMapping("userOrderIndex")
    public String userOrderIndex(){
        return "user_order_index";
    }

    /**
     * 管理员订单主页
     * @return
     */
    @RequestMapping("adminOrderIndex")
    public String adminOrderIndex(){
        return "admin_order_index";
    }

    /**
     * 商家订单主页
     * @return
     */
    @RequestMapping("shopOrderIndex")
    public String shopOrderIndex(){
        return "shop_order_index";
    }

    /**
     * 商家外卖人员管理
     * @return
     */
    @RequestMapping("shopWaiMaiManage")
    public String shopWaiMaiManage(){
        return "shop_wai_mai_manage";
    }

    /**
     * 管理员外卖人员查看
     * @return
     */
    @RequestMapping("adminWaiMaiManage")
    public String adminWaiMaiManage(){
        return "admin_wai_mai_manage";
    }
}
