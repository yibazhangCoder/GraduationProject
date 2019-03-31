package com.yibazhang.consumer.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * @Author 一巴掌
 * @Date 2019/3/10 9:24
 * @Description TODO
 * @Version 1.0
 **/
public class FolderCreateUtils {

    public static String createFolder(String des,int roleId){
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy");
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM");
        String first = des+"/"+ format.format(date);
        String second = "";
        if(roleId==2){
            second = first + "/teacher/"+format1.format(date);
        }else if(roleId==1){
            second = first + "/student/"+format1.format(date);
        }else{
            second = first+"/temp";
        }
        File firstFile = new File(first);
        File secondFile = new File(second);
        while(!secondFile.exists()){
            if(!firstFile.exists())firstFile.mkdirs();
            else secondFile.mkdirs();
        }

        return second+"/";
    }

    public static void main(String[] args) {
//        LocalDateTime localDateTime = LocalDateTime.now();
//        Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
//        Date date = Date.from(instant);
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        System.out.println(simpleDateFormat.format(date));
        String path = "C:\\Users\\一巴掌\\Desktop\\毕业设计\\project\\GraduationProject\\worksystem\\static\\upload/2019/teacher/2019-03/";
        String fileName = "85d9176b-baa6-4ed0-ae44-cd48a198f51e.docx";
        File file = new File(path+fileName);
//        if(file.isFile()){
//            System.out.println(file.getAbsolutePath());
//            System.out.println("this is file!");
//        }
//        if(file.exists()){
//            System.out.println("file is exists!");
//        }
        System.out.println(file.getName().substring(file.getName().lastIndexOf(".")));
    }
}
