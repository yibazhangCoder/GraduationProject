package com.yibazhang.api.bean;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class ProfessionDTO implements Serializable {
    private Integer professionId;

    private String professionName;

    private Integer professionAca;

}