package cn.cry.service.imp;

import cn.cry.mapper.BsUserMapper;
import cn.cry.po.BsUser;
import cn.cry.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private BsUserMapper userMapper;
    @Override
    public int addUser(BsUser user) {
        int i = userMapper.insertSelective(user);
        return i;
    }

    @Override
    public BsUser qryByUserName(String username) {
        BsUser user = userMapper.selectByUserName(username);
        return user;
    }

    @Override
    public BsUser qryByNameAndPassword(String username, String password) {
        return userMapper.qryNameAndPassword(username,password);
    }
}
