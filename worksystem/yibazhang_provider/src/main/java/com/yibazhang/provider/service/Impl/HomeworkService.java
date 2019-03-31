package com.yibazhang.provider.service.Impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.yibazhang.api.bean.HomeWorkDTO;
import com.yibazhang.api.bean.HomeWorkStudentDTO;
import com.yibazhang.api.service.HomeworkApi;
import com.yibazhang.provider.domain.HomeworkDomain;
import com.yibazhang.provider.entity.HomeWork;
import com.yibazhang.provider.entity.HomeWorkStudent;
import com.yibazhang.provider.entity.ext.HomeWorkExt;
import com.yibazhang.provider.utils.IdUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @Author 一巴掌
 * @Date 2019/3/14 15:10
 * @Description TODO
 * @Version 1.0
 **/
@Service(version = "${yibazhang.service.version}")
public class HomeworkService implements HomeworkApi {

    @Autowired
    HomeworkDomain homeworkDomain;

    @Override
    public boolean saveHomework(HomeWorkDTO homeWorkDTO) {
        if(homeWorkDTO==null)return false;
        HomeWork homeWork = new HomeWork();
        BeanUtils.copyProperties(homeWorkDTO,homeWork);
        return homeworkDomain.saveHomework(homeWork);
    }

    @Override
    public boolean insertHomeworkToStduent(HomeWorkStudentDTO homeWorkStudentDTO) {
        if(homeWorkStudentDTO==null)return false;
        HomeWorkStudent homeWorkStudent = new HomeWorkStudent();
        BeanUtils.copyProperties(homeWorkStudentDTO,homeWorkStudent);
        return homeworkDomain.insertHomeworkToStduent(homeWorkStudent);
    }

    @Override
    public int insertHomeworkToStudentBatch(Map<String, Object> map) {
        if(map.isEmpty())return 0;
        return homeworkDomain.insertHomeworkToStudentBatch(map);
    }

    @Override
    public List<Map<String, Object>> selctHomeworkOfTeacher(HomeWorkDTO homeWorkDTO) {
        if(homeWorkDTO.getHUper()==null)return null;
        HomeWorkExt homeWorkExt = new HomeWorkExt();
        BeanUtils.copyProperties(homeWorkDTO,homeWorkExt);
        return homeworkDomain.selectTeacherOfHomework(homeWorkExt);
    }

    @Override
    public List<Map<String, Object>> selectHomeworkOfStudent(HomeWorkDTO homeWorkDTO) {
        if(homeWorkDTO.getSId()==null)return null;
        HomeWorkExt homeWorkExt = new HomeWorkExt();
        BeanUtils.copyProperties(homeWorkDTO,homeWorkExt);
        return homeworkDomain.selectHomeworkOfStudent(homeWorkExt);
    }

    @Override
    public List<Map<String, Object>> selectDownloadFile(Map<String, Object> map,Integer type) {
        if(type==null)return null;
        if(map.get("ids")==null)return null;
        return homeworkDomain.selectDownloadFile(map,type);
    }

    @Override
    public int updateHomeworkStatusBatch(Map<String, Object> map, Integer type) {
        if(type==null||map.get("ids")==null)return 0;
        return homeworkDomain.updateHomeworkStatusBatch(map,type);
    }
}
