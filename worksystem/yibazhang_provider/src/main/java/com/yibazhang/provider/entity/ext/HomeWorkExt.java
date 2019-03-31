package com.yibazhang.provider.entity.ext;

import com.yibazhang.provider.common.BaseExt;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @Author 一巴掌
 * @Date 2019/3/15 16:17
 * @Description TODO
 * @Version 1.0
 **/
@Getter
@Setter
public class HomeWorkExt extends BaseExt {

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

    private Integer crId;

    private String crName;

    private String tName;

    private Integer sId;
}
