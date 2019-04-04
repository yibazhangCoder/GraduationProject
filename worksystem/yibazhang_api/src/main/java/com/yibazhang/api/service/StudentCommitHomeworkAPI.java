package com.yibazhang.api.service;

import com.yibazhang.api.bean.HomeworkToTeacherDTO;
import com.yibazhang.api.bean.StudentCommitHomeworkDTO;

/**
 * @Author 一巴掌
 * @Date 2019/4/1 16:12
 * @Description TODO
 * @Version 1.0
 **/
public interface StudentCommitHomeworkAPI {

    Boolean insertStudentCommitHomework(StudentCommitHomeworkDTO studentCommitHomeworkDTO);

    Boolean insertHomeworkToTeacher(HomeworkToTeacherDTO homeworkToTeacherDTO);
}
