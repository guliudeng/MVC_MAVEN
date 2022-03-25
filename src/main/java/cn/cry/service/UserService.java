package cn.cry.service;

import cn.cry.bo.base.Rsp;
import cn.cry.bo.base.RspList;
import cn.cry.bo.user.UpdateUserInfoReqBO;
import cn.cry.po.BsUser;



public interface UserService {
        public int addUser(BsUser user);
        public BsUser qryByUserName(String username);
        BsUser qryByNameAndPassword(String username,String password);

        /**
         * 查询用户列表
         * @return
         */
        RspList qryUserList(Integer page,Integer limit);

        /**
         * 删除用户
         * @param userId
         * @return
         */
        Rsp deleteUser(Integer userId);

        /**
         * 修改用户信息
         * @param user
         * @return
         */
        Rsp updateUser(UpdateUserInfoReqBO user);
}
