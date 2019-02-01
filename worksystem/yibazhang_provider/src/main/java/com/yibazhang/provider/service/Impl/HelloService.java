package com.yibazhang.provider.service.Impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.yibazhang.api.bean.Student;
import com.yibazhang.api.service.helloApi;
import com.yibazhang.provider.mapper.StudentMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author 一巴掌
 * @Date 2019/1/26 9:56
 * @Description TODO
 * @Version 1.0
 **/
@Service(version = "${yibazhang.service.version}")
public class HelloService implements helloApi {

    @Autowired
    StudentMapper studentMapper;

    @Override
    public String sayHello(String name) {
        return name+"-->"+",你好！";
    }

    @Override
    public Student selectById(int sid) {
        com.yibazhang.provider.entity.Student student = studentMapper.selectByPrimaryKey(sid);
        Student student1 = new Student();
        BeanUtils.copyProperties(student,student1);
        return student1;
    }
}
