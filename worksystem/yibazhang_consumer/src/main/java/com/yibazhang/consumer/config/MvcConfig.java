package com.yibazhang.consumer.config;

import com.yibazhang.consumer.compoent.DateConverter;
import com.yibazhang.consumer.compoent.LoginHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author 一巴掌
 * @Date 2019/2/13 12:57
 * @Description TODO
 * @Version 1.0
 **/
@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/","/sys/userLogin","/index.html","/sys/userRegister","/toRegister","/toForgetPWD","/sys/forgetPWD")
                .excludePathPatterns("/admin/selectAcaInfo","/mail/getCheckCode")
                .excludePathPatterns("/static/**");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index.html").setViewName("login");
        registry.addViewController("/success.html").setViewName("main");

        //路由配置
        registry.addViewController("/admin/AcaManage").setViewName("admin/InfoManage/AcaInfoAdd");
        registry.addViewController("/admin/teaInfoList").setViewName("admin/InfoManage/TeacherInfoList");
        registry.addViewController("/admin/teaInfoAdd").setViewName("admin/InfoManage/TeacherInfoAdd");
        registry.addViewController("/admin/courseInfoManage").setViewName("admin/InfoManage/CourseInfoManage");
        registry.addViewController("/course/selectCourse").setViewName("course/courseSelect");

        registry.addViewController("/student/hwList").setViewName("student/stu_homeWorkList");
        registry.addViewController("/student/hwAdd").setViewName("student/stu_homeWorkUp");

        registry.addViewController("/teacher/hwList").setViewName("teacher/tea_homeWorkList");
        registry.addViewController("/teacher/hwAdd").setViewName("teacher/tea_homeWorkUp");

        registry.addViewController("/toRegister").setViewName("student/studentRegister");
        registry.addViewController("/toForgetPWD").setViewName("admin/forgetPWD");
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new DateConverter());
    }
}
