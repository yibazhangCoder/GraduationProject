package com.yibazhang.consumer.controller;

import com.alibaba.fastjson.JSONObject;
import com.yibazhang.api.bean.HomeWorkDTO;
import com.yibazhang.api.bean.sys.UserDTO;
import com.yibazhang.consumer.common.BaseController;
import com.yibazhang.consumer.queryVO.UpLoadFileVO;
import com.yibazhang.consumer.service.HomeWorkService;
import com.yibazhang.consumer.utils.DateUtils;
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
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
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
            File path1 = new File(ResourceUtils.getURL("classpath:").getPath());
            if(!path1.exists()) path1 = new File("");
            File upload = new File(path1.getAbsolutePath(),"static/upload/");
            if(!upload.exists()) {
                upload.mkdirs();
            }
           String uploadDir = upload.getAbsolutePath();
           String path = FolderCreateUtils.createFolder(uploadDir,userDTO.getUserRoleId());
           for (MultipartFile f:
                   file) {
               // 文件后缀名
               String suffix = f.getOriginalFilename().substring(f.getOriginalFilename().lastIndexOf("."));
               // 上传文件名 - UUID
               String filename = UUID.randomUUID() + suffix;
               homeWorkDTO.setHId(IdUtils.make());
               homeWorkDTO.setHUuidname(filename);
               homeWorkDTO.setHPath(path);
               homeWorkDTO.setHUper(userDTO.getUserId());
               homeWorkDTO.setHUptime(DateUtils.getDate());
               homeWorkDTO.setHStatus(0);
               executeUpload(path,f,filename);
               boolean flag = homeWorkService.saveHomework(homeWorkDTO);
               if(flag)homeWorkService.insertHomeworkToStudent(homeWorkDTO);
           }
       }catch (Exception e){
           e.printStackTrace();
           return fail(401,"上传失败");
       }

        return success("上传成功");
    }


    private void executeUpload(String uploadDir, MultipartFile file,String uuidName) throws IOException {
        // 服务器端保存的文件对象
        File serverFile = new File(uploadDir + uuidName);
        // 将上传的文件写入到服务器端文件内
        file.transferTo(serverFile);
    }
}
