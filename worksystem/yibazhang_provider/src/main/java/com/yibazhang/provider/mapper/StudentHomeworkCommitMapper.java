package com.yibazhang.provider.mapper;

import com.yibazhang.provider.entity.StudentHomeworkCommit;

public interface StudentHomeworkCommitMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StudentHomeworkCommit record);

    int insertSelective(StudentHomeworkCommit record);

    StudentHomeworkCommit selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StudentHomeworkCommit record);

    int updateByPrimaryKey(StudentHomeworkCommit record);
}