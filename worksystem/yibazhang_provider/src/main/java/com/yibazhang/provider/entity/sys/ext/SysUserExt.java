package com.yibazhang.provider.entity.sys.ext;

import java.io.Serializable;

/**
 * @Author 一巴掌
 * @Date 2019/2/7 13:09
 * @Description TODO
 * @Version 1.0
 **/
public class SysUserExt implements Serializable {
    private Integer userId;

    private Integer userRoleId;

    private String userName;

    private String userRoleName;

    private String password;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserRoleName() {
        return userRoleName;
    }

    public void setUserRoleName(String userRoleName) {
        this.userRoleName = userRoleName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
