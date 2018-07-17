package cn.itbat.thing.anyway.mq;

import cn.itbat.thing.anyway.mq.conf.MailMqConfig;
import cn.itbat.thing.anyway.mq.conf.RabbitConfig;
import cn.itbat.thing.anyway.service.MailService;
import cn.itbat.thing.anyway.service.RuOperationLogService;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import com.rabbitmq.client.Channel;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * @author huahui.wu
 * @date 2018/7/16 16:51
 * @description
 */
@Component
@RabbitListener(queues = MailMqConfig.MAIL_REGISTER)
public class EmailReceiver {

    @Resource
    private MailService mailService;

    @Resource
    private RuOperationLogService operationLogService;


    @RabbitHandler
    public void process(Map<String, String> map) {
        if (map == null) {
            return;
        }
        Long userId = Long.valueOf(map.get("userId"));
        String address = map.get("address");
        String subject = map.get("subject");
        String content = map.get("content");

        Boolean status = mailService.sendEmail(address, subject, content);
        //记录日志，不尝试重发
        operationLogService.insertOperationLog(userId, "USER_ID", "注册邮件发送", userId, status ? "发送成功" : "发送失败");
    }
}
