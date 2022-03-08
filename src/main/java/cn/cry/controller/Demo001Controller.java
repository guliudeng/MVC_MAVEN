package cn.cry.controller;

import cn.cry.bo.TestUserBO;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import sun.security.pkcs11.P11Util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class Demo001Controller {
    /**
     * 模型数据会以key-value形式存到model中，可在jsp页面中根据key直接获取
     * @return
     */
    @RequestMapping("test01")
    public ModelAndView test01(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("k1","v1");
        mv.addObject("k2","v2");
        mv.setViewName("demo-test01");
        return mv;
    }

    /**
     * 接收请求，响应参数
     * 直接从请求参数中获取
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping("test02")
    public String test02(HttpServletRequest request, HttpServletResponse response, Model model){
        String userName = request.getParameter("userName");
        String age = request.getParameter("age");
        String header = request.getHeader("Accept-Language");
        System.out.println(userName+"---"+age+"---"+header);
        model.addAttribute("req","接收请求,响应对象");
        return "demo-test01";
    }

    /**
     * 测试登录界面处理器
     * @return
     */
    @RequestMapping("demo-login")
    public String test03(){
        return "demo-test02";
    }

    /**
     * springMvc 自动封装bean，前提时参数名称和bean属性名称一致
     * @param userBO
     * @param model
     * @return
     */
    @RequestMapping("test03")
    public String test03(TestUserBO userBO, Model model){
        System.out.println(userBO);
        String jsonString = JSONObject.toJSONString(userBO);
        model.addAttribute("user",jsonString);
        return "demo-test01";
    }
}
