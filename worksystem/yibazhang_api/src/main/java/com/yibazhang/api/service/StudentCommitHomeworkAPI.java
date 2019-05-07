package com.yibazhang.api.service;

import com.yibazhang.api.bean.HomeWorkStudentDTO;
import com.yibazhang.api.bean.HomeworkToTeacherDTO;
import com.yibazhang.api.bean.StudentCommitHomeworkDTO;

/**
 * @Author 一巴掌
 * @Date 2019/4/1 16:12
 * @Description TODO
 * @Version 1.0
 **/
public interface StudentCommitHomeworkAPI {

    /**
     * 保存学生要提交的作业
     * @param studentCommitHomeworkDTO
     * @return
     */
    Boolean insertStudentCommitHomework(StudentCommitHomeworkDTO studentCommitHomeworkDTO);


    /**
     * 提交学生的作业给老师
     * @param homeworkToTeacherDTO
     * @return
     */
    Boolean insertHomeworkToTeacher(HomeworkToTeacherDTO homeworkToTeacherDTO);

    /**
     * 更新学生的作业状态
     * @param homeWorkStudentDTO
     * @return
     */
    boolean updateStudentHomeworkStatus(HomeWorkStudentDTO homeWorkStudentDTO);

    /**
     * 学生评价接口
     */
    boolean updateStudentCommitedHomework(StudentCommitHomeworkDTO studentCommitHomeworkDTO);
}
