package com.yibazhang.api.bean;

import com.yibazhang.api.common.BaseDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class HomeWorkDTO extends BaseDTO {

    private Long hId;

    private String hUuidname;

    private String hRealname;

    private String hPath;

    private Integer hClass;

    private Integer hCourse;

    private Integer hUper;

    private Date hUptime;

    private Date hStarttime;

    private Date hEndtime;

    private Date hDeltime;

    private Integer hStatus;

    private String hComment;

    private Integer acaId;

    private Integer professionId;

    private Integer crId;

    private String crName;

    private String tName;

    private Integer sId;


    @Override
    public String toString() {
        return "HomeWorkDTO{" +
                "hUuidname='" + hUuidname + '\'' +
                ", hRealname='" + hRealname + '\'' +
                ", hPath='" + hPath + '\'' +
                ", hClass=" + hClass +
                ", hCourse=" + hCourse +
                ", hUper=" + hUper +
                ", hUptime=" + hUptime +
                ", hStarttime=" + hStarttime +
                ", hEndtime=" + hEndtime +
                ", hDeltime=" + hDeltime +
                ", hStatus=" + hStatus +
                ", hComment='" + hComment + '\'' +
                ", acaId=" + acaId +
                ", professionId=" + professionId +
                '}';
    }
}