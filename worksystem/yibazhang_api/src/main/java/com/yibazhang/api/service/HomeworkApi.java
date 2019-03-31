package com.yibazhang.api.service;

import com.yibazhang.api.bean.HomeWorkDTO;
import com.yibazhang.api.bean.HomeWorkStudentDTO;

import java.util.List;
import java.util.Map;

/**
 * @Author 一巴掌
 * @Date 2019/3/14 15:09
 * @Description TODO
 * @Version 1.0
 **/
public interface HomeworkApi {

    boolean saveHomework(HomeWorkDTO homeWorkDTO);

    boolean insertHomeworkToStduent(HomeWorkStudentDTO homeWorkStudentDTO);

    int insertHomeworkToStudentBatch(Map<String,Object> map);

    List<Map<String,Object>> selctHomeworkOfTeacher(HomeWorkDTO homeWorkDTO);

    List<Map<String,Object>> selectHomeworkOfStudent(HomeWorkDTO homeWorkDTO);

    List<Map<String,Object>> selectDownloadFile(Map<String,Object> map,Integer type);

    int updateHomeworkStatusBatch(Map<String,Object> map,Integer type);
}
