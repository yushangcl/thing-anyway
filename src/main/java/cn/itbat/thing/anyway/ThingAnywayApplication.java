package cn.itbat.thing.anyway;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 启动类
 *
 * @author log.r   (;￢＿￢)   
 * @date 2018-07-04 下午1:58
 **/
@SpringBootApplication
@EnableTransactionManagement
@EnableCaching
@MapperScan("cn.itbat.thing.anyway.mapper")
public class ThingAnywayApplication {

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(ThingAnywayApplication.class);

        logger.info(">>>>> spring-boot 正在启动 <<<<<");
        SpringApplication.run(ThingAnywayApplication.class, args);
        logger.info(">>>>> spring-boot 启动完成 <<<<<");
    }
}
