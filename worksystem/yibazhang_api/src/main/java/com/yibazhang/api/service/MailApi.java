package com.yibazhang.api.service;

/**
 * @Author 一巴掌
 * @Date 2019/3/3 20:54
 * @Description TODO
 * @Version 1.0
 **/
public interface MailApi {
    /**
     * 发送邮件
     * @param to 邮件收件人
     * @param subject 邮件主题
     * @param verifyCode 邮件验证码
     */
     void sendMail(String to, String subject, String verifyCode);

}
