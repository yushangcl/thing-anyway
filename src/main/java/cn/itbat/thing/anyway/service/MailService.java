package cn.itbat.thing.anyway.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author log.r   (;￢＿￢)   
 * @date 2018-07-13 下午1:44
 **/
public interface MailService {

    /**
     * 发送html格式邮件
     *
     * @param to      收件人地址
     * @param subject 主题
     * @param content 内容
     * @return 成功 true 失败：false
     */
    public Boolean sendEmail(String to, String subject, String content);

    /**
     * 发送带附件的邮件
     *
     * @param to       收件人地址
     * @param subject  主题
     * @param content  内容
     * @param filePath 附件
     * @return 成功 true 失败：false
     */
    public Boolean sendEmail(String to, String subject, String content, String filePath);

    /**
     * 用户发送注册激活邮件
     *
     * @param username    用户名
     * @param userId      用户id
     * @param mailAddress 邮箱地址
     */
    void sendEmail(String username, Long userId, String mailAddress);
}
