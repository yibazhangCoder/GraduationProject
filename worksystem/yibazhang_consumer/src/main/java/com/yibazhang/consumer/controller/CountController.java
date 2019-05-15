package com.yibazhang.consumer.controller;

import com.alibaba.fastjson.JSONObject;
import com.yibazhang.api.bean.sys.UserDTO;
import com.yibazhang.consumer.common.BaseController;
import com.yibazhang.consumer.service.CountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author 一巴掌
 * @Date 2019/5/15 18:57
 * @Description TODO
 * @Version 1.0
 **/
@Controller
@RequestMapping("/count")
public class CountController extends BaseController {

    @Autowired
    CountService countService;

    @RequestMapping(value = "/selectTOP",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject selectCommentTOP(HttpServletRequest request,Integer type){
        if(type==null)return fail4Param("参数错误！");
        UserDTO userDTO = (UserDTO) request.getSession().getAttribute("userInfo");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("homeworks",countService.selectCommentTOP(userDTO.getUserId(),type));
        return success(jsonObject);
    }
}
