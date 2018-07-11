package cn.itbat.thing.anyway.common.base;

import cn.itbat.thing.anyway.model.CmUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

/**
 * @author log.r   (;￢＿￢)   
 * @date 2018-07-11 下午2:17
 **/
public class BaseController {

    public static Subject getSubject() {
        return SecurityUtils.getSubject();
    }

    protected CmUser getCurrentUser() {
        return (CmUser) getSubject().getPrincipal();
    }

    protected Session getSession() {
        return getSubject().getSession();
    }

    protected Session getSession(Boolean flag) {
        return getSubject().getSession(flag);
    }

    protected void login(AuthenticationToken token) {
        getSubject().login(token);
    }
}
