package com.yibazhang.api.bean;

import com.yibazhang.api.common.BaseDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author 一巴掌
 * @Date 2019/4/1 16:15
 * @Description TODO
 * @Version 1.0
 **/
@Getter
@Setter
public class HomeworkToTeacherDTO extends BaseDTO {
    private Integer id;

    private Integer tId;

    private Long hId;

    private Integer sId;

    private Integer isReceived;

    private String tRemark;

    private Double sScore;

    private String hName;
}
