package cn.itbat.thing.anyway.common.base;

import cn.itbat.thing.anyway.constant.ErrorCodeConstants;

/**
 * @author huahui.wu
 * @date 2018/8/13 13:48
 */
public class BaseResponse {
    private int status = 200;
    private String message;

    public BaseResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public BaseResponse(ErrorCodeConstants constants) {
        status = Integer.parseInt(constants.getCode()) ;
        message = constants.getDes();
    }

    public BaseResponse() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
