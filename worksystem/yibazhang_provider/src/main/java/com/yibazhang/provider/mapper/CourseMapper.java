package com.yibazhang.provider.mapper;

import com.yibazhang.provider.entity.Course;

public interface CourseMapper {
    int deleteByPrimaryKey(Integer crId);

    int insert(Course record);

    int insertSelective(Course record);

    Course selectByPrimaryKey(Integer crId);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);
}