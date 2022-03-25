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
}
