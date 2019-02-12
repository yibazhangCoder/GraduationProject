package com.yibazhang.api.bean;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class Student implements Serializable {
    private Integer sId;

    private Integer sAge;

    private String sName;

    private String sSex;

    private String sMobile;

    private String sEmail;

    private Integer sAca;

    private Integer sProfession;

    private Integer sClass;
}