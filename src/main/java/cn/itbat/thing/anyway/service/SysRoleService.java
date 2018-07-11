package cn.itbat.thing.anyway.service;

import cn.itbat.thing.anyway.model.SysRole;

import java.util.List;

/**
 * @author log.r   (;￢＿￢)   
 * @date 2018-07-11 上午11:41
 **/
public interface SysRoleService {

    /**
     * 查询用户角色
     *
     * @param userName 用户名
     * @return List<SysRole>
     */
    List<SysRole> findUserRoles(String  userName);
}
