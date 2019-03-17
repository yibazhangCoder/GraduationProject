package com.yibazhang.api.service;

import com.yibazhang.api.bean.CourseDTO;

import java.util.List;
import java.util.Map;

/**
 * @Author 一巴掌
 * @Date 2019/3/2 21:48
 * @Description TODO
 * @Version 1.0
 **/
public interface CourseApi {

    Boolean insertCourseWithStudent(Map<String,Object> map);

    Boolean insertCourseWithTeacher(Map<String,Object> map);

    List<Map<String,Object>> selectCourseWithTeacher(CourseDTO courseDTO);

    List<Map<String,Object>> selectCourseWithStudent(CourseDTO courseDTO);

    Boolean updateCourseWithTeacher(Map<String,Object> map);

    Boolean updateCourseWithStudent(Map<String,Object> map);

    List<Map<String,Object>> checkStudentSelectCourse(Map<String,Object> map);

    List<Map<String,Object>> checkTeacherSelectCourse(Map<String,Object> map);

}
