package com.yibazhang.api.bean;

import com.yibazhang.api.common.BaseDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author 一巴掌
 * @Date 2019/2/22 21:28
 * @Description TODO
 * @Version 1.0
 **/
@Getter
@Setter
public class CourseDTO extends BaseDTO {
    private Integer crId;

    private String crName;

    private Integer crAca;
}
