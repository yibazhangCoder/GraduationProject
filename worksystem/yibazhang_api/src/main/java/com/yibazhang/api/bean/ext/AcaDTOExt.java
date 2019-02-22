package com.yibazhang.api.bean.ext;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Author 一巴掌
 * @Date 2019/2/21 11:05
 * @Description TODO
 * @Version 1.0
 **/
@Getter
@Setter
public class AcaDTOExt implements Serializable {
    private Integer acaId;

    private String acaName;

    private Integer professionId;

    private String professionName;

    private Integer cId;

    private String cName;

    private Integer selType;

    private String selVal;

    private Integer page;

    private Integer limit;

    private Integer type;
}
