package cn.itbat.thing.anyway;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 *
 * @author log.r   (;￢＿￢)   
 * @date 2018-07-04 下午1:58
 **/
@MapperScan("cn.itbat.thing.anyway.mapper")
@SpringBootApplication
public class ThingAnywayApplication {

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(ThingAnywayApplication.class);

        logger.info(">>>>> spring-boot 正在启动 <<<<<");
        SpringApplication.run(ThingAnywayApplication.class, args);
        logger.info(">>>>> spring-boot 启动完成 <<<<<");
    }
}
