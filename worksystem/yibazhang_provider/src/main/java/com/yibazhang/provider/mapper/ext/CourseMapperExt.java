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

    /**
     * 查询所有可选课程   可模糊查询
     * @param courseExt
     * @return
     */
    List<Map<String,Object>> selectCourses(CourseExt courseExt);

    List<Map<String,Object>> selectCourseWithTeacher(CourseExt courseExt);

    List<Map<String,Object>> selectCourseWithStudent(CourseExt courseExt);

    List<Map<String,Object>> selectTeacherWithCourse(Map<String,Object> map);

    List<Map<String,Object>> selectStudentWithCourse(Map<String,Object> map);

    Boolean insertCourseWithStudent(Map<String,Object> map);

    Boolean insertCourseWithTeacher(Map<String,Object> map);

    Boolean courseUpdataWithTeacher(Map<String,Object> map);

    Boolean courseUpdateWithStudent(Map<String,Object> map);
}
