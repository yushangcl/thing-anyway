package cn.itbat.thing.anyway.constant;

/**
 * 异常编码
 *
 * @author huahui.wu
 * @date 2018/8/13 13:49
 * @description
 */
public enum  ErrorCodeConstants {
    VALIDATOR_ERROR_DEFAULT("404","Not Found"),

    FAIL("400","账号或密码错误"),

    EX_OTHER_CODE("500","系统异常"),

    PARAM_NULL("500","参数为空"),

            ;
    private String code;
    private String des;

    private ErrorCodeConstants(String code, String des) {
        this.code = code;
        this.des = des;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
