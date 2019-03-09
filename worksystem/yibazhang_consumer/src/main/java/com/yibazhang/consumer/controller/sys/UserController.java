package com.yibazhang.consumer.controller.sys;

import com.alibaba.fastjson.JSONObject;
import com.yibazhang.api.bean.Student;
import com.yibazhang.api.bean.sys.UserDTO;
import com.yibazhang.consumer.common.BaseController;
import com.yibazhang.consumer.service.sys.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @Author 一巴掌
 * @Date 2019/2/10 23:23
 * @Description TODO
 * @Version 1.0
 **/
@Controller
@RequestMapping("/sys")
public class UserController extends BaseController {


    @Autowired
    UserService service;
    /**
     *
     * @param userDTO
     * @return
     */
    @RequestMapping(value = "/userLogin",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject userLogin(UserDTO userDTO,HttpSession session){
        if (userDTO.getUserId()==null||userDTO.getPassword()==null) {
            return fail4Param("用户名和密码不能为空！");
        }
        UserDTO dto = service.userLogin(userDTO.getUserId(),userDTO.getPassword());
        if(dto.getUserId()==null||dto.getUserName()==null||dto.getUserRoleId()==null)return fail(405,"用户名或密码错误！ ");
        if(dto.getUserRoleId()!=null) {
            if (dto.getUserRoleId() == 0) dto.setAdmin(true);
            else if (dto.getUserRoleId() == 1) dto.setStudent(true);
            else if (dto.getUserRoleId() == 2) dto.setTeacher(true);
        }
        if(dto!=null&&(dto.getUserId()!=null&&dto.getUserName()!=null)){
            session.setAttribute("userInfo",dto);
            return success("登陆成功！");
        }else {
            return fail(405,"用户名或密码错误！");
        }

    }

    /**
     *
     * @param student
     * @return
     */
    @RequestMapping(value = "/userRegister",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject userRegister( Student student){
        JSONObject jsonObject =  new JSONObject();
        if (student.getSId()==null
                ||student.getSName()==null
                ||student.getSEmail()==null
                ||student.getSAge()==null
                ||student.getSSex()==null
                ||student.getSAca()==null
                ||student.getSProfession()==null
                ||student.getSClass()==null
        )return fail4Param("参数异常");
        Student s = service.userRegister(student);
        if(s==null)return fail(401,"用户信息已存在，请勿重复注册！");
        jsonObject.put("registerInfo",s);
        return success(jsonObject);
    }

    @RequestMapping("/userLogout")
    public String userLogout(HttpSession session){
        session.setAttribute("userInfo",null);
        return "redirect:/";
    }
}
