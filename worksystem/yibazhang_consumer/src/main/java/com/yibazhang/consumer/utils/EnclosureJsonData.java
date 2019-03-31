package com.yibazhang.consumer.utils;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EnclosureJsonData {

	static Logger logger = LoggerFactory.getLogger(EnclosureJsonData.class);
	//将数据转换成layui要求的格式
	public static String getJSONData(Long count,Object data) {
		//这里转换日期格式为yyyy-MM-dd
		String js = JSON.toJSONStringWithDateFormat(data,"yyyy-MM-dd  HH:mm:ss");
		String result = "{\"code\":0,\"msg\":\"\",\"count\":"+count+",\"data\":"+js+"}";
		logger.info(result);
		return result;
	}
	

	
}
