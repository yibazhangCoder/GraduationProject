package com.yibazhang.provider.domain;

import com.yibazhang.provider.entity.*;
import com.yibazhang.provider.entity.Class;
import com.yibazhang.provider.entity.ext.AcaAndProAndClassExt;
import com.yibazhang.provider.entity.ext.TeacherExt;
import com.yibazhang.provider.entity.sys.SysUser;
import com.yibazhang.provider.entity.sys.SysUserRole;
import com.yibazhang.provider.enumtype.RoleEnum;
import com.yibazhang.provider.mapper.*;
import com.yibazhang.provider.mapper.ext.AcaMapperExt;
import com.yibazhang.provider.mapper.ext.TeacherMapperExt;
import com.yibazhang.provider.mapper.sys.SysUserMapper;
import com.yibazhang.provider.mapper.sys.SysUserRoleMapper;
import com.yibazhang.provider.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @Author 一巴掌
 * @Date 2019/2/15 15:36
 * @Description TODO
 * @Version 1.0
 **/
@Service
@Transactional
public class AdminDomain {

    @Autowired
    AcademyMapper academyMapper;

    @Autowired
    ProfessionMapper professionMapper;

    @Autowired
    ClassMapper classMapper;


    @Autowired
    TeacherMapper teacherMapper;

    @Autowired
    SysUserMapper sysUserMapper;

    @Autowired
    SysUserRoleMapper sysUserRoleMapper;


    @Autowired
    AcaMapperExt acaMapperExt;

    @Autowired
    TeacherMapperExt teacherMapperExt;

    @Autowired
    CourseMapper courseMapper;
    /**
     *
     * @param academy
     * @return
     */
    public boolean insertAcademyInfo(Academy academy){
        if (academy==null) return false;
        int i = academyMapper.insertSelective(academy);
        if (i>0){
            return true;
        }else {
            return false;
        }

    }

    /**
     *
     * @param profession
     * @return
     */
    public boolean insertProfessionInfo(Profession profession){
        if(profession==null)return false;
        int i = professionMapper.insertSelective(profession);
        if(i>0)
            return true;
        return false;
    }

    /**
     *
     * @param c
     * @return
     */
    public boolean insertClassInfo(Class c ){
        if (c==null)return false;
        int i = classMapper.insertSelective(c);
        if(i>0)return true;
        return false;
    }


    /**
     *
     * @param teacher
     * @return
     */
    public boolean addTeacherInfo(Teacher teacher){
       if (teacher==null)return false;
       int i = teacherMapper.insertSelective(teacher);
        SysUser sysUser = new SysUser();
        sysUser.setUserId(teacher.gettId());
        sysUser.setUserName(teacher.gettName());
        sysUser.setPassword(MD5Utils.encrypt(teacher.gettEmail()));
        int j = sysUserMapper.insertSelective(sysUser);

        SysUserRole sysUserRole = new SysUserRole();
        sysUserRole.setUserId(sysUser.getUserId());
        sysUserRole.setRoleId(RoleEnum.TEA_ENUM.getValue());
        int k = sysUserRoleMapper.insertSelective(sysUserRole);
       return i==0||j==0||k==0?false:true;
    }

    public boolean addCourse(Course course){
        if(course==null)return false;
        int i = courseMapper.insertSelective(course);
        return i>0?true:false;
    }

    public List<Map<String,Object>> selectAcas(AcaAndProAndClassExt acaAndProAndClassExt) {
        return acaMapperExt.selectAcas(acaAndProAndClassExt);
    }
    public List<Map<String,Object>> selectAcaAndProfess(AcaAndProAndClassExt acaAndProAndClassExt) {
        return acaMapperExt.selectAcaAndPro(acaAndProAndClassExt);
    }
    public List<Map<String,Object>> selectAcaAndProAndClass(AcaAndProAndClassExt acaAndProAndClassExt) {
        return acaMapperExt.selectAcaAndProAndClass(acaAndProAndClassExt);
    }


    public List<Map<String,Object>> selectTeachers(TeacherExt teacherExt){
        return teacherMapperExt.selectTeachers(teacherExt);
    }
}
