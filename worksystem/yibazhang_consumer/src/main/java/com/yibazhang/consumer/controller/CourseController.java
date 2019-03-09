package com.yibazhang.consumer.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yibazhang.api.bean.CourseDTO;
import com.yibazhang.consumer.common.BaseController;
import com.yibazhang.consumer.service.CourseService;
import com.yibazhang.consumer.utils.EnclosureJsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author 一巴掌
 * @Date 2019/3/2 22:07
 * @Description TODO
 * @Version 1.0
 **/
@Controller
@RequestMapping("/course")
public class CourseController extends BaseController {

    @Autowired
    CourseService courseService;


    @RequestMapping(value = "/courseInsertWithStudent",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject insertCourseWithStudent(Integer sId ,@RequestParam(required = false,value = "crIds[]") List crIds){
        if(sId==null)return fail4Param("参数错误");
        Map<String,Object> map =  new HashMap<>();
        map.put("sId",sId);
        map.put("crIds",crIds);
        map.put("selectStatus",1);
        return courseService.insertCourseWithStudent(map)?success("选课成功"):fail(401,"选课失败");
    }


    @RequestMapping(value = "/courseInsertWithTeacher",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject insertCourseWithTeacher(Integer tId ,@RequestParam(required = false,value = "crIds[]") List<Integer> crIds){
        if(tId==null)return fail4Param("参数错误");
        Map<String,Object> map =  new HashMap<>();
        map.put("tId",tId);
        map.put("crIds",crIds);
        map.put("selectStatus",1);
        return courseService.insertCourseWithTeacher(map)?success("选课成功"):fail(401,"选课失败");
    }

    @RequestMapping(value = "/selectCourseWithTeacher",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String selectCourseWithTeacher(CourseDTO courseDTO){
        if(courseDTO.getPage()==null)courseDTO.setPage(1);
        if(courseDTO.getLimit()==null)courseDTO.setLimit(5);
        PageHelper.startPage(courseDTO.getPage(),courseDTO.getLimit());
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(courseService.selectCourseWithTeacher(courseDTO),5);
        return EnclosureJsonData.getJSONData(pageInfo.getTotal(),pageInfo.getList());
    }


    @RequestMapping(value = "/selectCourseWithStudent",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String selectCourseWithStudent(CourseDTO courseDTO){
        if(courseDTO.getPage()==null)courseDTO.setPage(1);
        if(courseDTO.getLimit()==null)courseDTO.setLimit(5);
        PageHelper.startPage(courseDTO.getPage(),courseDTO.getLimit());
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(courseService.selectCourseWithStudent(courseDTO),5);
        return EnclosureJsonData.getJSONData(pageInfo.getTotal(),pageInfo.getList());
    }


    @RequestMapping(value = "/updateCourseWithTeacher",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject updateCourseWithTeacher(@RequestParam(required = false,value = "ids[]") List<Integer> ids){
        if(ids.isEmpty())return fail4Param("参数错误！");

        Map<String,Object> map = new HashMap<>();
        map.put("ids",ids);
        map.put("selectStatus",0);
        return courseService.updateCourseWithTeacher(map)?success("退课成功"):fail(401,"退课失败");
    }

    @RequestMapping(value = "/updateCourseWithStudent",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject updateCourseWithStudent(@RequestParam(required = false,value = "ids[]") List<Integer> ids){
        if(ids.isEmpty())return fail4Param("参数错误！");
        Map<String,Object> map = new HashMap<>();
        map.put("ids",ids);
        map.put("selectStatus",0);
        return courseService.updateCourseWithStudent(map)?success("退课成功"):fail(401,"退课失败");
    }
}
