package com.yibazhang.provider.domain;

import com.yibazhang.provider.entity.Student;
import com.yibazhang.provider.entity.sys.SysMenu;
import com.yibazhang.provider.entity.sys.SysUser;
import com.yibazhang.provider.entity.sys.SysUserRole;
import com.yibazhang.provider.entity.sys.ext.SysUserExt;
import com.yibazhang.provider.enumtype.RoleEnum;
import com.yibazhang.provider.mapper.StudentMapper;
import com.yibazhang.provider.mapper.sys.SysUserMapper;
import com.yibazhang.provider.mapper.sys.SysUserRoleMapper;
import com.yibazhang.provider.mapper.sys.ext.SysUserMapperExt;
import com.yibazhang.provider.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author 一巴掌
 * @Date 2019/2/7 13:02
 * @Description TODO
 * @Version 1.0
 **/

@Service
@Transactional
public class UserDomain {

    @Autowired
    SysUserMapperExt sysUserMapperExt;

    @Autowired
    StudentMapper studentMapper;

    @Autowired
    SysUserMapper sysUserMapper;

    @Autowired
    SysUserRoleMapper sysUserRoleMapper;

    /**
     *
     * @param userId
     * @param password
     * @return
     */
    public SysUserExt checkUser(Integer userId, String password){
        String encPassword = MD5Utils.encrypt(password);
        SysUserExt  sysUserExt = sysUserMapperExt.checkUserPwd(userId,encPassword);
        return sysUserExt;
    }

    /**
     *
     * @param userId
     * @return
     */
    public List<SysMenu> findUserMenu(Integer userId){
        List<SysMenu> menus = sysUserMapperExt.findUserMenu(userId);
        return menus;
    }


    /**
     * 学生注册
     * @param student
     * @return
     */
    public Student userRegister(Student student){
        if (student==null) return null;
        Integer i = studentMapper.insertSelective(student);
        SysUser sysUser = new SysUser();
        sysUser.setUserId(student.getsId());
        sysUser.setUserName(student.getsName());
        //设置学生初始密码为邮箱
        String pwd = MD5Utils.encrypt(student.getsEmail());
        sysUser.setPassword(pwd);
        Integer j = sysUserMapper.insertSelective(sysUser);

        //设置学生角色
        SysUserRole sysUserRole = new SysUserRole();
        sysUserRole.setUserId(sysUser.getUserId());
        sysUserRole.setRoleId(RoleEnum.STU_ENUM.getValue());
        Integer k = sysUserRoleMapper.insertSelective(sysUserRole);
        if (i==0||j==0||k==0)return null;
        return student;
    }
}
