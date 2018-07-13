package cn.itbat.thing.anyway.service.impl;

import cn.itbat.thing.anyway.BaseTest;
import cn.itbat.thing.anyway.service.MailService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;

/**
 * @author log.r   (;￢＿￢)   
 * @date 2018-07-13 下午2:13
 **/
public class MailServiceImplTest extends BaseTest {

    @Resource
    private MailService mailService;

    @Autowired
    private TemplateEngine templateEngine;

    @Test
    public void sendHtmlEmail() {

        //创建邮件正文
        Context context = new Context();
        context.setVariable("code", "1256566778878778787vggcft");
        context.setVariable("username", "LingDu");
        String emailContent = templateEngine.process("email/emailTemplate", context);

        System.out.println(emailContent);
        mailService.sendEmail("test@m.likie.win", "「Thing」请激活您的账号", emailContent);
    }

    @Test
    public void sendAttachmentsEmail() {
    }

    @Test
    public void sendInlineResourceEmail() {
    }
}