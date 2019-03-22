package com.yibazhang.provider.domain;

import com.yibazhang.provider.entity.HomeWork;
import com.yibazhang.provider.entity.HomeWorkStudent;
import com.yibazhang.provider.entity.ext.HomeWorkExt;
import com.yibazhang.provider.mapper.HomeWorkMapper;
import com.yibazhang.provider.mapper.HomeWorkStudentMapper;
import com.yibazhang.provider.mapper.ext.HomeWorkMapperExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @Author 一巴掌
 * @Date 2019/3/14 15:04
 * @Description TODO
 * @Version 1.0
 **/
@Service
@Transactional
public class HomeworkDomain {

    @Autowired
    HomeWorkMapper homeWorkMapper;

    @Autowired
    HomeWorkStudentMapper homeWorkStudentMapper;

    @Autowired
    HomeWorkMapperExt homeWorkMapperExt;

    @Transactional(rollbackFor = Exception.class)
    public boolean saveHomework(HomeWork homeWork){
        if(homeWork==null)return false;
        return homeWorkMapper.insertSelective(homeWork)>0;
    }


    @Transactional(rollbackFor = Exception.class)
    public boolean insertHomeworkToStduent(HomeWorkStudent homeWorkStudent){
        if(homeWorkStudent==null)return false;
        return homeWorkStudentMapper.insertSelective(homeWorkStudent)>0;
    }


    @Transactional(rollbackFor = Exception.class)
    public int insertHomeworkToStudentBatch(Map<String,Object> map){
        if(map.isEmpty())return 0;
        if(map.get("hId")==null)return 0;
        return homeWorkMapperExt.insertHomeworkToStudentBatch(map);
    }


    public List<Map<String,Object>>  selectTeacherOfHomework(HomeWorkExt homeWorkExt){
        return homeWorkMapperExt.selectHomeworkOfTeacher(homeWorkExt);
    }
}
