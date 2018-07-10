package cn.itbat.thing.anyway.service;

/**
 * @author huahui.wu. (;￢＿￢)
 * Created on 2018/4/19.
 */
public interface SyNextNumberService {
    String getAppSecret();

    String getNextNumber(String numberType);

    Long getNextSeq();
}
