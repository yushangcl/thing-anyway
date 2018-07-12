package cn.itbat.thing.anyway.controller;

import cn.itbat.thing.anyway.common.utils.AbsResponse;
import cn.itbat.thing.anyway.common.utils.StringUtils;
import cn.itbat.thing.anyway.service.CmUserService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 用户注册
 *
 * @author log.r   (;￢＿￢)   
 * @date 2018-07-10 下午4:04
 **/
@RestController
@RequestMapping("/register")
public class RegisterController {

    @Resource
    private CmUserService cmUserService;

    @RequestMapping("/web")
    public AbsResponse register(@RequestBody Map<String, Object> map) {
        String userName = String.valueOf(map.get("userName"));
        String password = String.valueOf(map.get("password"));
        String email = String.valueOf(map.get("email"));

        if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(password) || StringUtils.isEmpty(email)) {
            return AbsResponse.warn("参数为空！");
        }
        try {
            return this.cmUserService.register(userName, password, email);
        } catch (Exception e) {
            e.printStackTrace();
            return AbsResponse.error("注册失败，请联系网站管理员！");
        }
    }

}
