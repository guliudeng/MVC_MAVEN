package cn.cry.controller;

import cn.cry.bo.base.RspList;
import cn.cry.bo.waiMai.QueryWaiMaiReqBO;
import cn.cry.constant.RoleConstant;
import cn.cry.po.BsUser;
import cn.cry.utils.AlipayUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * 买家账号：emowkt7766@sandbox.com
 */
@Controller
public class ZfbController {
    @Autowired
    private AlipayUtil alipayUtil;

   @PostMapping("zfDemo")
    public String qryWaiMai(String id, String price, String title, Model model){
       String pay = alipayUtil.pay(id, price, title);
       model.addAttribute("form",pay);
       //return "redirect:/payIndex";
       return "pay_index";
    }

    @GetMapping("return")
    public String returnNotice() {
       return "zfb_index";
    }
}
