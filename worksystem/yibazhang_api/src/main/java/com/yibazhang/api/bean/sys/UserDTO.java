package com.yibazhang.api.bean.sys;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Author 一巴掌
 * @Date 2019/2/6 20:42
 * @Description TODO
 * @Version 1.0
 **/
@Setter
@Getter
public class UserDTO implements Serializable {

    private Integer userId;

    private Integer userRoleId;

    private String userName;

    private String userRoleName;

    private String password;

    private boolean admin;

    private boolean teacher;

    private boolean student;
}
