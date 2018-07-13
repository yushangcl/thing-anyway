package cn.itbat.thing.anyway.enums;

/**
 * Mail Code 状态
 * @author log.r   (;￢＿￢)   
 * @date 2018-07-13 下午3:44
 **/
public enum MailCodeEnum {
    /**
     * 有效
     */
    VALID(0, "VALID"),

    /**
     * 被使用
     */
    USED(1, "USED"),

    /**
     * 失效
     */
    INVALID(5, "INVALID"),

    ;

    public int code;

    public String message;

    MailCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
