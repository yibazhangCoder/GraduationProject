package com.yibazhang.api.service;

import com.yibazhang.api.bean.Student;

import java.util.List;
import java.util.Map;

/**
 * @Author 一巴掌
 * @Date 2019/3/17 17:27
 * @Description TODO
 * @Version 1.0
 **/
public interface StudentApi {

    List<Map<String,Object>>  getStudents(Student student);
}
