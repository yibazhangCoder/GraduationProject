package com.yibazhang.consumer.controller.sys;

import com.alibaba.fastjson.JSONObject;
import com.yibazhang.api.bean.Student;
import com.yibazhang.api.bean.sys.UserDTO;
import com.yibazhang.consumer.common.BaseController;
import com.yibazhang.consumer.service.sys.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author 一巴掌
 * @Date 2019/2/10 23:23
 * @Description TODO
 * @Version 1.0
 **/
@RestController
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
    public JSONObject userLogin( UserDTO userDTO){
        JSONObject jsonObject = new JSONObject();
        if (userDTO==null)return fail4Param("参数异常！");
        jsonObject.put("loginInfo",service.userLogin(userDTO.getUserId(),userDTO.getPassword()));
        return success(jsonObject);
    }

    /**
     *
     * @param student
     * @return
     */
    @RequestMapping(value = "/userRegister",method = RequestMethod.POST)
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
        jsonObject.put("registerInfo",service.userRegister(student));
        return success(jsonObject);
    }
}
