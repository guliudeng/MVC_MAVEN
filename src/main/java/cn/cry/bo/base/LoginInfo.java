package cn.cry.bo.base;

public class LoginInfo {
    private String userId;
    private String loginName;
    private String userType;
    private String loginIp;

    public LoginInfo() {
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLoginName() {
        return this.loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getUserType() {
        return this.userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getLoginIp() {
        return this.loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public String toString() {
        return "LoginInfo{userId='" + this.userId + '\'' + ", loginName='" + this.loginName + '\'' + ", userType='" + this.userType + '\'' + ", loginIp='" + this.loginIp + '\'' + '}';
    }
}
