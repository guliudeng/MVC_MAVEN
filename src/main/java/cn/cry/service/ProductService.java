package cn.cry.service;

import cn.cry.bo.base.Rsp;
import cn.cry.bo.base.RspList;
import cn.cry.bo.product.AddProductReqBO;
import cn.cry.bo.product.QryShopProductReqBO;

public interface ProductService {
    /**
     * 查询商铺列表
     * @return
     */
    RspList qryShop();

    /**
     * 添加商品
     * @return
     */
    Rsp addProduct(AddProductReqBO reqBO);

    /**
     * 查询商铺的商品列表
     * @return
     */
    RspList qryShopProduct(QryShopProductReqBO reqBO);
}
