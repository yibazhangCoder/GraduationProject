package com.yibazhang.consumer.utils;

import com.alibaba.fastjson.JSON;

public class EnclosureJsonData {

	//将数据转换成layui要求的格式
	public static String getJSONData(Long count,Object data) {
		//这里转换日期格式为yyyy-MM-dd
		String js = JSON.toJSONStringWithDateFormat(data,"yyyy-MM-dd  HH:mm:ss");
		String result = "{\"code\":0,\"msg\":\"\",\"count\":"+count+",\"data\":"+js+"}";
		return result;
	}
	

	
}
