package cn.cry.controller;

import cn.cry.bo.base.RspList;
import cn.cry.mapper.BsUserMapper;
import cn.cry.po.BsUser;
import cn.cry.service.UserService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用户前端控制器
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("qryUser")
    @ResponseBody
    public String qryUser(String userName){
        System.out.println("查询用户名是否可用入参；"+userName);
        BsUser bsUser = userService.qryByUserName(userName);
        if (null != bsUser) {
            return JSONObject.toJSONString(bsUser);
        }
        return null;
    }

    /**
     * 查询用户列表控制器
     * @return
     */
    @RequestMapping("qryUserList")
    @ResponseBody
    public String qryUserList() {
        RspList rspList = userService.qryUserList();
        System.out.println(rspList);
        return JSONObject.toJSONString(rspList);
    }
}
