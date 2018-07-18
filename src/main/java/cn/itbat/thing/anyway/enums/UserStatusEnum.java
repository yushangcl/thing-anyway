package cn.itbat.thing.anyway.enums;

/**
 * 用户状态枚举类
 *
 * @author log.r   (;￢＿￢)   
 * @date 2018-07-18 下午2:43
 **/
public enum UserStatusEnum {

    /**
     * 注册未验证邮箱
     */
    NOT_EFFECTIVE(0, "NOT_EFFECTIVE"),

    /**
     * 有效
     */
    VALID(10, "VALID"),

    /**
     * 停用
     */
    DISABLE(20, "DISABLE"),

    /**
     * 失效
     */
    INVALID(50, "INVALID"),;

    private int code;

    private String message;

    UserStatusEnum(int code, String message) {
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

    public static boolean compare(int code1, int code2) {
        return code1 <= code2;
    }

}
