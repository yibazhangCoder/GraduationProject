package com.yibazhang.consumer.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author 一巴掌
 * @Date 2019/3/10 9:24
 * @Description TODO
 * @Version 1.0
 **/
public class FolderCreateUtils {

    public static void createFolder(String des){
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy");
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM");
        String first = des+"/"+ format.format(date);
        String second = first + "/"+format1.format(date);
        File firstFile = new File(first);
        File secondFile = new File(second);
        while(!secondFile.exists()){
            if(!firstFile.exists())firstFile.mkdirs();
            else secondFile.mkdirs();
        }
    }

    public static void main(String[] args) {
        createFolder("I:");
    }
}
