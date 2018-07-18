package cn.itbat.thing.anyway.service;

import cn.itbat.thing.anyway.common.utils.AbsResponse;
import cn.itbat.thing.anyway.enums.UserStatusEnum;
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

    /**
     * 更新用户状态
     *
     * @param userId 用户id
     * @param status 状态 UserStatusEnum
     */
    void updateUserStatus(Long userId, UserStatusEnum status);

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
