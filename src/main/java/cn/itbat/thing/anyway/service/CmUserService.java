package cn.itbat.thing.anyway.service;

import cn.itbat.thing.anyway.model.CmUser;

/**
 * @author log.r   (;￢＿￢)   
 * @date 2018-07-10 下午3:45
 **/
public interface CmUserService {

    /**
     * 根据用户名查询User
     *
     * @param userName 用户名
     * @return CmUser
     */
    CmUser findByName(String userName);
}
