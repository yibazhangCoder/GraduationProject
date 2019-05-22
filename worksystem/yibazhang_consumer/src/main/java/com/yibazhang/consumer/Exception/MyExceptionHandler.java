package com.yibazhang.consumer.Exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author 一巴掌
 * @Date 2019/5/22 20:40
 * @Description TODO
 * @Version 1.0
 **/
public class MyExceptionHandler implements HandlerExceptionResolver {

    Logger logger = LoggerFactory.getLogger(MyExceptionHandler.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        logger.info("try Exception---->"+e);
        httpServletResponse.setCharacterEncoding("UTF-8");
        ModelAndView modelAndView = new ModelAndView("common/error");
        Integer code =0;
        String msg = "";
        if(e instanceof BindException ||e instanceof NumberFormatException){
          code = 405;
          msg  = "请检查输入值是否是正确的字符类型";
        }else {
            code = 500;
            msg  = "服务器错误";
        }
        modelAndView.addObject("code",code);
        modelAndView.addObject("msg",msg);
        return modelAndView;
    }
}
