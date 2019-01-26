package com.yibazhang.consumer.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yibazhang.api.service.helloApi;
import org.springframework.stereotype.Service;

/**
 * @Author 一巴掌
 * @Date 2019/1/26 22:41
 * @Description TODO
 * @Version 1.0
 **/
@Service
public class HelloService {

    @Reference(version = "${yibazhang.service.version}")
    helloApi helloApi;

    public String sayHello(String name){
        return helloApi.sayHello(name);
    }
}
