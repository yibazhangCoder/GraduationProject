package com.yibazhang.consumer.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yibazhang.api.bean.HomeWorkDTO;
import com.yibazhang.api.bean.HomeWorkTeacherStudentDTO;
import com.yibazhang.api.service.TeacherHomeworkReceivedAPI;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author 一巴掌
 * @Date 2019/4/7 20:23
 * @Description TODO
 * @Version 1.0
 **/
@Service
public class TeacherHomeworkReceivedService {

    @Reference(version = "${yibazhang.service.version}",timeout = 5000)
    TeacherHomeworkReceivedAPI teacherHomeworkReceivedAPI;


    public boolean deleteHomeworkBatch(Map<String,Object> map,Integer type){
        return teacherHomeworkReceivedAPI.deleteHomeworkBatch(map,type);
    }

    public boolean updateHomework(HomeWorkDTO homeWorkDTO){
        if(homeWorkDTO==null)return false;
        return teacherHomeworkReceivedAPI.updateHomework(homeWorkDTO);
    }

    public Long selectCommitedHomeworkStudentCount(Long hId){
        return teacherHomeworkReceivedAPI.selectCommitedHomeworkCount(hId);
    }

    public Long selectSumCount(Long hId){
        return teacherHomeworkReceivedAPI.selectSumCount(hId);
    }

    public List<Map<String,Object>> selectCommitedStudents(Map<String,Object> map) {
        return teacherHomeworkReceivedAPI.selectCommitedHomeworkStudent(map);
    }


    public boolean updateHomeworkStudentTeacher(HomeWorkTeacherStudentDTO homeWorkTeacherStudentDTO){
        return teacherHomeworkReceivedAPI.updateTeacherStudentHomeworkStatus(homeWorkTeacherStudentDTO);
    }

}
