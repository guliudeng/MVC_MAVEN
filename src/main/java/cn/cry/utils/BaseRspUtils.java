package cn.cry.utils;

import cn.cry.bo.base.DcBusinessException;
import cn.cry.bo.base.Rsp;
import cn.cry.bo.base.RspList;

import java.util.List;

public class BaseRspUtils {
    public static final String SUCCESS_DESC = "业务处理成功!";

    private BaseRspUtils() {
    }

    public static Rsp createSuccessRsp(Object data) {
        Rsp<Object> dcRsp = new Rsp();
        dcRsp.setData(data);
        dcRsp.setRspCode("0000");
        dcRsp.setRspDesc("业务处理成功!");
        return dcRsp;
    }

    public static Rsp createSuccessRsp(Object data, String msg) {
        Rsp<Object> dcRsp = new Rsp();
        dcRsp.setData(data);
        dcRsp.setRspCode("0000");
        dcRsp.setRspDesc(msg);
        return dcRsp;
    }

    public static Rsp createErrorRsp(String errCode, String errMsg) {
        Rsp<Object> dcRsp = new Rsp();
        dcRsp.setRspCode(errCode);
        dcRsp.setRspDesc(errMsg);
        return dcRsp;
    }

    public static Rsp createErrorRsp(Object data, String errMsg) {
        Rsp<Object> dcRsp = new Rsp();
        dcRsp.setRspCode("8888");
        dcRsp.setRspDesc(errMsg);
        return dcRsp;
    }

    public static Rsp createErrorRsp(String errMsg) {
        Rsp<Object> dcRsp = new Rsp();
        dcRsp.setRspCode("8888");
        dcRsp.setRspDesc(errMsg);
        return dcRsp;
    }

    public static Rsp createErrorRsp(DcBusinessException e) {
        Rsp<Object> dcRsp = new Rsp();
        dcRsp.setRspCode(e.getErrorCode());
        dcRsp.setRspDesc(e.getMessage());
        return dcRsp;
    }

    public static RspList createSuccessRspList(List<?> data) {
        RspList rsp = new RspList();
        rsp.setRows(data);
        rsp.setCount((long)data.size());
        rsp.setRspCode("0000");
        rsp.setRspDesc("业务处理成功!");
        return rsp;
    }

    public static RspList createSuccessRspList(List<?> data, long count) {
        RspList rsp = new RspList();
        rsp.setRows(data);
        rsp.setCount(count);
        rsp.setRspCode("0000");
        rsp.setRspDesc("业务处理成功!");
        return rsp;
    }

    public static RspList createErrorRspList(String errCode, String errMsg) {
        RspList rsp = new RspList();
        rsp.setRspCode(errCode);
        rsp.setRspDesc(errMsg);
        return rsp;
    }

    public static RspList createErrorRspList(String errMsg) {
        RspList rsp = new RspList();
        rsp.setRspCode("8888");
        rsp.setRspDesc(errMsg);
        return rsp;
    }

    public static RspList createErrorRspList(DcBusinessException e) {
        RspList rsp = new RspList();
        rsp.setRspCode(e.getErrorCode());
        rsp.setRspDesc(e.getMessage());
        return rsp;
    }
}

