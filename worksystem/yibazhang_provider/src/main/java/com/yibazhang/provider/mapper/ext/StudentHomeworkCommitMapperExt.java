package com.yibazhang.provider.mapper.ext;


import com.yibazhang.provider.entity.HomeWorkStudent;
import com.yibazhang.provider.entity.HomeWorkTeacherStudent;
import com.yibazhang.provider.entity.StudentHomeworkCommit;

public interface StudentHomeworkCommitMapperExt {

    int updateStudentCommitedHomeworkStatus(StudentHomeworkCommit studentHomeworkCommit);

    int updateHomeworkToTeacherStatus(HomeWorkTeacherStudent homeWorkTeacherStudent);

    int updateStudentHomeoworkStatus(HomeWorkStudent homeWorkStudent);
}