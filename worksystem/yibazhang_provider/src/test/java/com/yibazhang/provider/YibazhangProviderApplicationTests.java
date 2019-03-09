package com.yibazhang.provider;

import com.yibazhang.provider.entity.Student;
import com.yibazhang.provider.entity.sys.ext.SysUserExt;
import com.yibazhang.provider.mapper.StudentMapper;
import com.yibazhang.provider.mapper.ext.AcaMapperExt;
import com.yibazhang.provider.mapper.ext.CourseMapperExt;
import com.yibazhang.provider.mapper.sys.ext.SysUserMapperExt;
import com.yibazhang.provider.service.Impl.MailService;
import com.yibazhang.provider.utils.MD5Utils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class YibazhangProviderApplicationTests {

    @Autowired
    SysUserMapperExt sysUserMapperExt;


    @Autowired
    MailService mailService;

    @Autowired
    StudentMapper studentMapper;

    @Autowired
    AcaMapperExt acaMapperExt;

    @Autowired
    CourseMapperExt courseMapperExt;


    @Test
    public void contextLoads() {
        String password = MD5Utils.encrypt("123456");
        SysUserExt sysUserExt = sysUserMapperExt.checkUserPwd(1506010207,password);
        System.out.println(sysUserExt.getUserId());
        System.out.println(sysUserExt.getUserName());
        System.out.println(sysUserExt.getUserRoleId());
        System.out.println(sysUserExt.getUserRoleName());
    }

    @Test
    public void testInsertStudent(){
        Student student = new Student();
        student.setsId(150610208);
        student.setsName("牛牛");
        student.setsAge(22);
        student.setsEmail("niuniu@qq.com");
        student.setsMobile("17868522562");
        student.setsSex("m");

        studentMapper.insertSelective(student);
    }


    @Test
    public void testSelectAcaInfo(){
        List<Map<String,Object>> list = acaMapperExt.selectAcas(null);
    }

    @Test
    public void testInsertCourse(){
        Map<String,Object> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i=1;i<=5;i++)list.add(i);
        map.put("tId",2);
        map.put("crIds",list);

        Boolean flag = courseMapperExt.insertCourseWithTeacher(map);

    }

    @Test
    public void testSendEmail(){
        //mailService.sendMail("574844241@qq.com","作业系统");
    }
}