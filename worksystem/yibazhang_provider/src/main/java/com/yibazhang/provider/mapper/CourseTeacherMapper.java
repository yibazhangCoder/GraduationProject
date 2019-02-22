package com.yibazhang.provider.mapper;

import com.yibazhang.provider.entity.CourseTeacher;

public interface CourseTeacherMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CourseTeacher record);

    int insertSelective(CourseTeacher record);

    CourseTeacher selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CourseTeacher record);

    int updateByPrimaryKey(CourseTeacher record);
}