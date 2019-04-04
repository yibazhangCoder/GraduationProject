package com.yibazhang.api.bean;

import com.yibazhang.api.common.BaseDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @Author 一巴掌
 * @Date 2019/4/1 16:14
 * @Description TODO
 * @Version 1.0
 **/
@Getter
@Setter
public class StudentCommitHomeworkDTO extends BaseDTO {
    private Integer id;

    private Long hId;

    private Integer sId;

    private String sName;

    private String studentHomeworkPath;

    private String studentHomeworkName;

    private Date commitedTime;

    private Date receiveTime;

    private Integer difficult;

    private Date useTime;

    private Integer pleasured;

    private Integer studentHomeworkStatus;

}
