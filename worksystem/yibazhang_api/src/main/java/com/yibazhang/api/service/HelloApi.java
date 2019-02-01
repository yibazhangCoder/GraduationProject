package com.yibazhang.api.service;

import com.yibazhang.api.bean.Student;

/**
 * @Author 一巴掌
 * @Date 2019/1/26 9:53
 * @Description TODO
 * @Version 1.0
 **/
public interface helloApi {
    String sayHello(String name);

    Student selectById(int sid);
}
