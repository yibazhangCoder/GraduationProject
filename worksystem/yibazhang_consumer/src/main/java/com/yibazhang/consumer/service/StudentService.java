package com.yibazhang.consumer.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yibazhang.api.bean.Student;
import com.yibazhang.api.service.StudentApi;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author 一巴掌
 * @Date 2019/4/25 17:43
 * @Description TODO
 * @Version 1.0
 **/
@Service
public class StudentService {

    @Reference(version = "${yibazhang.service.version}",timeout = 5000)
    StudentApi studentApi;

    public List<Map<String,Object>> getStudents(Student student){
        return studentApi.getStudents(student);
    }
}
