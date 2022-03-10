package cn.cry.controller;

import cn.cry.bo.user.LoginUserInfoBO;
import cn.cry.po.BsUser;
import cn.cry.service.UserService;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 登录注册controller
 */
@Controller
@SessionAttributes("userInfo")//该注解会将该类key为userInfo的对象放到session中，不会在存入模型对象中
public class LoginController {
    @Autowired
    private UserService userService;
    /**
     * 登录表单提交处理器
     */
    @RequestMapping("loginIn")
    public String login(LoginUserInfoBO userInfoBO, Model model, HttpServletRequest request){
        if (userInfoBO==null) {
            model.addAttribute("msg","");
            return "login-2";
        }
        System.out.println("登录入参--"+ JSONObject.toJSONString(userInfoBO));
        BsUser bsUser = userService.qryByNameAndPassword(userInfoBO.getUserName(), userInfoBO.getPassword());
        if (bsUser != null) {
            //登录成功，将用户信息存到session域中,只要key和session注解上设置的一致，就会将值写入session域中
            model.addAttribute("userInfo",userInfoBO);
            return "forward:/index.jsp";
        }else {
            //登录失败将提示信息写道模型数据里，给JSP页面获取渲染
            model.addAttribute("msg","登陆失败，用户名密码不正确");
        }
        return "login-2";
    }

}
