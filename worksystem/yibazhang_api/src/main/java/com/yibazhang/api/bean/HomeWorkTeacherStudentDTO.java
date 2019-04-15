package com.yibazhang.api.bean;

import com.yibazhang.api.common.BaseDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HomeWorkTeacherStudentDTO extends BaseDTO {
    private Integer id;

    private Integer tId;

    private Long hId;

    private Integer sId;

    private Integer isReceived;

    private String tRemark;

    private Double sScore;

    private Integer commitedIsNew;

    private String sName;

    private String hName;

    private String path;




}