package cn.cry.service.imp;

import cn.cry.bo.base.Rsp;
import cn.cry.bo.base.RspList;
import cn.cry.bo.user.UpdateUserInfoReqBO;
import cn.cry.mapper.BsUserMapper;
import cn.cry.po.BsUser;
import cn.cry.service.UserService;
import cn.cry.utils.BaseRspUtils;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

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
    public RspList qryUserList(Integer page,Integer limit) {
        List<BsUser> userList = userMapper.selectUserList();
        if (null != userList && userList.size()>0) {
            List<BsUser> pageList = userList.stream().skip(limit * (page - 1)).limit(limit).collect(Collectors.toList());
            return BaseRspUtils.createSuccessRspList(pageList,userList.size());
        }
        return BaseRspUtils.createErrorRspList("未查询到数据");
    }

    /**
     * 根据用户id删除用户--软删除
     * @param userId
     * @return
     */
    @Override
    public Rsp deleteUser(Integer userId) {
        System.out.println("删除用户入参Id="+userId);
        BsUser bsUser = new BsUser();
        bsUser.setUserId(userId);
        bsUser.setDeleteFlag("1");
        int i = userMapper.updateByPrimaryKeySelective(bsUser);
        if (i>0) {
            return BaseRspUtils.createSuccessRsp("删除用户成功");
        }
        return BaseRspUtils.createErrorRsp("删除失败");
    }

    @Override
    public Rsp updateUser(UpdateUserInfoReqBO user) {
        System.out.println("修改用户信息入参="+ JSONObject.toJSONString(user));
        BsUser po = new BsUser();
        BeanUtils.copyProperties(user,po);
        int i = userMapper.updateByPrimaryKeySelective(po);
        if (i>0) {
            return BaseRspUtils.createSuccessRsp("修改用户成功");
        }
        return BaseRspUtils.createErrorRsp("修改失败");
    }
}
