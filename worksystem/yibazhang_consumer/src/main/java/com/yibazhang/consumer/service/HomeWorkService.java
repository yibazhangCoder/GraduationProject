package com.yibazhang.consumer.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yibazhang.api.bean.HomeWorkDTO;
import com.yibazhang.api.bean.Student;
import com.yibazhang.api.service.HomeworkApi;
import com.yibazhang.api.service.StudentApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author 一巴掌
 * @Date 2019/3/14 16:53
 * @Description TODO
 * @Version 1.0
 **/
@Service
public class HomeWorkService {

    @Reference(version = "${yibazhang.service.version}",timeout = 5000)
    HomeworkApi homeworkApi;

    @Reference(version = "${yibazhang.service.version}",timeout = 5000)
    StudentApi studentApi;

    @Autowired
    CourseService courseService;

    public boolean saveHomework(HomeWorkDTO homeWorkDTO){
        if(homeWorkDTO==null)return false;
        return homeworkApi.saveHomework(homeWorkDTO);
    }

    public int insertHomeworkToStudent(HomeWorkDTO homeWorkDTO){
        if(homeWorkDTO==null)return 0;
        List<Integer> list =new ArrayList<>();
        Map<String,Object> param = new HashMap<>();
        if(homeWorkDTO.getAcaId()!=null&&homeWorkDTO.getProfessionId()!=null){
            Student student = new Student();
            student.setSAca(homeWorkDTO.getAcaId());
            student.setSProfession(homeWorkDTO.getProfessionId());
            List<Map<String,Object>> students = studentApi.getStudents(student);
            if(students.isEmpty())return 100;
            for (Map<String,Object> map:
                 students) {
                list.add((Integer) map.get("sId"));
            }
        }else if(homeWorkDTO.getHCourse()!=null){
            Map<String,Object> map = new HashMap<>();
            map.put("crId",homeWorkDTO.getHCourse());
            map.put("tId",homeWorkDTO.getHUper());
            List<Map<String,Object>> crIds = courseService.checkStudnetSelectCourse(map);
            if(crIds.isEmpty())return 101;
            for (Map<String, Object> objectMap :crIds ) {
                list.add((Integer)objectMap.get("sId"));
            }
        }
        param.put("hStatusStu",0);
        param.put("hId",homeWorkDTO.getHId());
        param.put("sIds",list);
        return homeworkApi.insertHomeworkToStudentBatch(param);
    }


    public List<Map<String,Object>> selectHomeworkOfTeacher(HomeWorkDTO homeWorkDTO){
        if(homeWorkDTO.getHUper()==null)return null;
        return homeworkApi.selctHomeworkOfTeacher(homeWorkDTO);
    }

    public List<Map<String,Object>> selectHomeworkOfStudent(HomeWorkDTO homeWorkDTO){
        if(homeWorkDTO.getSId()==null)return null;
        return homeworkApi.selectHomeworkOfStudent(homeWorkDTO);
    }


    public List<Map<String,Object>> getDownloadFiles(Map<String,Object> map,Integer type){
        if(map.get("ids")==null)return null;
        return homeworkApi.selectDownloadFile(map,type);
    }


    public int updateHomeworkStatusBatch(Map<String,Object> map,Integer type){
        return homeworkApi.updateHomeworkStatusBatch(map,type);
    }
}
