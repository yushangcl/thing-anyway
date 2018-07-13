package cn.itbat.thing.anyway.service.impl;

import cn.itbat.thing.anyway.common.utils.DateUtil;
import cn.itbat.thing.anyway.common.utils.RandomUtil;
import cn.itbat.thing.anyway.common.utils.StringUtils;
import cn.itbat.thing.anyway.service.CmMailCodeService;
import cn.itbat.thing.anyway.service.MailService;
import cn.itbat.thing.anyway.service.RedisService;
import cn.itbat.thing.anyway.service.RuOperationLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Date;

/**
 * @author log.r   (;￢＿￢)   
 * @date 2018-07-13 下午1:44
 **/
@Service
public class MailServiceImpl implements MailService {

    private static final Logger logger = LoggerFactory.getLogger(MailServiceImpl.class);

    @Resource
    private JavaMailSender mailSender;

    @Resource
    private CmMailCodeService cmMailCodeService;

    @Resource
    private TemplateEngine templateEngine;

    @Resource
    private RedisService redisService;

    @Resource
    private RuOperationLogService operationLogService;

    @Value("${mail.fromMail.addr}")
    private String from;

    @Override
    public Boolean sendEmail(String to, String subject, String content) {
        return sendEmail(to, subject, content, null);
    }

    @Override
    public Boolean sendEmail(String to, String subject, String content, String filePath) {
        //创建一个MINE消息
        MimeMessage message = mailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            // true表示这个邮件是有附件的
            helper.setText(content, true);

            //创建文件系统资源
            if (StringUtils.isNotEmpty(filePath)) {
                FileSystemResource file = new FileSystemResource(new File(filePath));
                String fileName = filePath.substring(filePath.lastIndexOf(File.separator));
                //添加附件
                helper.addAttachment(fileName, file);
            }
            mailSender.send(message);
            logger.info("带附件的邮件已经发送。");
            return true;
        } catch (MessagingException e) {
            logger.error("发送带附件的邮件时发生异常！", e);
            return false;
        }

    }


    /**
     * 发送邮件
     *
     * @param username    用户名
     * @param mailAddress 收件人地址
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED, rollbackFor = Exception.class)
    @Override
    public void sendEmail(String username, Long userId, String mailAddress) {
        //创建邮件正文
        Context context = new Context();
        //生成邮件激活唯一识别码
        String code = DateUtil.format(new Date(), DateUtil.DATE_FORMAT_TIME) + RandomUtil.generateStr(24);

        //记录下code
        cmMailCodeService.insertMailCode(code, userId);
        //缓存到redis 失效3小时
        redisService.set(userId.toString(), code);
        redisService.pexpire(userId.toString(), 180 * 60 * 1000L);

        context.setVariable("code", code);
        context.setVariable("username", username);
        String emailContent = templateEngine.process("email/emailTemplate", context);

        System.out.println(emailContent);
        Boolean status = this.sendEmail(mailAddress, "「Thing」请激活您的账号", emailContent);
        //记录日志，不尝试重发
        operationLogService.insertOperationLog(userId, "USER_ID", "注册邮件发送", userId, status ? "发送成功" : "发送失败");
    }
}
