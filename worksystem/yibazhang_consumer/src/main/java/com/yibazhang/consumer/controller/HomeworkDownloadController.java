package com.yibazhang.consumer.controller;

import com.yibazhang.api.bean.sys.UserDTO;
import com.yibazhang.consumer.common.BaseController;
import com.yibazhang.consumer.service.HomeWorkService;
import com.yibazhang.consumer.utils.FolderCreateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @Author 一巴掌
 * @Date 2019/3/25 14:35
 * @Description TODO
 * @Version 1.0
 **/
@Controller
public class HomeworkDownloadController extends BaseController {

    Logger logger = LoggerFactory.getLogger(HomeworkDownloadController.class);


    @Autowired
    HomeWorkService homeWorkService;

    /**
     * 文件下载
     * @param request
     * @param response
     * @param ids    文件唯一id
     * @param type   0：单文件下载   1：多文件打包下载
     */
    @GetMapping("/download")
    public void homeworkDownload(HttpServletRequest request,
                                 HttpServletResponse response,
                                 @RequestParam(required = false,value = "ids[]") List<Long> ids,
                                 @RequestParam(value = "hId")Long hId,
                                 Integer type,
                                 Integer again){
       if(hId==null&&ids==null)return;
       if(type==null)return;
        UserDTO userDTO = (UserDTO) request.getSession().getAttribute("userInfo");
        Map<String,Object> map = new HashMap<>();
        if(ids!=null)map.put("ids",ids);
        if(hId!=null){
            List<Long> list = new ArrayList<>();
            list.add(hId);
            map.put("ids",list);
        }
        map.put("sId",userDTO.getUserId());
        map.put("hStatusStu",0);
        List<Map<String,Object>> res = homeWorkService.getDownloadFiles(map,userDTO.getUserRoleId());
        if(res.isEmpty()){
            return;
        }
        try{
            if(type==0){
                    downloadSingle(response,res.get(0).get("path").toString()+res.get(0).get("uuidName").toString(),res.get(0).get("realName").toString());
            }else if(type ==1){
                    downloadMany(response,res);
            }

            int x=0;
            if(again==null) x = homeWorkService.updateHomeworkStatusBatch(map,userDTO.getUserRoleId());
            if(x>0) logger.info("Download the song successfully!");
            else logger.error("状态更新失败！");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /***
     *
     * @param response
     * @param path
     * @param fileName
     */
    private void downloadSingle(HttpServletResponse response,String path,String fileName) throws UnsupportedEncodingException {
        if(fileName!=null){
            File file = new File(path);
            if(file.exists()){
               logger.info("file is exists,you can download!");
                // 配置文件下载
                response.setHeader("content-type", "application/octet-stream");
                response.setContentType("application/octet-stream");
                String suffix =file.getName().substring(file.getName().lastIndexOf("."));
                // 下载文件能正常显示中文
                response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName+suffix, "UTF-8"));

                // 实现文件下载
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    logger.info("Download successfully!");
                }
                catch (Exception e) {
                    logger.error("Download the song failed!");
                }
                finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }else{
                logger.error("file is not exists,please connection admin!");
            }
        }
    }


    /**
     * path  是文件的临时储存目录
     * @param response
     * @return
     */
    private void downloadMany(HttpServletResponse response,List<Map<String,Object>> list) throws FileNotFoundException, UnsupportedEncodingException {

        //打包后的zip目录名称
        SimpleDateFormat formatter  = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
        String zipFileName = formatter.format(new Date())+".zip";
        File path = new File(ResourceUtils.getURL("classpath:").getPath());
        File upload = new File(path.getAbsolutePath(),"static/upload/");
        String strZipPath = FolderCreateUtils.createFolder(upload.getAbsolutePath(),8) +"\\"+zipFileName;

        ZipOutputStream zipStream = null;
        FileInputStream zipSource = null;
        BufferedInputStream bufferStream = null;
        File zipFile = new File(strZipPath);

        try {
            zipStream = new ZipOutputStream(new FileOutputStream(zipFile));
            for (int i = 0; i <list.size() ; i++) {
                String realFileName =  list.get(i).get("path").toString();
                String realFilePath = list.get(i).get("realName").toString();
                File file = new File(realFilePath);
                if(file.exists()){
                    zipSource = new FileInputStream(file);//将需要压缩的文件格式化为输入流
                    ZipEntry zipEntry = new ZipEntry(realFileName);//在压缩目录中文件的名字
                    zipStream.putNextEntry(zipEntry);//定位该压缩条目位置，开始写入文件到压缩包中
                    bufferStream = new BufferedInputStream(zipSource, 1024 * 10);
                    int read = 0;
                    byte[] buf = new byte[1024 * 10];
                    while((read = bufferStream.read(buf, 0, 1024 * 10)) != -1)
                    {
                        zipStream.write(buf, 0, read);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //关闭流
            try {
                if(null != bufferStream) bufferStream.close();
                if(null != zipStream){
                    zipStream.flush();
                    zipStream.close();
                }
                if(null != zipSource) zipSource.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(zipFile.exists()){
            downloadSingle(response,zipFileName,strZipPath);
            zipFile.delete();
        }
    }
}
