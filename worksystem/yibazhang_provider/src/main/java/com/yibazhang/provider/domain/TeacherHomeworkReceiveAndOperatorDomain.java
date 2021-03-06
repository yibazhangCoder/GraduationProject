package com.yibazhang.provider.domain;

import com.yibazhang.provider.entity.HomeWork;
import com.yibazhang.provider.entity.HomeWorkTeacherStudent;
import com.yibazhang.provider.mapper.HomeWorkMapper;
import com.yibazhang.provider.mapper.HomeWorkStudentMapper;
import com.yibazhang.provider.mapper.HomeWorkTeacherStudentMapper;
import com.yibazhang.provider.mapper.ext.TeacherHomeworkReceiveAndOperatorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @Author 一巴掌
 * @Date 2019/4/7 19:57
 * @Description TODO
 * @Version 1.0
 **/
@Service
@Transactional
public class TeacherHomeworkReceiveAndOperatorDomain {

    @Autowired
    TeacherHomeworkReceiveAndOperatorMapper teacherHomeworkReceiveAndOperatorMapper;

    @Autowired
    HomeWorkMapper homeWorkMapper;

    @Autowired
    HomeWorkTeacherStudentMapper homeWorkTeacherStudentMapper;


    @Transactional(rollbackFor = Exception.class)
    public boolean deleteHomeworkBatch(Map<String,Object> map,Integer type){
        if(type==0) {
            int i = teacherHomeworkReceiveAndOperatorMapper.deleteHomeworkBatch(map);
            return i>0;
        }
        if(type==1) {
            int i = teacherHomeworkReceiveAndOperatorMapper.deleteHomeworkBatch(map);
            int j = 0;
            if (i > 0) j = teacherHomeworkReceiveAndOperatorMapper.deleteHomeworkOfStudentBatch(map);
            return i>0||j > 0;
        }
        return false;
    }


    @Transactional(rollbackFor = Exception.class)
    public boolean updateHomework(HomeWork homeWork){
        if(homeWork.gethId()==null)return false;
        return homeWorkMapper.updateByPrimaryKeySelective(homeWork)>0;
    }


    public Long selectCommitedHomeworkCount(Long hId){
        return hId==null?null:teacherHomeworkReceiveAndOperatorMapper.selectCurrentHomeworkCommitedCount(hId);
    }

    public Long selectShouldCommitedCount(Long hId){
        return hId==null?null:teacherHomeworkReceiveAndOperatorMapper.selectShouldCommitedCount(hId);
    }

    public List<Map<String,Object>> selectCommitedHomeworkStudent(Map<String,Object> map){
        return teacherHomeworkReceiveAndOperatorMapper.selectCommitedStudent(map);
    }


    @Transactional(rollbackFor = Exception.class)
    public boolean updateTeacherHomeworkStatusIsReceived(HomeWorkTeacherStudent homeWorkTeacherStudent){
        return homeWorkTeacherStudentMapper.updateByPrimaryKeySelective(homeWorkTeacherStudent)>0;
    }

}
