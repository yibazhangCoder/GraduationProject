package com.yibazhang.provider.service.Impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.yibazhang.api.bean.Student;
import com.yibazhang.api.service.StudentApi;
import com.yibazhang.provider.domain.StudentDomain;
import com.yibazhang.provider.entity.ext.StudentExt;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @Author 一巴掌
 * @Date 2019/3/17 17:28
 * @Description TODO
 * @Version 1.0
 **/
@Service(version = "${yibazhang.service.version}")
public class StudentService implements StudentApi {


    @Autowired
    StudentDomain studentDomain;

    @Override
    public List<Map<String, Object>> getStudents(Student student) {
        StudentExt s = new StudentExt();
        if(student!=null){
            BeanUtils.copyProperties(student,s);
        }
        return studentDomain.getStudents(s);
    }
}
