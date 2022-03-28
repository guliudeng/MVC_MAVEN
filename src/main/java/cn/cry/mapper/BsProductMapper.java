package cn.cry.mapper;

import cn.cry.po.BsProduct;

public interface BsProductMapper {
    int deleteByPrimaryKey(Integer productId);

    int insert(BsProduct record);

    int insertSelective(BsProduct record);

    BsProduct selectByPrimaryKey(Integer productId);

    int updateByPrimaryKeySelective(BsProduct record);

    int updateByPrimaryKey(BsProduct record);
}