package com.yibazhang.api.bean;

import com.yibazhang.api.common.BaseDTO;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TeacherDTO extends BaseDTO {
    private Integer tId;

    private String tName;

    private String tSex;

    private String tMobile;

    private String tEmail;

    private Integer tAca;

    private String acaName;

}