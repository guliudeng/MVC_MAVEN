package cn.cry.mapper;

import cn.cry.po.BsWaiMai;import java.util.List;

public interface BsWaiMaiMapper {
    int deleteByPrimaryKey(Integer waiMaiId);

    int insert(BsWaiMai record);

    int insertSelective(BsWaiMai record);

    BsWaiMai selectByPrimaryKey(Integer waiMaiId);

    int updateByPrimaryKeySelective(BsWaiMai record);

    int updateByPrimaryKey(BsWaiMai record);

    List<BsWaiMai> selectActive(BsWaiMai po);
}