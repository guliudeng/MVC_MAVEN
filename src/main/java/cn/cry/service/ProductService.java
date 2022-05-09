package cn.cry.service;

import cn.cry.bo.base.Rsp;
import cn.cry.bo.base.RspList;
import cn.cry.bo.product.AddProductReqBO;
import cn.cry.bo.product.QryShopProductReqBO;
import cn.cry.bo.product.UpdateProductReqBO;

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

    /**
     * 查询商铺下已上架的商品
     * @param tenantId
     * @return
     */
    RspList qryShopUpProduct(String  tenantId);

    /**
     * 修改商品信息
     * @param reqBO
     * @return
     */
    Rsp updateProduct(UpdateProductReqBO reqBO);

    /**
     * 删除商品
     * @param productId
     * @return
     */
    Rsp deleteProduct(Integer productId);
}
