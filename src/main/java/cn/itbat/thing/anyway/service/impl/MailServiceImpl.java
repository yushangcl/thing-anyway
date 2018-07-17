package cn.itbat.thing.anyway.service.impl;

import cn.itbat.thing.anyway.common.utils.DateUtil;
import cn.itbat.thing.anyway.common.utils.RandomUtil;
import cn.itbat.thing.anyway.common.utils.StringUtils;
import cn.itbat.thing.anyway.mq.conf.MailMqConfig;
import cn.itbat.thing.anyway.mq.conf.RabbitConfig;
import cn.itbat.thing.anyway.service.CmMailCodeService;
import cn.itbat.thing.anyway.service.MailService;
import cn.itbat.thing.anyway.service.RedisService;
import cn.itbat.thing.anyway.service.RuOperationLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.AbstractJavaTypeMapper;
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
import java.awt.print.Book;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author log.r   (;￢＿￢)   
 * @date 2018-07-13 下午1:44
 **/
@Service
@Transactional
public class MailServiceImpl implements MailService {

    private static final Logger logger = LoggerFactory.getLogger(MailServiceImpl.class);

    @Resource
    private JavaMailSender mailSender;

    @Resource
    private CmMailCodeService cmMailCodeService;

    @Resource
    private TemplateEngine templateEngine;

    @Resource
    private RabbitTemplate rabbitTemplate;

    @Resource
    private RedisService redisService;

//    @Resource
//    private RedisTemplate<String, String> redisTemplate;

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
            logger.info("邮件发送成功。");
            return true;
        } catch (MessagingException e) {
            logger.error("邮件发送失败！", e);
            return false;
        }

    }


    /**
     * 发送邮件
     *
     * @param username    用户名
     * @param mailAddress 收件人地址
     */
    @Override
    public void sendEmail(String username, Long userId, String mailAddress) {
        //创建邮件正文
        Context context = new Context();
        //生成邮件激活唯一识别码
        String code = DateUtil.format(new Date(), DateUtil.DATE_FORMAT_TIME) + userId + RandomUtil.generateStr(24);

        //记录下code
        cmMailCodeService.insertMailCode(code, userId);
        //缓存到redis 失效3小时
        redisService.set(userId.toString(), code);
        redisService.pexpire(userId.toString(), 180 * 60 * 1000L);
//        redisTemplate.opsForHash().put("MAIL_CODE", userId.toString(), code);

        context.setVariable("code", code);
        context.setVariable("username", username);
        String emailContent = templateEngine.process("email/emailTemplate", context);

//        Boolean status = this.sendEmail(mailAddress, "「Thing」请激活您的账号", emailContent);
        Map<String, String> map = new HashMap<>(3);
        map.put("userId", userId.toString());
        map.put("address", mailAddress);
        map.put("subject", "「Thing」请激活您的账号");
        map.put("content", emailContent);

        //发送mq消息
        rabbitTemplate.convertAndSend(MailMqConfig.MAIL_REGISTER, map);
    }
}
