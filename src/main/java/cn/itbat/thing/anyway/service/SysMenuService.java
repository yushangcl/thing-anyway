package cn.itbat.thing.anyway.service;

import cn.itbat.thing.anyway.model.SysMenu;

import java.util.List;

/**
 * @author log.r   (;￢＿￢)   
 * @date 2018-07-11 上午11:41
 **/
public interface SysMenuService {

    /**
     * 查询用户的权限
     *
     * @param userName 用户名
     * @return List<SysMenu>
     */
    List<SysMenu> findUserPermissions(String userName);
}
