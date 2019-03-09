package com.yibazhang.api.service;

import com.yibazhang.api.bean.*;
import com.yibazhang.api.bean.ext.AcaDTOExt;

import java.util.List;
import java.util.Map;

/**
 * @Author 一巴掌
 * @Date 2019/2/15 16:41
 * @Description TODO
 * @Version 1.0
 **/
public interface AdminApi {

    /**
     * 添加学院
     * @param academyDTO
     * @return
     */
    boolean addAcaInfo(AcademyDTO academyDTO);

    /**
     * 添加专业
     * @param professionDTO
     * @return
     */
    boolean addProfeInfo(ProfessionDTO professionDTO);

    /**
     * 添加班级
     * @param classDTO
     * @return
     */
    boolean addClassInfo(ClassDTO classDTO);

    /**
     * 添加老师
     * @param teacherDTO
     * @return
     */
    boolean addTeaInfo(TeacherDTO teacherDTO);

    /**
     * 课程信息添加
     * @param courseDTO
     * @return
     */
    boolean addCourse(CourseDTO courseDTO);
    /**
     * 查找学院
     * @param acaDTOExt
     * @return
     */
    List<Map<String,Object>> selectAca(AcaDTOExt acaDTOExt);

    /**
     * 查找学院和专业
     * @param acaDTOExt
     * @return
     */
    List<Map<String,Object>> selectAcaAndPro(AcaDTOExt acaDTOExt);


    /**
     * 查找学院，专业和班级
     * @param acaDTOExt
     * @return
     */
    List<Map<String,Object>> selectAcaAndProAndClass(AcaDTOExt acaDTOExt);

    /**
     * 查找教师
     * @param teacherDTO
     * @return
     */
    List<Map<String, Object>> selectTeachers(TeacherDTO teacherDTO);


    List<Map<String,Object>> selectCourses(CourseDTO courseDTO);
}
