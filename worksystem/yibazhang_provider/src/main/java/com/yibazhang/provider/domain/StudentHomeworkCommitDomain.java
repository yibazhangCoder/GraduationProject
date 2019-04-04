package com.yibazhang.provider.domain;

import com.yibazhang.provider.entity.HomeWorkTeacherStudent;
import com.yibazhang.provider.entity.StudentHomeworkCommit;
import com.yibazhang.provider.mapper.HomeWorkTeacherStudentMapper;
import com.yibazhang.provider.mapper.StudentHomeworkCommitMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author 一巴掌
 * @Date 2019/4/1 15:54
 * @Description TODO
 * @Version 1.0
 **/
@Service
@Transactional
public class StudentHomeworkCommitDomain {

    @Autowired
    StudentHomeworkCommitMapper homeworkCommitMapper;

    @Autowired
    HomeWorkTeacherStudentMapper homeWorkTeacherStudentMapper;


    @Transactional(rollbackFor = Exception.class)
    public boolean insertCommitHomework(StudentHomeworkCommit studentHomeworkCommit){
        if(studentHomeworkCommit.getsId()==null||studentHomeworkCommit.gethId()==null)return false;
        return homeworkCommitMapper.insertSelective(studentHomeworkCommit)>0;
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean insertHomeworkToTeacher(HomeWorkTeacherStudent homeWorkTeacherStudent){
        if(homeWorkTeacherStudent.gethId()==null
                ||homeWorkTeacherStudent.getsId()==null
                ||homeWorkTeacherStudent.gettId()==null)
            return false;
        return homeWorkTeacherStudentMapper.insertSelective(homeWorkTeacherStudent)>0;
    }
}
