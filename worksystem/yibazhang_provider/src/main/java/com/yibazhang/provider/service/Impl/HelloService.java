package com.yibazhang.provider.service.Impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.yibazhang.api.bean.Student;
import com.yibazhang.api.service.helloApi;

/**
 * @Author 一巴掌
 * @Date 2019/1/26 9:56
 * @Description TODO
 * @Version 1.0
 **/
@Service(version = "${yibazhang.service.version}")
public class HelloService implements helloApi {



    @Override
    public String sayHello(String name) {
        return name+"-->"+",你好！";
    }

    @Override
    public Student selectById(int sid) {
       return null;
    }
}
