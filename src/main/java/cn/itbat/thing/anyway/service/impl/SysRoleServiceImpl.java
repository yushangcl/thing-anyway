package cn.itbat.thing.anyway.service.impl;

import cn.itbat.thing.anyway.mapper.SysMenuMapper;
import cn.itbat.thing.anyway.mapper.SysRoleMapper;
import cn.itbat.thing.anyway.model.SysRole;
import cn.itbat.thing.anyway.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 角色
 *
 * @author log.r   (;￢＿￢)   
 * @date 2018-07-11 上午11:41
 **/
@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Override
    public List<SysRole> findUserRoles(String userName) {
        return sysRoleMapper.findUserRole(userName);
    }
}
