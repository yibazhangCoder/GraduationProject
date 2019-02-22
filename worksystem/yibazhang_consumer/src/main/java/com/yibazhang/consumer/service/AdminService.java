package com.yibazhang.consumer.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yibazhang.api.bean.AcademyDTO;
import com.yibazhang.api.bean.ClassDTO;
import com.yibazhang.api.bean.ProfessionDTO;
import com.yibazhang.api.bean.TeacherDTO;
import com.yibazhang.api.bean.ext.AcaDTOExt;
import com.yibazhang.api.service.AdminApi;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author 一巴掌
 * @Date 2019/2/15 17:34
 * @Description TODO
 * @Version 1.0
 **/
@Service
public class AdminService {

    @Reference(version = "${yibazhang.service.version}")
    AdminApi adminApi;

    /**
     *
     * @return
     */
    public boolean addAca(AcademyDTO academyDTO){
        if (academyDTO==null)return false;
        return adminApi.addAcaInfo(academyDTO);
    }

    public boolean addProess(ProfessionDTO professionDTO){
        if(professionDTO==null)return false;
        return adminApi.addProfeInfo(professionDTO);
    }

    public boolean addClass(ClassDTO classDTO){
        return classDTO==null?false:adminApi.addClassInfo(classDTO);
    }

    public boolean addTeacherInfo(TeacherDTO teacherDTO){
        return teacherDTO==null?false:adminApi.addTeaInfo(teacherDTO);
    }

    public List<Map<String,Object>> selectAcas(AcaDTOExt acaDTOExt){
        return adminApi.selectAca(acaDTOExt);
    }

    public List<Map<String,Object>> selectAcaAndProfess(AcaDTOExt acaDTOExt) {
        return adminApi.selectAcaAndPro(acaDTOExt);
    }

    public List<Map<String,Object>> selectAcaAndProfessAndClass(AcaDTOExt acaDTOExt) {return  adminApi.selectAcaAndProAndClass(acaDTOExt);}

    public List<Map<String,Object>> selectTeachers(TeacherDTO teacherDTO){return adminApi.selectTeachers(teacherDTO);}
}
