package com.yibazhang.provider.service.Impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.yibazhang.api.bean.CourseDTO;
import com.yibazhang.api.service.CourseApi;
import com.yibazhang.provider.domain.CourseDomain;
import com.yibazhang.provider.entity.ext.CourseExt;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @Author 一巴掌
 * @Date 2019/3/2 21:54
 * @Description TODO
 * @Version 1.0
 **/
@Service(version = "${yibazhang.service.version}")
public class CourseRpc implements CourseApi {

    @Autowired
    CourseDomain courseDomain;


    @Override
    public Boolean insertCourseWithStudent(Map<String, Object> map) {
        return courseDomain.insertCourseWithStudent(map);
    }

    @Override
    public Boolean insertCourseWithTeacher(Map<String, Object> map) {
        return courseDomain.insertCourseWithTeacher(map);
    }

    @Override
    public List<Map<String, Object>> selectCourseWithTeacher(CourseDTO courseDTO) {
        CourseExt courseExt = new CourseExt();
        BeanUtils.copyProperties(courseDTO,courseExt);
        List<Map<String,Object>> list =  courseDomain.selectCourseWithTeacher(courseExt);
        courseExt=null;
        return list;
    }

    @Override
    public List<Map<String, Object>> selectCourseWithStudent(CourseDTO courseDTO) {
        CourseExt courseExt = new CourseExt();
        BeanUtils.copyProperties(courseDTO,courseExt);
        List<Map<String,Object>> list =  courseDomain.selectCourseWithStudent(courseExt);
        courseExt=null;
        return list;
    }

    @Override
    public Boolean updateCourseWithTeacher(Map<String, Object> map) {
        return courseDomain.updateCourseWithTeacher(map);
    }

    @Override
    public Boolean updateCourseWithStudent(Map<String, Object> map) {
        return courseDomain.updateCourseWithStudent(map);
    }
}
