package com.yibazhang.consumer.common;

public enum ExpCode {
    /**
     * 正常返回
     */
    SUCCESS(200,"成功"),
    /**
     * 参数不符合校验规则的错误
     */
    PARAMETER_ERROR(100,"参数校验错误"),
    /**
     * 业务逻辑处理失败
     */
    SERVICE_ERROR(110,"逻辑操作错误"),

    /**
     * 用于检查用户数据权限
     */
    AUTH_ERROR(120,"权限不足错误"),

    /**
     * 请求超时
     */
    REQ_TIMEOUT(130,"请求超时"),

    /**
     * 用于检查用户数据权限
     */
    TOKEN_ERROR(140,"信息已失效，请重新登录"),

    /**
     * 用于检测设备是否是最新登录设备
     */
    DEVICE_ERROR(150,"设备登录异常，请重新登录"),

    /**
     * 用于检测设备是否是最新登录设备
     */
    SIGN_ERROR(160,"数字签名异常"),

    /**
     * 未知的程序异常,无需抛出
     */
    APPLICATION_ERROR(500,"请求迷路啦，程序员已经去寻找了！");


    int code;
    String msg;

    ExpCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
