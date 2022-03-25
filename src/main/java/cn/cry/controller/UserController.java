package cn.cry.controller;

import cn.cry.bo.base.Rsp;
import cn.cry.bo.base.RspList;
import cn.cry.bo.user.UpdateUserInfoReqBO;
import cn.cry.mapper.BsUserMapper;
import cn.cry.po.BsUser;
import cn.cry.service.UserService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    @RequestMapping(value = "qryUserList" ,produces = "text/html; charset=utf-8")
    @ResponseBody
    public String qryUserList(@RequestParam("page") int page,@RequestParam("limit") int limit) {
        RspList rspList = userService.qryUserList(page,limit);
        System.out.println("查询用户响应结果="+rspList);
        return JSONObject.toJSONString(rspList);
    }

    @RequestMapping(value = "deleteUser" ,produces = "text/html; charset=utf-8")
    @ResponseBody
    public String deleteUser(@RequestParam("userId") int userId) {
        Rsp rsp = userService.deleteUser(userId);
        System.out.println("删除用户响应结果="+rsp);
        return JSONObject.toJSONString(rsp);
    }

    @RequestMapping(value = "updateUser" ,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String updateUser(@RequestBody UpdateUserInfoReqBO user) {
        Rsp rsp = userService.updateUser(user);
        System.out.println("修改用户响应结果="+rsp);
        return JSONObject.toJSONString(rsp);
    }
}
