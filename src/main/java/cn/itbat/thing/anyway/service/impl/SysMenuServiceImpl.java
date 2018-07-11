package cn.itbat.thing.anyway.service.impl;

import cn.itbat.thing.anyway.mapper.SysMenuMapper;
import cn.itbat.thing.anyway.model.SysMenu;
import cn.itbat.thing.anyway.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 权限
 *
 * @author log.r   (;￢＿￢)   
 * @date 2018-07-11 上午11:42
 **/
@Service
public class SysMenuServiceImpl implements SysMenuService {

    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Override
    public List<SysMenu> findUserPermissions(String userName) {
        return sysMenuMapper.findUserPermissions(userName);
    }
}
