package com.yibazhang.consumer.controller;

import com.alibaba.fastjson.JSONObject;
import com.yibazhang.consumer.common.BaseController;
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
public class HelloController extends BaseController {

    @Autowired
    HelloService service;

    @RequestMapping("/hello")
    public JSONObject sayHello(){
        return success(service.sayHello("老王"));
    }

    @RequestMapping("/test")
    public JSONObject select(){
        return success(service.select(1));
    }
}
