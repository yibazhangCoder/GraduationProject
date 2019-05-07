package com.yibazhang.provider.domain;

import com.yibazhang.provider.entity.HomeWorkStudent;
import com.yibazhang.provider.entity.HomeWorkTeacherStudent;
import com.yibazhang.provider.entity.StudentHomeworkCommit;
import com.yibazhang.provider.mapper.HomeWorkTeacherStudentMapper;
import com.yibazhang.provider.mapper.StudentHomeworkCommitMapper;
import com.yibazhang.provider.mapper.StudentMapper;
import com.yibazhang.provider.mapper.ext.StudentHomeworkCommitMapperExt;
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

    @Autowired
    StudentHomeworkCommitMapperExt studentHomeworkCommitMapperExt;


    /**
     * 保存学生提交的作业
     * @param studentHomeworkCommit
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean insertCommitHomework(StudentHomeworkCommit studentHomeworkCommit){
        if(studentHomeworkCommit.getsId()==null||studentHomeworkCommit.gethId()==null)return false;
        //学生作业保存之前先将之前提交的作业置为已过期状态
        studentHomeworkCommitMapperExt.updateStudentCommitedHomeworkStatus(studentHomeworkCommit);
        return homeworkCommitMapper.insertSelective(studentHomeworkCommit)>0;
    }


    /**
     * 学生提交作业
     * @param homeWorkTeacherStudent
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean insertHomeworkToTeacher(HomeWorkTeacherStudent homeWorkTeacherStudent){
        if(homeWorkTeacherStudent.gethId()==null
                ||homeWorkTeacherStudent.getsId()==null
                ||homeWorkTeacherStudent.gettId()==null)
            return false;
        //提交作业之前  将之前提交的作业置为已过期状态
        studentHomeworkCommitMapperExt.updateHomeworkToTeacherStatus(homeWorkTeacherStudent);
        return homeWorkTeacherStudentMapper.insertSelective(homeWorkTeacherStudent)>0;
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean updateStudentHomeworkStatus(HomeWorkStudent homeWorkStudent){
        if(homeWorkStudent.gethId()==null
                ||homeWorkStudent.getsId()==null
                ||homeWorkStudent.gethStatusStu()==null)return false;
        return studentHomeworkCommitMapperExt.updateStudentHomeoworkStatus(homeWorkStudent)>0;
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean updateStudentHomework(StudentHomeworkCommit studentHomeworkCommit){
        if(studentHomeworkCommit==null)return false;
        return homeworkCommitMapper.updateByPrimaryKeySelective(studentHomeworkCommit)>0;
    }
}
