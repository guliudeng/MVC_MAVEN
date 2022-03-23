package cn.cry.service.imp;

import cn.cry.bo.base.RspList;
import cn.cry.mapper.BsUserMapper;
import cn.cry.po.BsUser;
import cn.cry.service.UserService;
import cn.cry.utils.BaseRspUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    @Override
    public RspList qryUserList() {
        List<BsUser> userList = userMapper.selectUserList();
        if (null != userList && userList.size()>0) {
            return BaseRspUtils.createSuccessRspList(userList);
        }
        return BaseRspUtils.createErrorRspList("未查询到数据");
    }
}
