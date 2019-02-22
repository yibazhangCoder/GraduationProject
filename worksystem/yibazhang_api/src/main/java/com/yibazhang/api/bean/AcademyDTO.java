package com.yibazhang.api.bean;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Author 一巴掌
 * @Date 2019/2/15 16:34
 * @Description TODO
 * @Version 1.0
 **/
@Setter
@Getter
public class AcademyDTO implements Serializable {
    private Integer acaId;

    private String acaName;

}
