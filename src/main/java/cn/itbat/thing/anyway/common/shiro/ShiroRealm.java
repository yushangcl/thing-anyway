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
     * <p>
     * 只有需要验证权限时才会调用, 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.在配有缓存的情况下，只加载一次.
     * 如果需要动态权限,但是又不想每次去数据库校验,可以存在ehcache中.自行完善
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
     * 认证回调函数,登录时调用
     * <p>
     * 首先根据传入的用户名获取User信息；然后如果user为空，那么抛出没找到帐号异常UnknownAccountException；
     * 如果user找到但锁定了抛出锁定异常LockedAccountException；最后生成AuthenticationInfo信息，
     * 交给间接父类AuthenticatingRealm使用CredentialsMatcher进行判断密码是否匹配，
     * 如果不匹配将抛出密码错误异常IncorrectCredentialsException；
     * 另外如果密码重试此处太多将抛出超出重试次数异常ExcessiveAttemptsException；
     * 在组装SimpleAuthenticationInfo信息时， 需要传入：身份信息（用户名）、凭据（密文密码）、盐（username+salt），
     * CredentialsMatcher使用盐加密传入的明文密码和此处的密文密码进行匹配。
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
