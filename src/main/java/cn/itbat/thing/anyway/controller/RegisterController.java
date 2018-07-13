package cn.itbat.thing.anyway.controller;

import cn.itbat.thing.anyway.common.utils.AbsResponse;
import cn.itbat.thing.anyway.common.utils.DateUtil;
import cn.itbat.thing.anyway.common.utils.StringUtils;
import cn.itbat.thing.anyway.service.CmUserService;
import cn.itbat.thing.anyway.service.RedisService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
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

    @Resource
    RedisService redisService;

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

    @GetMapping(value = "/activate")
    public AbsResponse activate(String code) {
        //處理key
        Long userId = Long.valueOf(code.substring(14, 20));
        String vCode = redisService.get(userId.toString());
        if (vCode.equals(code)) {
            //删除key
            redisService.del(userId.toString());
            return AbsResponse.ok("邮箱验证成功");
        }
        return AbsResponse.warn("激活链接");
    }

}
