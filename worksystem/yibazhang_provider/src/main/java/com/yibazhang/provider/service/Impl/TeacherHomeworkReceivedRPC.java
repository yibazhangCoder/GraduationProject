package com.yibazhang.provider.service.Impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.yibazhang.api.bean.HomeWorkDTO;
import com.yibazhang.api.bean.HomeWorkTeacherStudentDTO;
import com.yibazhang.api.service.TeacherHomeworkReceivedAPI;
import com.yibazhang.provider.domain.TeacherHomeworkReceiveAndOperatorDomain;
import com.yibazhang.provider.entity.HomeWork;
import com.yibazhang.provider.entity.HomeWorkTeacherStudent;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @Author 一巴掌
 * @Date 2019/4/7 21:15
 * @Description TODO
 * @Version 1.0
 **/
@Service(version = "${yibazhang.service.version}")
public class TeacherHomeworkReceivedRPC implements TeacherHomeworkReceivedAPI {

    @Autowired
    TeacherHomeworkReceiveAndOperatorDomain teacherHomeworkReceiveAndOperatorDomain;

    @Override
    public boolean deleteHomeworkBatch(Map<String,Object> map,Integer type) {
        return teacherHomeworkReceiveAndOperatorDomain.deleteHomeworkBatch(map,type);
    }

    @Override
    public boolean updateHomework(HomeWorkDTO homeWorkDTO) {
        HomeWork homeWork = new HomeWork();
        BeanUtils.copyProperties(homeWorkDTO,homeWork);
        return teacherHomeworkReceiveAndOperatorDomain.updateHomework(homeWork);
    }

    @Override
    public Long selectCommitedHomeworkCount(Long hId) {
        return teacherHomeworkReceiveAndOperatorDomain.selectCommitedHomeworkCount(hId);
    }

    @Override
    public Long selectSumCount(Long hId) {
        return teacherHomeworkReceiveAndOperatorDomain.selectShouldCommitedCount(hId);
    }

    @Override
    public List<Map<String, Object>> selectCommitedHomeworkStudent(Map<String, Object> map) {
        return teacherHomeworkReceiveAndOperatorDomain.selectCommitedHomeworkStudent(map);
    }

    @Override
    public Boolean updateTeacherStudentHomeworkStatus(HomeWorkTeacherStudentDTO homeWorkTeacherStudentDTO) {
        if(homeWorkTeacherStudentDTO.getId()==null)return false;
        HomeWorkTeacherStudent homeWorkTeacherStudent = new HomeWorkTeacherStudent();
        BeanUtils.copyProperties(homeWorkTeacherStudentDTO,homeWorkTeacherStudent);
        return teacherHomeworkReceiveAndOperatorDomain.updateTeacherHomeworkStatusIsReceived(homeWorkTeacherStudent);
    }

}
