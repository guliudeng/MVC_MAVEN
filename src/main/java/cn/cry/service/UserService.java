package cn.cry.service;

import cn.cry.po.BsUser;



public interface UserService {
        public int addUser(BsUser user);
        public BsUser qryByUserName(String username);
        BsUser qryByNameAndPassword(String username,String password);
}
