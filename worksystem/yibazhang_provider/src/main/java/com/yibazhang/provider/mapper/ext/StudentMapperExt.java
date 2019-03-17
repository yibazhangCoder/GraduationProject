package com.yibazhang.provider.mapper.ext;

import com.yibazhang.provider.entity.Student;

import java.util.List;
import java.util.Map;

/**
 * @Author 一巴掌
 * @Date 2019/2/22 16:39
 * @Description TODO
 * @Version 1.0
 **/
public interface StudentMapperExt {

    List<Map<String, Object>> selectStudents(Student student);
}
