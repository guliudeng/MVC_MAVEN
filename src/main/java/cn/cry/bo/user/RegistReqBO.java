package cn.cry.bo.user;

import lombok.Data;

/**
 * 注册请求入参
 */
@Data
public class RegistReqBO {
    private String userName;
    private String password;
    private String sex;
    private String age;
    private String role;
}
