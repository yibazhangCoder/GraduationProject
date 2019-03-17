package com.yibazhang.consumer.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * @Author 一巴掌
 * @Date 2019/3/15 16:55
 * @Description TODO
 * @Version 1.0
 **/
public class DateUtils {

    public static Date getDate(){
        LocalDateTime localDateTime = LocalDateTime.now();
        Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
        Date upTime = Date.from(instant);
        return upTime;
    }
}
