package com.yibazhang.consumer.controller;

import com.alibaba.fastjson.JSONObject;
import com.yibazhang.api.bean.Student;
import com.yibazhang.api.bean.TeacherDTO;
import com.yibazhang.api.bean.sys.UserDTO;
import com.yibazhang.consumer.common.BaseController;
import com.yibazhang.consumer.service.AdminService;
import com.yibazhang.consumer.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @Author 一巴掌
 * @Date 2019/5/18 14:59
 * @Description TODO
 * @Version 1.0
 **/
@Controller
@RequestMapping("/info")
public class InfoMessionController extends BaseController {

    @Autowired
    AdminService adminService;

    @Autowired
    StudentService studentService;


    @RequestMapping(value = "/personalInfo")
    public ModelAndView personalInfo(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView("common/personInfoDetail");
        UserDTO userDTO = (UserDTO) request.getSession().getAttribute("userInfo");
        Integer roleId = userDTO.getUserRoleId();
        List<Map<String,Object>> list=null;
        if(roleId==1) {
            Student student = new Student();
            student.setSId(userDTO.getUserId());
            list = studentService.getStudents(student);
        }else if(roleId==2){
            TeacherDTO teacherDTO = new TeacherDTO();
            teacherDTO.setTId(userDTO.getUserId());
            list = adminService.selectTeachers(teacherDTO);
        }
        modelAndView.addObject("userInfo",list.get(0));
        return modelAndView;
    }

}
