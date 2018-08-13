package cn.itbat.thing.anyway.common.exception;

import cn.itbat.thing.anyway.constant.ErrorCodeConstants;

/**
 * 基础异常信息
 *
 * @author huahui.wu
 * @date 2018/8/13 13:47
 */
public class BaseException extends RuntimeException {
    private int status = 500;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public BaseException() {
    }

    public BaseException(String message, int status) {
        super(message);
        this.status = status;
    }

    public BaseException(String message, String status) {
        super(message);
        this.status = Integer.parseInt(status);
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseException(Throwable cause) {
        super(cause);
    }

    public BaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public BaseException(ErrorCodeConstants constants) {
        super(constants.getDes());
        status = Integer.parseInt(constants.getCode());
    }
}
