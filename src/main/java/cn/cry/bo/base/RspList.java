package cn.cry.bo.base;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class RspList<T> implements Serializable {
    private String rspCode;
    private String rspDesc;
    private long count;
    private List<T> rows = Collections.emptyList();

    public RspList() {
    }

    public RspList(String rspCode, String rspDesc) {
        this.rspCode = rspCode;
        this.rspDesc = rspDesc;
    }

    public boolean isSuccess() {
        return "0000".equals(this.rspCode);
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

    public long getCount() {
        return this.count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public List<T> getRows() {
        return this.rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public String toString() {
        return "DcRspList{rspCode='" + this.rspCode + '\'' + ", rspDesc='" + this.rspDesc + '\'' + ", count=" + this.count + ", rows=" + this.rows + '}';
    }
}
