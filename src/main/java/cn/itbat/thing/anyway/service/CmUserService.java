package cn.itbat.thing.anyway.service;

import cn.itbat.thing.anyway.common.utils.AbsResponse;
import cn.itbat.thing.anyway.model.CmUser;
import org.springframework.transaction.annotation.Transactional;

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

    /**
     * 用户注册 （暂未验证邮箱）
     *
     * @param userName 用户名
     * @param password 密码
     * @param email    邮箱
     * @return
     */
    AbsResponse register(String userName, String password, String email);
}
