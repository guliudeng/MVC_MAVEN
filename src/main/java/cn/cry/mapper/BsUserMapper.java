package cn.cry.mapper;

import cn.cry.po.BsUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BsUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BsUser record);

    int insertSelective(BsUser record);

    BsUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BsUser record);

    int updateByPrimaryKey(BsUser record);

    BsUser selectByUserName(String username);

    BsUser qryNameAndPassword(@Param("username") String username, @Param("password") String password);
}