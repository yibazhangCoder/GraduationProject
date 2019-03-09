package com.yibazhang.provider.domain;

import com.yibazhang.provider.entity.Course;
import com.yibazhang.provider.entity.ext.CourseExt;
import com.yibazhang.provider.mapper.ext.CourseMapperExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @Author 一巴掌
 * @Date 2019/3/1 22:42
 * @Description TODO
 * @Version 1.0
 **/
@Service
@Transactional
public class CourseDomain {


    @Autowired
    CourseMapperExt courseMapperExt;

    @Transactional(rollbackFor = Exception.class)
    public boolean insertCourseWithStudent(Map<String,Object> map){
        if(map.isEmpty())return false;
        if(map.get("sId")==null)return false;
        return courseMapperExt.insertCourseWithStudent(map);
    }


    @Transactional(rollbackFor = Exception.class)
    public boolean insertCourseWithTeacher(Map<String,Object> map){
        if(map.isEmpty())return false;
        if(map.get("tId")==null)return false;
        return courseMapperExt.insertCourseWithTeacher(map);
    }


    @Transactional(rollbackFor = Exception.class)
    public boolean updateCourseWithTeacher(Map<String,Object> map){
        if(map.isEmpty())return false;
        return courseMapperExt.courseUpdataWithTeacher(map);
    }


    @Transactional(rollbackFor = Exception.class)
    public boolean updateCourseWithStudent(Map<String,Object> map){
        if (map.isEmpty())return false;
        return courseMapperExt.courseUpdateWithStudent(map);
    }

    public List<Map<String,Object>> selectCourseWithTeacher(CourseExt courseExt){
        return courseMapperExt.selectCourseWithTeacher(courseExt);
    }

    public List<Map<String,Object>> selectCourseWithStudent(CourseExt courseExt){
        return courseMapperExt.selectCourseWithStudent(courseExt);
    }
}
