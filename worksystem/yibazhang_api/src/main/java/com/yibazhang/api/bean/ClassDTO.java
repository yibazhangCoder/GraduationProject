package com.yibazhang.api.bean;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class ClassDTO implements Serializable {
    private Integer cId;

    private String cName;

    private Integer cProfession;

    private Integer cAca;

}