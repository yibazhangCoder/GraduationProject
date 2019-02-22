package com.yibazhang.provider.mapper;

import com.yibazhang.provider.entity.Academy;

public interface AcademyMapper {
    int deleteByPrimaryKey(Integer acaId);

    int insert(Academy record);

    int insertSelective(Academy record);

    Academy selectByPrimaryKey(Integer acaId);

    int updateByPrimaryKeySelective(Academy record);

    int updateByPrimaryKey(Academy record);
}