package com.yibazhang.consumer.controller;

import com.yibazhang.consumer.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 一巴掌
 * @Date 2019/1/26 22:44
 * @Description TODO
 * @Version 1.0
 **/
@RestController
public class HelloController {

    @Autowired
    HelloService service;

    @RequestMapping("/hello")
    public String sayHello(){
        return service.sayHello("老王");
    }
}
