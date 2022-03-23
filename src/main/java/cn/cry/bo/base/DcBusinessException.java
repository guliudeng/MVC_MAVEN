package cn.cry.bo.base;

/**
 * 自定义运行时异常
 */
public class DcBusinessException extends RuntimeException {
    private String errorCode;

    public DcBusinessException(String message) {
        super(message);
        this.errorCode = "8888";
    }

    public DcBusinessException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return this.errorCode;
    }
}
