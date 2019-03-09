package com.yibazhang.provider.mapper.ext;

import com.yibazhang.provider.entity.ext.CourseExt;

import java.util.List;
import java.util.Map;


/**
 * @Author 一巴掌
 * @Date 2019/2/22 21:36
 * @Description TODO
 * @Version 1.0
 **/
public interface CourseMapperExt {

    List<Map<String,Object>> selectCourses(CourseExt courseExt);

    List<Map<String,Object>> selectCourseWithTeacher(CourseExt courseExt);

    List<Map<String,Object>> selectCourseWithStudent(CourseExt courseExt);

    Boolean insertCourseWithStudent(Map<String,Object> map);

    Boolean insertCourseWithTeacher(Map<String,Object> map);

    Boolean courseUpdataWithTeacher(Map<String,Object> map);

    Boolean courseUpdateWithStudent(Map<String,Object> map);
}
