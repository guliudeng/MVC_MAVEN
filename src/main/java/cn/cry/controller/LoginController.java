package cn.cry.controller;

import cn.cry.bo.user.LoginUserInfoBO;
import cn.cry.bo.user.RegistReqBO;
import cn.cry.constant.RoleConstant;
import cn.cry.po.BsUser;
import cn.cry.service.UserService;
import cn.cry.utils.DateUtils;
import cn.cry.utils.TenantCodeUtils;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录注册controller
 */
@Controller
@SessionAttributes("userInfo")//该注解会将该类key为userInfo的对象放到session中，不会在存入模型对象中
public class LoginController {
    @Autowired
    private UserService userService;

    /**
     *访问登录页面
     * @return
     */
    @RequestMapping("login")
    public String login(){
       return "login" ;
    }

    /**
     * 访问注册页面
     * @return
     */
    @RequestMapping("regist")
    public String regist(){
        return "regist" ;
    }

    /**
     * 注册操作处理
     * @param user
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("registIn")
    public ModelAndView regist(RegistReqBO user, HttpServletRequest request,
                               HttpServletResponse response, ModelAndView modelAndView) throws IOException {
        System.out.println("用户注册入参="+JSONObject.toJSONString(user));
        if (StringUtils.isEmpty(user.getPassword())||StringUtils.isEmpty(user.getUserName())) {
            modelAndView.addObject("msg","用户名密码不能为空");
            modelAndView.setViewName("regist");
            return modelAndView;
        }
        BsUser bsUser = userService.qryByUserName(user.getUserName());
        if (bsUser != null) {
            modelAndView.addObject("msg","用户名已存在");
            modelAndView.setViewName("regist");
            return modelAndView;
        }
        BsUser po = new BsUser();
        po.setUserName(user.getUserName());
        po.setPassword(user.getPassword());
        po.setRole(user.getRole());
        po.setSex(user.getSex());
        po.setCreateTime(DateUtils.timeForm());
        if (RoleConstant.ADMIN_ROLE.equals(user.getRole())) {
            String tenantCode = TenantCodeUtils.getHanziInitials(user.getUserName());
            po.setShopCode(tenantCode == null?user.getUserName() : tenantCode);
        }
        int i = userService.addUser(po);
        if (i>0) {
            //response.getWriter().write("注册成功，3秒后返登录页面！");
           //response.setHeader("refresh","3;url="+request.getContextPath()+"/login");
            modelAndView.setViewName("login");
        }
       return modelAndView;
    }
    /**
     * 登录表单提交处理器
     */
    @RequestMapping("loginIn")
    public String login(LoginUserInfoBO userInfoBO, Model model, HttpServletRequest request){
        if (userInfoBO==null) {
            model.addAttribute("msg","");
            return "login";
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
        return "login";
    }


}
