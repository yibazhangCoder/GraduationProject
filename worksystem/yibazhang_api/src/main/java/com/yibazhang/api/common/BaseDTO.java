package com.yibazhang.api.common;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Author 一巴掌
 * @Date 2019/2/22 17:14
 * @Description TODO
 * @Version 1.0
 **/
@Getter
@Setter
public class BaseDTO implements Serializable {
    private Integer selType;

    private String selVal;

    private Integer page;

    private Integer limit;

}
