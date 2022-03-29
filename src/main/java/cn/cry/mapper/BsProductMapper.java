package cn.cry.mapper;

import cn.cry.po.BsProduct;

import java.util.List;

public interface BsProductMapper {
    int deleteByPrimaryKey(Integer productId);

    int insert(BsProduct record);

    int insertSelective(BsProduct record);

    BsProduct selectByPrimaryKey(Integer productId);

    int updateByPrimaryKeySelective(BsProduct record);

    int updateByPrimaryKey(BsProduct record);

    List<BsProduct> selectShopProduct(BsProduct po);
}