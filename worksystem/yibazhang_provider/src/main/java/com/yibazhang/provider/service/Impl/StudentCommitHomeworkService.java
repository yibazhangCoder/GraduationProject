package com.yibazhang.provider.service.Impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.yibazhang.api.bean.HomeworkToTeacherDTO;
import com.yibazhang.api.bean.StudentCommitHomeworkDTO;
import com.yibazhang.api.service.StudentCommitHomeworkAPI;
import com.yibazhang.provider.domain.StudentHomeworkCommitDomain;
import com.yibazhang.provider.entity.HomeWorkTeacherStudent;
import com.yibazhang.provider.entity.StudentHomeworkCommit;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author 一巴掌
 * @Date 2019/4/1 16:18
 * @Description TODO
 * @Version 1.0
 **/
@Service(version = "${yibazhang.service.version}")
public class StudentCommitHomeworkService implements StudentCommitHomeworkAPI {

    @Autowired
    StudentHomeworkCommitDomain studentHomeworkCommitDomain;

    @Override
    public Boolean insertStudentCommitHomework(StudentCommitHomeworkDTO studentCommitHomeworkDTO) {
        if(studentCommitHomeworkDTO.getHId()==null
            ||studentCommitHomeworkDTO.getSId()==null)
            return false;
        StudentHomeworkCommit studentHomeworkCommit = new StudentHomeworkCommit();
        BeanUtils.copyProperties(studentCommitHomeworkDTO,studentHomeworkCommit);
        return studentHomeworkCommitDomain.insertCommitHomework(studentHomeworkCommit);
    }

    @Override
    public Boolean insertHomeworkToTeacher(HomeworkToTeacherDTO homeworkToTeacherDTO) {
        if(homeworkToTeacherDTO.getHId()==null
            ||homeworkToTeacherDTO.getSId()==null
            ||homeworkToTeacherDTO.getTId()==null)
            return false;
        HomeWorkTeacherStudent homeWorkTeacherStudent = new HomeWorkTeacherStudent();
        BeanUtils.copyProperties(homeworkToTeacherDTO,homeWorkTeacherStudent);
        return studentHomeworkCommitDomain.insertHomeworkToTeacher(homeWorkTeacherStudent);
    }
}
