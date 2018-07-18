package cn.itbat.thing.anyway.controller;

import cn.itbat.thing.anyway.common.utils.AbsResponse;
import cn.itbat.thing.anyway.common.utils.StringUtils;
import cn.itbat.thing.anyway.enums.UserStatusEnum;
import cn.itbat.thing.anyway.service.CmMailCodeService;
import cn.itbat.thing.anyway.service.CmUserService;
import cn.itbat.thing.anyway.service.RedisService;
import org.springframework.web.bind.annotation.GetMapping;
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

    @Resource
    private CmMailCodeService cmMailCodeService;

    @Resource
    private RedisService redisService;

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
        // 處理key
        Long userId = Long.valueOf(code.substring(14, 20));
        String userId2 = redisService.get(code);
        if (StringUtils.isNotEmpty(userId2) && userId2.equals(userId.toString())) {
            // 删除key
            redisService.del(code);

            // 将数据库中的code状态改成已使用
            cmMailCodeService.updateCodeStatus(code, userId);

            // 更改用户注册状态
            cmUserService.updateUserStatus(userId, UserStatusEnum.VALID);
            return AbsResponse.ok("邮箱验证成功");
        }
        return AbsResponse.warn("激活链接已失效，请重新发送激活邮件！");
    }

}
