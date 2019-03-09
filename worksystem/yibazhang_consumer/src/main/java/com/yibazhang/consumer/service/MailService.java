package com.yibazhang.consumer.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yibazhang.api.service.MailApi;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @Author 一巴掌
 * @Date 2019/3/4 21:53
 * @Description TODO
 * @Version 1.0
 **/

@Service
public class MailService {

    @Reference(version = "${yibazhang.service.version}",timeout = 5000)
    MailApi mailApi;

    public String getCheckCode(String email){
        String checkCode = String.valueOf(new Random().nextInt(899999) + 100000);
        String message = "您的验证码为："+checkCode;
        try {
            mailApi.sendMail(email, "【作业系统验证码："+checkCode+"】", message);
        }catch (Exception e){
            return "";
        }

        return checkCode;
    }
}
