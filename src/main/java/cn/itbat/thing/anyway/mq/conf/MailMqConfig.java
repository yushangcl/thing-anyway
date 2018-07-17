package cn.itbat.thing.anyway.mq.conf;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author log.r   (;￢＿￢)   
 * @date 2018-07-11 下午2:42
 **/
@Configuration
public class MailMqConfig {
    public static final  String MAIL_REGISTER = "email-register";

    @Bean
    public Queue Queue() {
        return new Queue(MAIL_REGISTER);
    }
}
