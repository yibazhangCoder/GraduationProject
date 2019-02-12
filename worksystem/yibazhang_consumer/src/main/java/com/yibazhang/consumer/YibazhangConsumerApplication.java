package com.yibazhang.consumer;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class YibazhangConsumerApplication {
    private final static Logger logger = LoggerFactory.getLogger(YibazhangConsumerApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(YibazhangConsumerApplication.class, args);
        logger.info("项目消费者启动。。。。。");
    }

}

