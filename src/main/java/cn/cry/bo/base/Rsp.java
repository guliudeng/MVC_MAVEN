package cn.cry.bo.base;

import java.io.Serializable;

public class Rsp<T> implements Serializable {
    private String rspCode;
    private String rspDesc;
    private T data = null;

    public boolean isSuccess() {
        return "0000".equals(this.rspCode);
    }

    public Rsp() {
    }

    public Rsp(String rspCode, String rspDesc) {
        this.rspCode = "0000";
        this.rspDesc = rspDesc;
    }

    public String getRspCode() {
        return this.rspCode;
    }

    public void setRspCode(String rspCode) {
        this.rspCode = rspCode;
    }

    public String getRspDesc() {
        return this.rspDesc;
    }

    public void setRspDesc(String rspDesc) {
        this.rspDesc = rspDesc;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String toString() {
        return "Rsp{rspCode='" + this.rspCode + '\'' + ", rspDesc='" + this.rspDesc + '\'' + ", data=" + this.data + '}';
    }
}

