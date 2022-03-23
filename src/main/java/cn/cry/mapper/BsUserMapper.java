package cn.cry.mapper;

import cn.cry.po.BsUser;import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BsUserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(BsUser record);

    int insertSelective(BsUser record);

    BsUser selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(BsUser record);

    int updateByPrimaryKey(BsUser record);

    BsUser selectByUserName(String username);

    BsUser qryNameAndPassword(@Param("username") String username, @Param("password") String password);

    List<BsUser> selectUserList();
}