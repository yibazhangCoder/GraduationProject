package com.yibazhang.provider.mapper;

import com.yibazhang.provider.entity.Profession;

public interface ProfessionMapper {
    int deleteByPrimaryKey(Integer professionId);

    int insert(Profession record);

    int insertSelective(Profession record);

    Profession selectByPrimaryKey(Integer professionId);

    int updateByPrimaryKeySelective(Profession record);

    int updateByPrimaryKey(Profession record);
}