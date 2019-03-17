package com.yibazhang.consumer.queryVO;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author 一巴掌
 * @Date 2019/3/13 13:57
 * @Description TODO
 * @Version 1.0
 **/
@Setter
@Getter
public class UpLoadFileVO implements Serializable {
    private String crName;

    private Integer crId;

    private String hName;

    private Date startTime;

    private Date endTime;

    private Integer acaId;

    private Integer professionId;

    private String comments;

    @Override
    public String toString() {
        return "UpLoadFileVO{" +
                "crName='" + crName + '\'' +
                ", crId=" + crId +
                ", hName='" + hName + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", acaId=" + acaId +
                ", professionId=" + professionId +
                ", comments='" + comments + '\'' +
                '}';
    }
}

