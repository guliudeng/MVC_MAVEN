package cn.cry.controller;

import cn.cry.po.BsUser;
import cn.cry.service.UserService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

//@RequestMapping("/system/")
@Controller
public class UserController {
    @Autowired()
    private UserService userService;
    @RequestMapping("hello")
    public ModelAndView hello(ModelAndView model){
        model.setViewName("sys_hello");
        return model;
    }
    @RequestMapping("login")
    public ModelAndView login(HttpServletRequest request ,ModelAndView model){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("登录名="+username+",密码="+password);
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            model.setViewName("login");
        }
        BsUser bsUser = userService.qryByNameAndPassword(username, password);
        if (null !=bsUser) {
            System.out.println("登录成功");
            model.setViewName("sys_hello");
        }
        return model;
    }
    @RequestMapping("regist")
    public ModelAndView regist(HttpServletRequest request,ModelAndView model){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //没有入参一直在注册页
        if (StringUtils.isEmpty(username)) {
            model.setViewName("regist");
            return model;
        }
        System.out.println("username="+username+",password="+password);
        BsUser po = new BsUser();
        po.setPassword(password);
        po.setUserName(username);
        int addUser = userService.addUser(po);
        //注册成功跳转登录页
        if (addUser>0) {
            model.setViewName("login");
        }
        return model;
    }
    @RequestMapping("qryUser")
    @ResponseBody
    public String qureyUser(String userName) {
        System.out.println(userName);
        BsUser bsUser = userService.qryByUserName(userName);
        String us = JSONObject.toJSONString(bsUser);
        System.out.println(us);
        return us;
    }
}
