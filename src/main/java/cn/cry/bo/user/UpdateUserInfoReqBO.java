package cn.cry.bo.user;

import lombok.Data;

@Data
public class UpdateUserInfoReqBO {
    private Integer userId;
    private String sex;
    private String userName;
    private String password;
}
