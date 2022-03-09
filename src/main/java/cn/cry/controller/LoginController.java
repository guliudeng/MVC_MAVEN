package cn.cry.controller;

import cn.cry.bo.user.LoginUserInfoBO;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 * 登录注册controller
 */
@Controller
@SessionAttributes("userInfo")
public class LoginController {
    /**
     * 登录表单提交处理器
     */
    @RequestMapping("loginIn")
    public String login(LoginUserInfoBO userInfoBO, Model model){
        System.out.println("登录入参--"+ JSONObject.toJSONString(userInfoBO));
        //登录成功，将用户信息存到session域中,只要key和session注解上设置的一致，就会将值写入session域中
        model.addAttribute("userInfo",userInfoBO);
        return "forward:/index.jsp";
    }
}
