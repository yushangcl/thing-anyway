package cn.itbat.thing.anyway.service;

import cn.itbat.thing.anyway.model.CmSalt;

/**
 * @author log.r   (;￢＿￢)   
 * @date 2018-07-11 下午2:42
 **/
public interface CmSaltService {

    /**
     * 查询用户加密盐值
     *
     * @param saltUkid ukid
     * @return CmSalt
     */
    CmSalt findSalt(Long saltUkid);
}
