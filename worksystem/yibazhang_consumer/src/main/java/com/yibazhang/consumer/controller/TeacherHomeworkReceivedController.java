package com.yibazhang.consumer.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yibazhang.api.bean.HomeWorkDTO;
import com.yibazhang.api.bean.HomeWorkTeacherStudentDTO;
import com.yibazhang.api.bean.sys.UserDTO;
import com.yibazhang.consumer.common.BaseController;
import com.yibazhang.consumer.service.TeacherHomeworkReceivedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author 一巴掌
 * @Date 2019/4/7 20:29
 * @Description TODO
 * @Version 1.0
 **/
@Controller
@RequestMapping("/teacherHomework")
public class TeacherHomeworkReceivedController extends BaseController {

    @Autowired
    TeacherHomeworkReceivedService teacherHomeworkReceivedService;

    /**
     * 0和hId  --> 单个删除
     * 1和ids  --> 批量删除
     * @param ids
     * @param hId
     * @param type
     * @return
     */
    @RequestMapping(value = "/deleteHomework",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject deleteHomework(@RequestParam(required = false,value = "ids[]") List<Long> ids,
                                     @RequestParam(value = "hId")Long hId,
                                     Integer type,
                                     Integer res){

        if(ids==null&&hId==null)return fail4Param("参数错误");
        Map<String,Object> map = new HashMap<>();
        if(type==0&&hId!=null){
            List<Long> list = new ArrayList<>();
            list.add(hId);
            map.put("ids",list);
            boolean flag = teacherHomeworkReceivedService.deleteHomeworkBatch(map,res);
            if(!flag)return fail(401,"删除失败！");
        }

        if(type==1&ids!=null){
            map.put("ids",ids);
            boolean flag1 = teacherHomeworkReceivedService.deleteHomeworkBatch(map,res);
            if(!flag1)return fail(401,"删除失败！");
        }
        return success("删除成功！");
    }

    @RequestMapping(value = "/updateHomework",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject updateHomework(HomeWorkDTO homeWorkDTO){
        if(homeWorkDTO.getHId()==null
            ||homeWorkDTO.getHStarttime()==null
            ||homeWorkDTO.getHEndtime()==null)
            return fail4Param("参数错误");
        boolean flag = teacherHomeworkReceivedService.updateHomework(homeWorkDTO);
        if(!flag)return fail(401,"更新失败");
        return success("更新成功！");
    }

    @RequestMapping(value = "/selectCommitedCount",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject selectCommitedCount(Long hId){
        JSONObject jsonObject = new JSONObject();
        if(hId==null)return fail4Param("参数错误");
        jsonObject.put("hasCount",teacherHomeworkReceivedService.selectCommitedHomeworkStudentCount(hId));
        jsonObject.put("shouldCount",teacherHomeworkReceivedService.selectSumCount(hId));
        return success(jsonObject);
    }

    @RequestMapping(value = "/selectCommitedStudents",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject selectCommitedStudents(Long hId,
                                             HttpServletRequest request,
                                             Integer page,
                                             Integer limit){
        UserDTO userDTO = (UserDTO) request.getSession().getAttribute("userInfo");
        if(hId==null||!userDTO.isTeacher())return fail4Param("参数错误！");
        if(page==null)page=1;
        if (limit==null)limit=5;
        PageHelper.startPage(page,limit);
        JSONObject jsonObject = new JSONObject();
        Map<String,Object> map = new HashMap<>();
        map.put("hId",hId);
        map.put("tId",userDTO.getUserId());
        PageInfo<Map<String,Object>> pageInfo =
                new PageInfo<>(teacherHomeworkReceivedService.selectCommitedStudents(map),5);
        jsonObject.put("code",0);
        jsonObject.put("count",pageInfo.getTotal());
        jsonObject.put("data",pageInfo.getList());
        return success(jsonObject);
    }


    @RequestMapping("/toDetail")
    public ModelAndView toDetail(HomeWorkDTO homeWorkDTO,Long hasCount,Long shouldCount){
        ModelAndView modelAndView = new ModelAndView("teacher/tea_homeWorkDetail");
        modelAndView.addObject("homeWork",homeWorkDTO);
        modelAndView.addObject("hasCount",hasCount);
        modelAndView.addObject("shouldCount",shouldCount);
        return modelAndView;
    }


    @RequestMapping(value = "/settingScore",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject settingScoreAndRemark(HomeWorkTeacherStudentDTO homeWorkTeacherStudentDTO){
        if(homeWorkTeacherStudentDTO.getId()==null)return fail4Param("参数错误");
        boolean flag = teacherHomeworkReceivedService.updateHomeworkStudentTeacher(homeWorkTeacherStudentDTO);
        if(!flag)return fail(401,"评分失败");
        return success("评分成功");
    }
}

