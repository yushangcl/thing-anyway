package cn.itbat.thing.anyway.common.base;

import java.util.HashMap;

/**
 * @author log.r   (;￢＿￢)   
 * @date 2018-07-09 上午9:39
 **/
public class AbsResponse extends HashMap<String, Object> {

    private static final long serialVersionUID = -8713837118340960775L;

    // 成功
    private static final Integer SUCCESS = 0;
    // 警告
    private static final Integer WARN = 1;
    // 异常 失败
    private static final Integer FAIL = 500;

    public AbsResponse() {
        put("code", SUCCESS);
        put("msg", "操作成功");
    }

    public static AbsResponse error(Object msg) {
        AbsResponse AbsResponse = new AbsResponse();
        AbsResponse.put("code", FAIL);
        AbsResponse.put("msg", msg);
        return AbsResponse;
    }

    public static AbsResponse warn(Object msg) {
        AbsResponse AbsResponse = new AbsResponse();
        AbsResponse.put("code", WARN);
        AbsResponse.put("msg", msg);
        return AbsResponse;
    }

    public static AbsResponse ok(Object msg) {
        AbsResponse AbsResponse = new AbsResponse();
        AbsResponse.put("code", SUCCESS);
        AbsResponse.put("msg", msg);
        return AbsResponse;
    }

    public static AbsResponse ok() {
        return new AbsResponse();
    }

    public static AbsResponse error() {
        return AbsResponse.error("");
    }

    @Override
    public AbsResponse put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
