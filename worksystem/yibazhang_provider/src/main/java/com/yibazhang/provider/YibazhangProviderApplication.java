package com.yibazhang.provider;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.CountDownLatch;

@SpringBootApplication
@EnableDubbo
public class YibazhangProviderApplication {
    private static final Logger logger = LoggerFactory.getLogger(YibazhangProviderApplication.class);

    @Bean
    public CountDownLatch closeLatch() {
        return new CountDownLatch(1);
    }

    public static void main(String[] args) {

        ApplicationContext ctx = new SpringApplicationBuilder()
                .sources(YibazhangProviderApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        logger.info("项目服务者启动!");

        CountDownLatch closeLatch = ctx.getBean(CountDownLatch.class);
        try {
            closeLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

