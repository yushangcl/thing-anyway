package cn.itbat.thing.anyway.mq.conf;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author huahui.wu
 * @date 2018/7/16 16:57
 * @description
 */
@Configuration
public class MailConfig {

    @Bean
    public Queue Queue() {
        return new Queue("email-register");
    }
}
