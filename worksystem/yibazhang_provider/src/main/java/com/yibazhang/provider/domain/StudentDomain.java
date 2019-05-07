package com.yibazhang.provider.domain;

import com.yibazhang.provider.entity.Student;
import com.yibazhang.provider.entity.ext.StudentExt;
import com.yibazhang.provider.mapper.ext.StudentMapperExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @Author 一巴掌
 * @Date 2019/3/17 17:25
 * @Description TODO
 * @Version 1.0
 **/
@Service
@Transactional
public class StudentDomain {

    @Autowired
    StudentMapperExt studentMapperExt;


    public List<Map<String,Object>>  getStudents(StudentExt student){
        return studentMapperExt.selectStudents(student);
    }
}
