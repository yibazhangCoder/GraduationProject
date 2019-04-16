package com.yibazhang.api.service;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.yibazhang.api.bean.HomeWorkDTO;
import com.yibazhang.api.bean.HomeWorkTeacherStudentDTO;

import java.util.List;
import java.util.Map;

/**
 * @Author 一巴掌
 * @Date 2019/4/7 20:14
 * @Description TODO
 * @Version 1.0
 **/
public interface TeacherHomeworkReceivedAPI {

    /**
     *  删除作业  当type==1 时 同时会删除未到发布时间的学生作业
     *            当type==0 时 删除作业本身但是不删除布置给学生的作业
     * @param map
     * @return
     */
    boolean deleteHomeworkBatch(Map<String,Object> map,Integer type);

    /**
     * 修改作业信息
     * @param homeWorkDTO
     * @return
     */
    boolean updateHomework(HomeWorkDTO homeWorkDTO);

    /**
     * 查询当前提交作业的人数
     * @param hId
     * @return
     */
    Long selectCommitedHomeworkCount(Long hId);

    /**
     * 应交作业人数
     * @param hId
     * @return
     */
    Long selectSumCount(Long hId);

    /**
     * 作业回收时间时查询所有提交作业的学生的详细信息
     * @param map
     * @return
     */
    List<Map<String,Object>> selectCommitedHomeworkStudent(Map<String,Object> map);

    /**
     * 更新接收状态 和设置评分
     * @param homeWorkTeacherStudentDTO
     * @return
     */
    Boolean updateTeacherStudentHomeworkStatus(HomeWorkTeacherStudentDTO homeWorkTeacherStudentDTO);


}
