package com.yibazhang.provider.mapper;

import com.yibazhang.provider.entity.HomeWorkTeacherStudent;

public interface HomeWorkTeacherStudentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HomeWorkTeacherStudent record);

    int insertSelective(HomeWorkTeacherStudent record);

    HomeWorkTeacherStudent selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HomeWorkTeacherStudent record);

    int updateByPrimaryKey(HomeWorkTeacherStudent record);
}