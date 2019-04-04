package com.yibazhang.consumer.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yibazhang.api.bean.HomeworkToTeacherDTO;
import com.yibazhang.api.bean.StudentCommitHomeworkDTO;
import com.yibazhang.api.service.StudentCommitHomeworkAPI;
import org.springframework.stereotype.Service;

/**
 * @Author 一巴掌
 * @Date 2019/4/1 16:26
 * @Description TODO
 * @Version 1.0
 **/
@Service
public class StudentCommitHomeworkService {

    @Reference(version = "${yibazhang.service.version}",timeout = 5000)
    StudentCommitHomeworkAPI studentCommitHomeworkAPI;

    public Boolean saveStudentCommitHomework(StudentCommitHomeworkDTO studentCommitHomeworkDTO){
        if(studentCommitHomeworkDTO.getSId()==null||studentCommitHomeworkDTO.getHId()==null)return false;
        return studentCommitHomeworkAPI.insertStudentCommitHomework(studentCommitHomeworkDTO);
    }

    public Boolean insertHomeworkToTeacher(HomeworkToTeacherDTO homeworkToTeacherDTO){
        if(homeworkToTeacherDTO.getTId()==null
                ||homeworkToTeacherDTO.getSId()==null
                ||homeworkToTeacherDTO.getHId()==null)
            return false;
        return studentCommitHomeworkAPI.insertHomeworkToTeacher(homeworkToTeacherDTO);
    }
}
