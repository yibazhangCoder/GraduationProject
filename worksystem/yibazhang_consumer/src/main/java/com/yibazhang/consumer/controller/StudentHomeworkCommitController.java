package com.yibazhang.consumer.controller;

import com.alibaba.fastjson.JSONObject;
import com.yibazhang.api.bean.HomeWorkStudentDTO;
import com.yibazhang.api.bean.HomeworkToTeacherDTO;
import com.yibazhang.api.bean.StudentCommitHomeworkDTO;
import com.yibazhang.api.bean.sys.UserDTO;
import com.yibazhang.consumer.common.BaseController;
import com.yibazhang.consumer.service.HomeWorkService;
import com.yibazhang.consumer.service.StudentCommitHomeworkService;
import com.yibazhang.consumer.utils.DateUtils;
import com.yibazhang.consumer.utils.FolderCreateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * @Author 一巴掌
 * @Date 2019/4/1 16:30
 * @Description TODO
 * @Version 1.0
 **/
@Controller
@RequestMapping("/studentCommit")
public class StudentHomeworkCommitController extends BaseController {

    @Autowired
    StudentCommitHomeworkService studentCommitHomeworkService;

    @Autowired
    HomeWorkService homeWorkService;


    @RequestMapping("/toPage")
    public ModelAndView toSubmitPage(@RequestParam(value = "hId")Long hId,
                                     @RequestParam(value = "hUper")Integer hUper,
                                     @RequestParam(value = "hName")String hName,
                                     @RequestParam(value = "crId")Integer crId,
                                     @RequestParam(value = "crName")String crName,
                                     @RequestParam(value = "hEndtime")Long hEndtime){
        ModelAndView modelAndView = new ModelAndView("student/stu_homeWorkUp");
        modelAndView.addObject("hId",hId);
        modelAndView.addObject("tId",hUper);
        modelAndView.addObject("hName",hName);
        modelAndView.addObject("crId",crId);
        modelAndView.addObject("crName",crName);
        Integer i=0;
        if(DateUtils.getDate().getTime()>hEndtime)i=1;
        modelAndView.addObject("hEndtime",i);

        return modelAndView;
    }



    @RequestMapping("/stuFileUpload")
    @ResponseBody
    public JSONObject studentHomeworkUpload(MultipartFile file, HomeworkToTeacherDTO homeworkToTeacherDTO, HttpServletRequest request){
        UserDTO u = (UserDTO) request.getSession().getAttribute("userInfo");
        String path = FolderCreateUtils.createFolder(FolderCreateUtils.getRootPath(),u.getUserRoleId());
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        String fileName= file.getOriginalFilename().substring(0,file.getOriginalFilename().lastIndexOf("."));
        String hName = homeworkToTeacherDTO.getHName();
        if(!hName.trim().equals(fileName.trim()))
            return fail(401,"请保证上传文件名和作业名称一致！傻x");
        String uuidName = UUID.randomUUID()+suffix;
        try {
            file.transferTo(new File(path+uuidName));
            StudentCommitHomeworkDTO studentCommitHomeworkDTO = new StudentCommitHomeworkDTO();
            studentCommitHomeworkDTO.setHId(homeworkToTeacherDTO.getHId());
            studentCommitHomeworkDTO.setSId(homeworkToTeacherDTO.getSId());
            studentCommitHomeworkDTO.setCommitedTime(DateUtils.getDate());
            studentCommitHomeworkDTO.setStudentHomeworkPath(path);
            studentCommitHomeworkDTO.setStudentHomeworkName(uuidName);
            studentCommitHomeworkDTO.setStudentHomeworkStatus(1);//设置当前作业为最新保存的
            Boolean flag = studentCommitHomeworkService.saveStudentCommitHomework(studentCommitHomeworkDTO);
            if(!flag)return fail(401,"保存失败！");
            homeworkToTeacherDTO.setCommitedIsNew(1);//设置当前作业为最新提交的
            Boolean flag1= studentCommitHomeworkService.insertHomeworkToTeacher(homeworkToTeacherDTO);
            if(!flag1)return fail(401,"提交失败！");
            HomeWorkStudentDTO homeWorkStudentDTO = new HomeWorkStudentDTO();
            homeWorkStudentDTO.setHId(homeworkToTeacherDTO.getHId());
            homeWorkStudentDTO.setSId(homeworkToTeacherDTO.getSId());
            homeWorkStudentDTO.setHStatusStu(2);
            boolean flag2 = studentCommitHomeworkService.updateStudentHomeworkStatus(homeWorkStudentDTO);
            if(!flag2)return fail(401,"状态更新失败！");
        } catch (IOException e) {
            e.printStackTrace();
            return fail(401,"上传失败！");
        }

        return success();
    }
}
