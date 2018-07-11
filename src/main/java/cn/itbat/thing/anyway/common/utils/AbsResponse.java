package cn.itbat.thing.anyway.common.utils;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Map;

/**
 * @author log.r   (;￢＿￢)   
 * @date 2018-07-09 上午9:39
 **/
public class AbsResponse<T> implements Serializable {

    private static final long serialVersionUID = 5014379068811962022L;

    // 成功
    private static final Integer SUCCESS = 0;
    // 警告
    private static final Integer WARN = 1;
    // 异常 失败
    private static final Integer FAIL = 500;

    private int code;
    private String msg;
    @JsonIgnore
    private String body;
    private T data;
    @JsonIgnore
    private Map<String, String> params;


    public AbsResponse() {
        this(0, (String) null);
    }

    public AbsResponse(int code, String msg) {
        this(code, msg, (String) null);
    }

    public AbsResponse(int code, String msg, String body) {
        this(code, msg, body, (T) null);
    }

    public AbsResponse(int code, String msg, String body, T data) {
        this.code = code;
        this.msg = msg;
        this.body = body;
        this.data = data;
    }

    public AbsResponse<T> setResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
        return this;
    }

    public AbsResponse<T> setResult(int code, String msg, String body) {
        this.code = code;
        this.msg = msg;
        this.body = body;
        return this;
    }

    public AbsResponse<T> setResult(int code, String msg, String body, T data) {
        this.code = code;
        this.msg = msg;
        this.body = body;
        this.data = data;
        return this;
    }

    public AbsResponse<T> setResult(AbsResponse<?> ano) {
        return this.setResult(ano.getCode(), ano.getMsg(), ano.getBody());
    }

    public static AbsResponse error(String msg) {
        AbsResponse abs = new AbsResponse();
        abs.setCode(FAIL);
        abs.setMsg(msg);
        return abs;
    }

    public static AbsResponse warn(String msg) {
        AbsResponse abs = new AbsResponse();
        abs.setCode(WARN);
        abs.setMsg(msg);
        return abs;
    }

    public static AbsResponse ok(String msg) {
        AbsResponse abs = new AbsResponse();
        abs.setCode(SUCCESS);
        abs.setMsg(msg);
        return abs;
    }

    public static AbsResponse ok() {
        AbsResponse abs = new AbsResponse();
        abs.setCode(SUCCESS);
        abs.setMsg("操作成功！");
        return abs;
    }

    @JsonIgnore
    public boolean isSuccess() {
        return this.code == 0;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getBody() {
        return this.body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public T getData() {
        return this.data;
    }

    public AbsResponse<T> setData(T data) {
        this.data = data;
        return this;
    }

    public Map<String, String> getParams() {
        return this.params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "AbsResponse{code=" + this.code + ", msg='" + this.msg + '\'' + ", data=" + this.data + ", params=" + this.params + '}';
    }
}
