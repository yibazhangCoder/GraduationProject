package com.yibazhang.consumer.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yibazhang.api.bean.HomeWorkDTO;
import com.yibazhang.api.bean.sys.UserDTO;
import com.yibazhang.consumer.common.BaseController;
import com.yibazhang.consumer.service.HomeWorkService;
import com.yibazhang.consumer.utils.DateUtils;
import com.yibazhang.consumer.utils.EnclosureJsonData;
import com.yibazhang.consumer.utils.FolderCreateUtils;
import com.yibazhang.consumer.utils.IdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

/**
 * @Author 一巴掌
 * @Date 2019/3/13 14:39
 * @Description TODO
 * @Version 1.0
 **/
@Controller
@RequestMapping("/homework")
public class HomeWorkController extends BaseController {


    @Autowired
    HomeWorkService homeWorkService;


    @RequestMapping("/teaFileUpload")
    @ResponseBody
    public JSONObject upLoadFile(HomeWorkDTO homeWorkDTO, MultipartFile[] file, HttpServletRequest request){
        try {
           UserDTO userDTO = (UserDTO) request.getSession().getAttribute("userInfo");
           String uploadDir = FolderCreateUtils.getRootPath();
           String path = FolderCreateUtils.createFolder(uploadDir,userDTO.getUserRoleId());
           for (MultipartFile f:
                   file) {
               // 文件后缀名
               String suffix = f.getOriginalFilename().substring(f.getOriginalFilename().lastIndexOf("."));
               // 上传文件名 - UUID
               String filename = UUID.randomUUID() + suffix;
               homeWorkDTO.setHId(IdUtils.make());
               homeWorkDTO.setHUuidname(filename);
               homeWorkDTO.setHRealname(f.getOriginalFilename().substring(0,f.getOriginalFilename().lastIndexOf(".")));
               homeWorkDTO.setHPath(path);
               homeWorkDTO.setHUper(userDTO.getUserId());
               homeWorkDTO.setHUptime(DateUtils.getDate());
               homeWorkDTO.setHStatus(0);
               executeUpload(path,f,filename);
               boolean flag = homeWorkService.saveHomework(homeWorkDTO);
               if(flag){
                   int j =homeWorkService.insertHomeworkToStudent(homeWorkDTO);
                   if(j==100)return fail(401,"该专业无学生！请联系管理员添加学生后重新发放！");
                   if(j==101)return fail(401,"暂无选该课程的学生，请通知相关同学选课后重新发放！");
               }
           }
       }catch (IOException e){
           e.printStackTrace();
           return fail(408,"上传失败");
       }

        return success("上传成功");
    }



    @RequestMapping("/teaSelectHomeWork")
    @ResponseBody
    public JSONObject selectHomeworkOfTeacher(HomeWorkDTO homeWorkDTO,HttpServletRequest request){
        UserDTO userDTO = (UserDTO) request.getSession().getAttribute("userInfo");
        JSONObject jsonObject = new JSONObject();
        homeWorkDTO.setHUper(userDTO.getUserId());
        if(homeWorkDTO.getPage()==null)homeWorkDTO.setPage(1);
        if(homeWorkDTO.getLimit()==null)homeWorkDTO.setLimit(5);
        if(homeWorkDTO.getSelType()!=null&&!"".equals(homeWorkDTO.getSelVal())){
            if(homeWorkDTO.getSelType()==0)homeWorkDTO.setHId((Long.parseLong( homeWorkDTO.getSelVal())));
            if(homeWorkDTO.getSelType()==1)homeWorkDTO.setHRealname(homeWorkDTO.getSelVal());
            if(homeWorkDTO.getSelType()==2)homeWorkDTO.setCrId(Integer.parseInt(homeWorkDTO.getSelVal()));
            if(homeWorkDTO.getSelType()==3)homeWorkDTO.setCrName(homeWorkDTO.getSelVal());
        }
        PageHelper.startPage(homeWorkDTO.getPage(),homeWorkDTO.getLimit());
        PageInfo<Map<String,Object>> pageInfo = new PageInfo<>(homeWorkService.selectHomeworkOfTeacher(homeWorkDTO),5);
        jsonObject.put("code",0);
        jsonObject.put("count",pageInfo.getTotal());
        jsonObject.put("data",pageInfo.getList());
        return success(jsonObject);
    }


    @RequestMapping("/stuSelectHomework")
    @ResponseBody
    public JSONObject selectHomeworkOfStudent(HomeWorkDTO homeWorkDTO,HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        UserDTO userDTO = (UserDTO) request.getSession().getAttribute("userInfo");
        homeWorkDTO.setSId(userDTO.getUserId());
        if(homeWorkDTO.getPage()==null)homeWorkDTO.setPage(1);
        if(homeWorkDTO.getLimit()==null)homeWorkDTO.setLimit(5);
        if(homeWorkDTO.getSelType()!=null&&!"".equals(homeWorkDTO.getSelVal())){
            if(homeWorkDTO.getSelType()==0)homeWorkDTO.setHId((Long.parseLong( homeWorkDTO.getSelVal())));
            if(homeWorkDTO.getSelType()==1)homeWorkDTO.setHRealname(homeWorkDTO.getSelVal());
            if(homeWorkDTO.getSelType()==2)homeWorkDTO.setCrId(Integer.parseInt(homeWorkDTO.getSelVal()));
            if(homeWorkDTO.getSelType()==3)homeWorkDTO.setCrName(homeWorkDTO.getSelVal());
            if(homeWorkDTO.getSelType()==4)homeWorkDTO.setTName(homeWorkDTO.getSelVal());
        }

        PageHelper.startPage(homeWorkDTO.getPage(),homeWorkDTO.getLimit());
        PageInfo<Map<String,Object>> pageInfo = new PageInfo<>(homeWorkService.selectHomeworkOfStudent(homeWorkDTO),5);
        jsonObject.put("code",0);
        jsonObject.put("count",pageInfo.getTotal());
        jsonObject.put("data",pageInfo.getList());
        return success(jsonObject);
    }

    private void executeUpload(String uploadDir, MultipartFile file,String uuidName) throws IOException {
        // 服务器端保存的文件对象
        File serverFile = new File(uploadDir + uuidName);
        // 将上传的文件写入到服务器端文件内
        file.transferTo(serverFile);
    }

}
