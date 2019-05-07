package com.yibazhang.api.bean;

import com.yibazhang.api.common.BaseDTO;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class Student extends BaseDTO {
    private Integer sId;

    private Integer sAge;

    private String sName;

    private String sSex;

    private String sMobile;

    private String sEmail;

    private Integer sAca;

    private Integer sProfession;

    private Integer sClass;

    private String acaName;

    private String professionName;
}