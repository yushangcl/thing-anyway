package cn.itbat.thing.anyway.controller;

import cn.itbat.thing.anyway.common.base.BaseController;
import cn.itbat.thing.anyway.common.utils.AbsResponse;
import cn.itbat.thing.anyway.common.utils.MD5Utils;
import cn.itbat.thing.anyway.common.utils.StringUtils;
import cn.itbat.thing.anyway.common.utils.vcode.Captcha;
import cn.itbat.thing.anyway.common.utils.vcode.GifCaptcha;
import cn.itbat.thing.anyway.model.CmSalt;
import cn.itbat.thing.anyway.model.CmUser;
import cn.itbat.thing.anyway.service.CmSaltService;
import cn.itbat.thing.anyway.service.CmUserService;
import cn.itbat.thing.anyway.service.RuOperationLogService;
import org.apache.shiro.authc.*;
import org.apache.shiro.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author log.r   (;￢＿￢)   
 * @date 2018-07-10 下午4:06
 **/
@Controller
public class LoginController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    @Resource
    private CmUserService cmUserService;

    @Resource
    private CmSaltService cmSaltService;

    @Resource
    private RuOperationLogService ruOperationLogService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    @ResponseBody
    public AbsResponse login(String username, String password, String code, Boolean rememberMe) {
//        String userName = String.valueOf(map.get("userName"));
//        String password = String.valueOf(map.get("password"));
//        String code = String.valueOf(map.get("code"));
//        Boolean rememberMe = Boolean.valueOf(String.valueOf(map.get("rememberMe")));
        //验证码校验
        if (StringUtils.isEmpty(code)) {
            return AbsResponse.warn("验证码不能为空！");
        }

        //参数校验
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)){
            return AbsResponse.warn("参数为空！");
        }

        Session session = super.getSession();
        String sessionCode = (String) session.getAttribute("_code");
        session.removeAttribute("_code");
        if (!code.toUpperCase().equals(sessionCode)) {
            return AbsResponse.warn("验证码不正确!");
        }

        CmUser cmUser = cmUserService.findByName(username);
        if (cmUser == null) {
            return AbsResponse.warn("账户不存在！");
        }

        //用户名密码校验
        CmSalt cmSalt = cmSaltService.findSalt(cmUser.getSaltUkid());
        password = MD5Utils.encrypt(username, password, cmSalt.getSaltValue());
        UsernamePasswordToken token = new UsernamePasswordToken(username, password, rememberMe);
        String remark = null;
        try {
            super.login(token);

            //判断用户状态，是否验证邮箱


            remark = "login_success";
            return AbsResponse.ok();
        } catch (UnknownAccountException | IncorrectCredentialsException | LockedAccountException e) {
            remark = "account error";
            return AbsResponse.error(e.getMessage());
        } catch (AuthenticationException e) {
            remark = "Authentication failure";
            return AbsResponse.error("认证失败！");
        } finally {
            //记录登录日志
            ruOperationLogService.insertLoginLog(cmUser.getUserId(), remark);
        }
    }

    @GetMapping(value = "/vCode")
    public void getVerificationCode(HttpServletResponse response, HttpServletRequest request) {
        try {
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            response.setContentType("image/gif");

            //生成验证码
            Long start = System.currentTimeMillis();
            Captcha captcha = new GifCaptcha(146, 33, 4);
            captcha.out(response.getOutputStream());
            HttpSession session = request.getSession(true);
            session.removeAttribute("_code");
            session.setAttribute("_code", captcha.text().toUpperCase());
            logger.debug("【_code】生成验证码：" + captcha.text().toUpperCase());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/")
    public String redirectIndex() {
        return "redirect:/index";
    }

    @GetMapping("/403")
    public String forbid() {
        return "403";
    }

    @RequestMapping("/index")
    public String index(Model model) {
        CmUser user = super.getCurrentUser();
        if (user == null) {
            return "login";
        }
        model.addAttribute("user", user);
        return "index";
    }


}
