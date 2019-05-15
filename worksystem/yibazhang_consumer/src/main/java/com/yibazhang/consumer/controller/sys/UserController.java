package com.yibazhang.consumer.controller.sys;

import com.alibaba.fastjson.JSONObject;
import com.yibazhang.api.bean.Student;
import com.yibazhang.api.bean.sys.UserDTO;
import com.yibazhang.consumer.common.BaseController;
import com.yibazhang.consumer.service.sys.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

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
    public String userLogin(UserDTO userDTO, HttpSession session, Model model){
        if (userDTO.getUserId()==null||userDTO.getPassword()==null) {
            model.addAttribute("msg","用户名或者密码不能为空！");
            return "login";
        }
        UserDTO dto = service.userLogin(userDTO.getUserId(),userDTO.getPassword());
        if(dto==null){
            model.addAttribute("msg","用户名或者密码错误！");
            return "login";
        }
        if(dto.getUserId()==null||dto.getUserName()==null||dto.getUserRoleId()==null){
            model.addAttribute("msg","用户名或者密码错误！");
            return "login";
        }
        UserDTO dto1 =(UserDTO) session.getAttribute("userInfo");
        if(dto1!=null){
            model.addAttribute("hasUser","当前用户【"+dto1.getUserName()+"】已登录！");
            return  "login";
        }
        if(dto.getUserRoleId()!=null) {
            if (dto.getUserRoleId() == 0) dto.setAdmin(true);
            else if (dto.getUserRoleId() == 1) dto.setStudent(true);
            else if (dto.getUserRoleId() == 2) dto.setTeacher(true);
        }
        if(dto!=null&&(dto.getUserId()!=null&&dto.getUserName()!=null)){
            session.setAttribute("userInfo",dto);
        }else {
            model.addAttribute("msg","用户名或者密码错误！");
            return "login";
        }
        return  "redirect:/success.html";
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
