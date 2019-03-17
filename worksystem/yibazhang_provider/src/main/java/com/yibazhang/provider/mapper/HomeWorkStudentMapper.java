package com.yibazhang.provider.mapper;

import com.yibazhang.provider.entity.HomeWorkStudent;

public interface HomeWorkStudentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HomeWorkStudent record);

    int insertSelective(HomeWorkStudent record);

    HomeWorkStudent selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HomeWorkStudent record);

    int updateByPrimaryKey(HomeWorkStudent record);
}