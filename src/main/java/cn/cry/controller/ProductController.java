package cn.cry.controller;

import cn.cry.bo.base.Rsp;
import cn.cry.bo.base.RspList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *商品控制器
 */
@Controller
public class ProductController {
    /**
     * 查询商品
     * @return
     */
    @RequestMapping(value = "qryProduct")
    public RspList qryProduct(){
        return null;
    }

    /**
     * 添加商品
     * @return
     */
    @RequestMapping(value = "addProduct")
    public Rsp addProduct() {
        return null;
    }
}
