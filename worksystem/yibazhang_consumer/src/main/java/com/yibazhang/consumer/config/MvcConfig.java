package com.yibazhang.consumer.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.yibazhang.consumer.compoent.DateConverter;
import com.yibazhang.consumer.compoent.LoginHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.List;

/**
 * @Author 一巴掌
 * @Date 2019/2/13 12:57
 * @Description TODO
 * @Version 1.0
 **/
@Order(0)
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


        registry.addViewController("/error").setViewName("common/error");
        registry.addViewController("/success").setViewName("common/success");
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new DateConverter());
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        MappingJackson2HttpMessageConverter jackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addSerializer(BigInteger.class,ToStringSerializer.instance);
        simpleModule.addSerializer(Long.class, ToStringSerializer.instance);
        simpleModule.addSerializer(Long.TYPE, ToStringSerializer.instance);
        objectMapper.registerModule(simpleModule);
        jackson2HttpMessageConverter.setObjectMapper(objectMapper);
        converters.add(jackson2HttpMessageConverter);
        converters.add(new StringHttpMessageConverter(Charset.forName("UTF-8")));
    }
}
