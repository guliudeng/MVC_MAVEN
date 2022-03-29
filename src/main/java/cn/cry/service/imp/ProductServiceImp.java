package cn.cry.service.imp;

import cn.cry.bo.base.Rsp;
import cn.cry.bo.base.RspList;
import cn.cry.bo.product.AddProductReqBO;
import cn.cry.bo.product.QryShopProductReqBO;
import cn.cry.mapper.BsProductMapper;
import cn.cry.mapper.BsUserMapper;
import cn.cry.po.BsProduct;
import cn.cry.po.BsUser;
import cn.cry.service.ProductService;
import cn.cry.utils.BaseRspUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImp implements ProductService {
    @Autowired
    private BsProductMapper bsProductMapper;
    @Autowired
    private BsUserMapper bsUserMapper;

    @Override
    public RspList qryShop() {
        List<BsUser> shop = bsUserMapper.selectShop();
        if (null != shop && shop.size()>0) {
            return BaseRspUtils.createSuccessRspList(shop);
        }
        return BaseRspUtils.createErrorRspList("查询商家失败");
    }

    @Override
    public Rsp addProduct(AddProductReqBO reqBO) {
        System.out.println("添加商品service入参="+reqBO);
        BsProduct po = new BsProduct();
        BeanUtils.copyProperties(reqBO,po);
        int i = bsProductMapper.insertSelective(po);
        if (i>0) {
            return BaseRspUtils.createSuccessRsp("添加商品成功");
        }
        return BaseRspUtils.createErrorRsp("添加商品失败");
    }

    @Override
    public RspList qryShopProduct(QryShopProductReqBO reqBO) {
        System.out.println("查询商铺下商铺service入参="+reqBO);
        BsProduct po = new BsProduct();
        po.setTenantId(reqBO.getTenantId());
        List<BsProduct> productList = bsProductMapper.selectShopProduct(po);
        if (null != productList && productList.size()>0) {
            return BaseRspUtils.createSuccessRspList(productList);
        }
        return BaseRspUtils.createErrorRspList("查询商铺下商品失败 ");
    }
}
