package com.yibazhang.provider.entity.ext;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Author 一巴掌
 * @Date 2019/2/21 11:01
 * @Description TODO
 * @Version 1.0
 **/

@Setter
@Getter
public class AcaAndProAndClassExt implements Serializable {

    private Integer acaId;

    private String acaName;

    private Integer professionId;

    private String professionName;

    private Integer cId;

    private String cName;

    private Integer selType;

    private String selVal;
}
