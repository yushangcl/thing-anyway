package cn.itbat.thing.anyway.common.shiro;

import cn.itbat.thing.anyway.model.CmUser;
import cn.itbat.thing.anyway.model.SysMenu;
import cn.itbat.thing.anyway.model.SysRole;
import cn.itbat.thing.anyway.service.CmUserService;
import cn.itbat.thing.anyway.service.SysMenuService;
import cn.itbat.thing.anyway.service.SysRoleService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 登录认证实现
 *
 * @author log.r   (;￢＿￢)   
 * @date 2018-07-11 上午10:46
 **/
public class ShiroRealm extends AuthorizingRealm {

    @Resource
    private SysMenuService sysMenuService;

    @Resource
    private SysRoleService sysRoleService;

    @Resource
    private CmUserService cmUserService;

    /**
     * 链接权限的实现
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        CmUser user = (CmUser) SecurityUtils.getSubject().getPrincipal();
        String userName = user.getUserName();

        //SimpleAuthorizationInfo进行角色的添加和权限的添加
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        List<SysRole> sysRoles = sysRoleService.findUserRoles(userName);
        Set<String> roleSet = new HashSet<>();
        if (CollectionUtils.isNotEmpty(sysRoles)) {
            sysRoles.forEach(role -> {
                roleSet.add(role.getRoleName());
            });
        }
        simpleAuthorizationInfo.setRoles(roleSet);

        List<SysMenu> sysMenus = sysMenuService.findUserPermissions(userName);
        Set<String> permissionSet = new HashSet<>();
        if (CollectionUtils.isNotEmpty(sysMenus)) {
            sysMenus.forEach(menu -> {
                permissionSet.add(menu.getPerms());
            });
        }
        simpleAuthorizationInfo.setStringPermissions(permissionSet);

        return simpleAuthorizationInfo;
    }

    /**
     * 主要用来进行身份验证，验证用户输入的账号和密码是否正确
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String userName = (String) authenticationToken.getPrincipal();
        String password = new String((char[]) authenticationToken.getCredentials());

        CmUser user = cmUserService.findByName(userName);
        if (user == null) {
            throw new UnknownAccountException("用户名或密码错误！");
        }

        if (!password.equals(user.getUserPassword())) {
            throw new IncorrectCredentialsException("用户名或密码错误！");
        }

        //状态判断 todo

        return new SimpleAuthenticationInfo(user, password, getName());
    }
}
