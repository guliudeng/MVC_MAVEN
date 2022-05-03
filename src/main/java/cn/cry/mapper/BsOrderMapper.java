package cn.cry.mapper;

import cn.cry.po.BsOrder;

import java.util.List;

public interface BsOrderMapper {
    int deleteByPrimaryKey(Integer orderId);

    int insert(BsOrder record);

    int insertSelective(BsOrder record);

    BsOrder selectByPrimaryKey(Integer orderId);

    int updateByPrimaryKeySelective(BsOrder record);

    int updateByPrimaryKey(BsOrder record);

    List<BsOrder> selectActive(BsOrder po);
}