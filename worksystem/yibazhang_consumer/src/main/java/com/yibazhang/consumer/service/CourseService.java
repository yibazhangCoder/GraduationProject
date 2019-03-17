package com.yibazhang.consumer.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yibazhang.api.bean.CourseDTO;
import com.yibazhang.api.service.CourseApi;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author 一巴掌
 * @Date 2019/3/2 22:00
 * @Description TODO
 * @Version 1.0
 **/
@Service
public class CourseService {

    @Reference(version = "${yibazhang.service.version}",timeout = 5000)
    CourseApi courseApi;


    public Boolean insertCourseWithTeacher(Map<String,Object> map){
        return courseApi.insertCourseWithTeacher(map);
    }


    public Boolean insertCourseWithStudent(Map<String,Object> map){
        return courseApi.insertCourseWithStudent(map);
    }

    public List<Map<String,Object>> selectCourseWithTeacher(CourseDTO courseDTO){
        return courseApi.selectCourseWithTeacher(courseDTO);
    }
    public List<Map<String,Object>> selectCourseWithStudent(CourseDTO courseDTO){return courseApi.selectCourseWithStudent(courseDTO);}

    public Boolean updateCourseWithTeacher(Map<String,Object> map){return courseApi.updateCourseWithTeacher(map);}

    public Boolean updateCourseWithStudent(Map<String,Object> map){return courseApi.updateCourseWithStudent(map);}

    public List<Map<String,Object>> checkStudnetSelectCourse(Map<String,Object> map){
        return courseApi.checkStudentSelectCourse(map);
    }

    public List<Map<String,Object>> checkTeacherSelectCourse(Map<String,Object> map){
        return courseApi.checkTeacherSelectCourse(map);
    }
}
