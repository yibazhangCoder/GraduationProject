package com.yibazhang.consumer.common;

import com.alibaba.fastjson.JSONObject;

/**
 * @Author 一巴掌
 * @Date 2019/1/28 21:23
 * @Description TODO
 * @Version 1.0
 **/
public class BaseController {
    static String MSG = "msg";
    static String CODE = "code";
    static String DATA = "data";


    private JSONObject init(){
        JSONObject result = new JSONObject();
        result.put(CODE, ExpCode.SUCCESS.getCode());
        result.put(MSG,ExpCode.SUCCESS.getMsg());
        result.put(DATA,null);
        return result;
    }

    protected JSONObject success(String msg,Object javaObject){
        JSONObject result = init();
        result.put(MSG,msg);
        result.put(DATA,JSONObject.toJSON(javaObject));
        return result;
    }


    protected JSONObject success(Object javaObject){
        JSONObject result = init();
        result.put(DATA,JSONObject.toJSON(javaObject));
        return result;
    }

    protected JSONObject success(){
        JSONObject result = init();
        return result;
    }

    protected JSONObject fail(Integer code ,String msg,Object javaObject){
        JSONObject result = init();
        result.put(CODE,code);
        result.put(MSG,msg);
        result.put(DATA,JSONObject.toJSON(javaObject));
        return result;
    }

    protected JSONObject fail(Integer code ,String msg){
        JSONObject result = init();
        result.put(CODE,code);
        result.put(MSG,msg);
        return result;
    }

    protected JSONObject fail4Param(String msg){
        JSONObject result = init();
        result.put(CODE,ExpCode.PARAMETER_ERROR.getCode());
        result.put(MSG,msg);
        return result;
    }

    protected JSONObject fail(Integer code){
        JSONObject result = init();
        result.put(CODE,code);
        return result;
    }

}
