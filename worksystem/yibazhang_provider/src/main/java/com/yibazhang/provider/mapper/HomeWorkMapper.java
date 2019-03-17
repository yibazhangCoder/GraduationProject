package com.yibazhang.provider.mapper;

import com.yibazhang.provider.entity.HomeWork;

public interface HomeWorkMapper {
    int deleteByPrimaryKey(Long hId);

    int insert(HomeWork record);

    int insertSelective(HomeWork record);

    HomeWork selectByPrimaryKey(Long hId);

    int updateByPrimaryKeySelective(HomeWork record);

    int updateByPrimaryKey(HomeWork record);
}