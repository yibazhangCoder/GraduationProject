package com.yibazhang.provider.common;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Author 一巴掌
 * @Date 2019/2/22 16:44
 * @Description TODO
 * @Version 1.0
 **/
@Setter
@Getter
public class BaseExt implements Serializable {
    Integer selType;

    String selVal;
}
