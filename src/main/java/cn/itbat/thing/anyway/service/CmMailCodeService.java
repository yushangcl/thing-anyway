package cn.itbat.thing.anyway.service;

/**
 * @author log.r   (;￢＿￢)   
 * @date 2018-07-13 下午3:39
 **/
public interface CmMailCodeService {

    /**
     * 插入新的code
     *
     * @param code
     * @param userId
     * @return
     */
    Long insertMailCode(String code, Long userId);
}
