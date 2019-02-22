package com.yibazhang.consumer.config;

import com.yibazhang.consumer.compoent.LoginHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
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
                .excludePathPatterns("/","/sys/userLogin","/index.html","/sys/userRegister");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index.html").setViewName("login");
        registry.addViewController("/success.html").setViewName("main");

        //路由配置
        registry.addViewController("/admin/AcaManage").setViewName("admin/InfoManage/AcaInfoAdd");
    }

}
