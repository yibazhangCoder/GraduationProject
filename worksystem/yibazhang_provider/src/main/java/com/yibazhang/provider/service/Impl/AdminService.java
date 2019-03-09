package com.yibazhang.provider.service.Impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.yibazhang.api.bean.*;
import com.yibazhang.api.bean.ext.AcaDTOExt;
import com.yibazhang.api.service.AdminApi;
import com.yibazhang.provider.domain.AdminDomain;
import com.yibazhang.provider.entity.*;
import com.yibazhang.provider.entity.Class;
import com.yibazhang.provider.entity.ext.AcaAndProAndClassExt;
import com.yibazhang.provider.entity.ext.CourseExt;
import com.yibazhang.provider.entity.ext.TeacherExt;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Map;

/**
 * @Author 一巴掌
 * @Date 2019/2/15 16:52
 * @Description TODO
 * @Version 1.0
 **/
@Service(version = "${yibazhang.service.version}")
public class AdminService  implements AdminApi {

    @Autowired
    AdminDomain adminDomain;

    @Override
    public boolean addAcaInfo(AcademyDTO academyDTO) {
        if(academyDTO==null)return false;
        Academy academy = new Academy();
        BeanUtils.copyProperties(academyDTO,academy);
        return adminDomain.insertAcademyInfo(academy);
    }

    @Override
    public boolean addProfeInfo(ProfessionDTO professionDTO) {
        if(professionDTO==null)return false;
        Profession profession = new Profession();
        BeanUtils.copyProperties(professionDTO,profession);
        return adminDomain.insertProfessionInfo(profession);
    }

    @Override
    public boolean addClassInfo(ClassDTO classDTO) {
        if (classDTO==null)return false;
        Class c = new Class();
        BeanUtils.copyProperties(classDTO,c);
        return adminDomain.insertClassInfo(c);
    }

    @Override
    public boolean addTeaInfo(TeacherDTO teacherDTO) {
        if (teacherDTO==null)return false;
        Teacher teacher = new Teacher();
        BeanUtils.copyProperties(teacherDTO,teacher);
        return adminDomain.addTeacherInfo(teacher);
    }

    @Override
    public boolean addCourse(CourseDTO courseDTO) {
        if(courseDTO==null)return false;
        Course course = new Course();
        BeanUtils.copyProperties(courseDTO,course);
        return adminDomain.addCourse(course);
    }

    @Override
    public List<Map<String,Object>> selectAca(AcaDTOExt acaDTOExt) {
        AcaAndProAndClassExt acaAndProAndClassExt = new AcaAndProAndClassExt();
        BeanUtils.copyProperties(acaDTOExt,acaAndProAndClassExt);
        return adminDomain.selectAcas(acaAndProAndClassExt);
    }

    @Override
    public List<Map<String,Object>> selectAcaAndPro(AcaDTOExt acaDTOExt) {
        AcaAndProAndClassExt acaAndProAndClassExt = new AcaAndProAndClassExt();
        BeanUtils.copyProperties(acaDTOExt,acaAndProAndClassExt);
        return adminDomain.selectAcaAndProfess(acaAndProAndClassExt);
    }

    @Override
    public List<Map<String,Object>> selectAcaAndProAndClass(AcaDTOExt acaDTOExt) {
        AcaAndProAndClassExt acaAndProAndClassExt = new AcaAndProAndClassExt();
        BeanUtils.copyProperties(acaDTOExt,acaAndProAndClassExt);
        return adminDomain.selectAcaAndProAndClass(acaAndProAndClassExt);
    }

    @Override
    public List<Map<String, Object>> selectTeachers(TeacherDTO teacherDTO) {
        TeacherExt teacherExt = new TeacherExt();
        BeanUtils.copyProperties(teacherDTO,teacherExt);
        return adminDomain.selectTeachers(teacherExt);
    }

    @Override
    public List<Map<String, Object>> selectCourses(CourseDTO courseDTO) {
        CourseExt courseExt = new CourseExt();
        BeanUtils.copyProperties(courseDTO,courseExt);
        return adminDomain.selectCourses(courseExt);
    }
}
