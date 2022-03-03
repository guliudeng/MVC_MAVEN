package cn.cry.po;

import lombok.Data;

@Data
public class BsUser {
    /**
    * 主键
    */
    private Integer id;

    /**
    * 姓名
    */
    private String userName;

    /**
    * 密码
    */
    private String password;
}