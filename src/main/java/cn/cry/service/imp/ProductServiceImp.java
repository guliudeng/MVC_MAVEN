package cn.cry.service.imp;

import cn.cry.bo.base.Rsp;
import cn.cry.bo.base.RspList;
import cn.cry.bo.product.AddProductReqBO;
import cn.cry.bo.product.QryShopProductReqBO;
import cn.cry.bo.product.UpdateProductReqBO;
import cn.cry.mapper.BsProductMapper;
import cn.cry.mapper.BsUserMapper;
import cn.cry.po.BsProduct;
import cn.cry.po.BsUser;
import cn.cry.service.ProductService;
import cn.cry.utils.BaseRspUtils;
import cn.cry.utils.DateUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
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
       po.setProductPhoto(reqBO.getProductPhoto());
       po.setProductType(reqBO.getProductType());
       po.setProductPrice(new BigDecimal(reqBO.getProductPrice()));
       po.setProductName(reqBO.getProductName());
       po.setTenantId(reqBO.getTenantId());
       po.setCreateTime(DateUtils.timeForm());
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

    @Override
    public RspList qryShopUpProduct(String tenantId) {
        BsProduct product = new BsProduct();
        product.setTenantId(tenantId);
        List<BsProduct> productList = bsProductMapper.selectShopProduct(product);
        if (null != productList && productList.size() > 0) {
            return BaseRspUtils.createSuccessRspList(productList);
        }
        return BaseRspUtils.createErrorRspList("失败");
    }

    @Override
    public Rsp updateProduct(UpdateProductReqBO reqBO) {
        System.out.println("修改商品信息入参="+reqBO);
        BsProduct po = new BsProduct();
        po.setProductId(reqBO.getProductId());
        po.setProductName(reqBO.getProductName());
        po.setProductPrice(new BigDecimal(reqBO.getProductPrice()));
        po.setProductType(reqBO.getProductType());
        po.setProductPhoto(reqBO.getProductPhoto());
        int i = bsProductMapper.updateByPrimaryKeySelective(po);
        if (i > 0) {
            return BaseRspUtils.createSuccessRsp("修改商品成功");
        }
        return BaseRspUtils.createErrorRsp("修改商品失败");
    }

    @Override
    public Rsp deleteProduct(Integer productId) {
        System.out.println("删除商品入参="+productId);

       if (!StringUtils.isEmpty(productId)) {
           BsProduct product = new BsProduct();
           product.setProductId(productId);
           product.setDeleteFlag("1");
           int i = bsProductMapper.updateByPrimaryKeySelective(product);
           if (i > 0) {
               return BaseRspUtils.createSuccessRsp("删除商品成功");
           }
       }
        return BaseRspUtils.createErrorRsp("删除商品失败");
    }
}
