package com.yibazhang.consumer.controller;

import com.alibaba.fastjson.JSONObject;
import com.yibazhang.consumer.common.BaseController;
import com.yibazhang.consumer.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author 一巴掌
 * @Date 2019/3/4 22:05
 * @Description TODO
 * @Version 1.0
 **/
@Controller
@RequestMapping("/mail")
public class MailController extends BaseController {

    @Autowired
    MailService mailService;


    @RequestMapping(value = "/getCheckCode",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject getCheckCode(String mail){
        if(mail==""||mail.isEmpty())return fail4Param("邮箱不能为空！");
        String checkCode;
        checkCode = mailService.getCheckCode(mail);
        return success(checkCode);
    }
}
