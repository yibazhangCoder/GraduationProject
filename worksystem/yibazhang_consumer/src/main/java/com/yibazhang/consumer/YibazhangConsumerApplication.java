package com.yibazhang.consumer;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class YibazhangConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(YibazhangConsumerApplication.class, args);
    }

}

