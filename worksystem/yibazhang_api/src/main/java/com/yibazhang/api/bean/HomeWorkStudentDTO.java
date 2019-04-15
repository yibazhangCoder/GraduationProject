package com.yibazhang.api.bean;

import com.yibazhang.api.common.BaseDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class HomeWorkStudentDTO extends BaseDTO {

    private Integer sId;

    private Long hId;

    private Integer hStatusStu;

    private Integer releaseIsNew;

}