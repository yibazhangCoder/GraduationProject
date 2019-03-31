package com.yibazhang.consumer.compoent;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author 一巴掌
 * @Date 2019/3/13 14:31
 * @Description TODO
 * @Version 1.0
 **/
@Slf4j
public class DateConverter implements Converter<String, Date> {
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public Date convert(String s) {
        if("".equals(s)||null==s)return null;
        try {
            return simpleDateFormat.parse(s);
        } catch (ParseException e) {
            log.error("绑定日期参数转化异常！");
            e.printStackTrace();
        }
        return null;
    }
}
