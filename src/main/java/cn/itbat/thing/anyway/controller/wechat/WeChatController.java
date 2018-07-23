package cn.itbat.thing.anyway.controller.wechat;


import cn.itbat.thing.anyway.common.utils.StringUtils;
import cn.itbat.thing.anyway.common.utils.wechat.SignUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 微信登录
 *
 * @author log.r   (;￢＿￢)   
 * @date 2018/7/23 15:08
 **/
@Controller
public class WeChatController {
    private static final Logger log = LoggerFactory.getLogger(WeChatController.class);

    @RequestMapping(value = "/wechat", method = {RequestMethod.GET})
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        log.debug("【WeChat】: 验证服务器地址");
        // 微信加密签名
        String signature = request.getParameter("signature");
        // 时间戳
        String timestamp = request.getParameter("timestamp");
        // 随机数
        String nonce = request.getParameter("nonce");
        // 随机字符串
        String echostr = request.getParameter("echostr");

        //如果参数为null，直接返回
        if (StringUtils.isEmpty(signature) || StringUtils.isEmpty(timestamp) || StringUtils.isEmpty(nonce)
                || StringUtils.isEmpty(echostr)) {
            return;
        }

        // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
        PrintWriter out = null;
        try {
            out = response.getWriter();
            if (SignUtil.checkSignature(signature, timestamp, nonce)) {
                log.debug("【WeChat】: 服务器地址验证成功");
                out.print(echostr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null)
                out.close();
        }
    }
}
