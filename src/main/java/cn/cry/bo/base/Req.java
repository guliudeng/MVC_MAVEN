package cn.cry.bo.base;

import java.io.Serializable;
import java.util.Set;

public class Req<T> implements Serializable {

    private LoginInfo loginInfo;
    private String tenantCode;
    private int limit = 10;
    private int page = 1;
    private T reqData;
    private String in_tenantCode;
    private Set<String> roleSet;


    public LoginInfo getLoginInfo() {
        return loginInfo;
    }

    public void setLoginInfo(LoginInfo loginInfo) {
        this.loginInfo = loginInfo;
    }

    public String getTenantCode() {
        return tenantCode;
    }

    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public T getReqData() {
        return reqData;
    }

    public void setReqData(T reqData) {
        this.reqData = reqData;
    }

    public String getIn_tenantCode() {
        return in_tenantCode;
    }

    public void setIn_tenantCode(String in_tenantCode) {
        this.in_tenantCode = in_tenantCode;
    }

    public Set<String> getRoleSet() {
        return roleSet;
    }

    public void setRoleSet(Set<String> roleSet) {
        this.roleSet = roleSet;
    }
}

