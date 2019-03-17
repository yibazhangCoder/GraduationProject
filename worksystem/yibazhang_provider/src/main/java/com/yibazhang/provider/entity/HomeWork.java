package com.yibazhang.provider.entity;

import java.io.Serializable;
import java.util.Date;

public class HomeWork implements Serializable {
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

    private static final long serialVersionUID = 1L;

    public Long gethId() {
        return hId;
    }

    public void sethId(Long hId) {
        this.hId = hId;
    }

    public String gethUuidname() {
        return hUuidname;
    }

    public void sethUuidname(String hUuidname) {
        this.hUuidname = hUuidname == null ? null : hUuidname.trim();
    }

    public String gethRealname() {
        return hRealname;
    }

    public void sethRealname(String hRealname) {
        this.hRealname = hRealname == null ? null : hRealname.trim();
    }

    public String gethPath() {
        return hPath;
    }

    public void sethPath(String hPath) {
        this.hPath = hPath == null ? null : hPath.trim();
    }

    public Integer gethClass() {
        return hClass;
    }

    public void sethClass(Integer hClass) {
        this.hClass = hClass;
    }

    public Integer gethCourse() {
        return hCourse;
    }

    public void sethCourse(Integer hCourse) {
        this.hCourse = hCourse;
    }

    public Integer gethUper() {
        return hUper;
    }

    public void sethUper(Integer hUper) {
        this.hUper = hUper;
    }

    public Date gethUptime() {
        return hUptime;
    }

    public void sethUptime(Date hUptime) {
        this.hUptime = hUptime;
    }

    public Date gethStarttime() {
        return hStarttime;
    }

    public void sethStarttime(Date hStarttime) {
        this.hStarttime = hStarttime;
    }

    public Date gethEndtime() {
        return hEndtime;
    }

    public void sethEndtime(Date hEndtime) {
        this.hEndtime = hEndtime;
    }

    public Date gethDeltime() {
        return hDeltime;
    }

    public void sethDeltime(Date hDeltime) {
        this.hDeltime = hDeltime;
    }

    public Integer gethStatus() {
        return hStatus;
    }

    public void sethStatus(Integer hStatus) {
        this.hStatus = hStatus;
    }

    public String gethComment() {
        return hComment;
    }

    public void sethComment(String hComment) {
        this.hComment = hComment == null ? null : hComment.trim();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        HomeWork other = (HomeWork) that;
        return (this.gethId() == null ? other.gethId() == null : this.gethId().equals(other.gethId()))
            && (this.gethUuidname() == null ? other.gethUuidname() == null : this.gethUuidname().equals(other.gethUuidname()))
            && (this.gethRealname() == null ? other.gethRealname() == null : this.gethRealname().equals(other.gethRealname()))
            && (this.gethPath() == null ? other.gethPath() == null : this.gethPath().equals(other.gethPath()))
            && (this.gethClass() == null ? other.gethClass() == null : this.gethClass().equals(other.gethClass()))
            && (this.gethCourse() == null ? other.gethCourse() == null : this.gethCourse().equals(other.gethCourse()))
            && (this.gethUper() == null ? other.gethUper() == null : this.gethUper().equals(other.gethUper()))
            && (this.gethUptime() == null ? other.gethUptime() == null : this.gethUptime().equals(other.gethUptime()))
            && (this.gethStarttime() == null ? other.gethStarttime() == null : this.gethStarttime().equals(other.gethStarttime()))
            && (this.gethEndtime() == null ? other.gethEndtime() == null : this.gethEndtime().equals(other.gethEndtime()))
            && (this.gethDeltime() == null ? other.gethDeltime() == null : this.gethDeltime().equals(other.gethDeltime()))
            && (this.gethStatus() == null ? other.gethStatus() == null : this.gethStatus().equals(other.gethStatus()))
            && (this.gethComment() == null ? other.gethComment() == null : this.gethComment().equals(other.gethComment()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((gethId() == null) ? 0 : gethId().hashCode());
        result = prime * result + ((gethUuidname() == null) ? 0 : gethUuidname().hashCode());
        result = prime * result + ((gethRealname() == null) ? 0 : gethRealname().hashCode());
        result = prime * result + ((gethPath() == null) ? 0 : gethPath().hashCode());
        result = prime * result + ((gethClass() == null) ? 0 : gethClass().hashCode());
        result = prime * result + ((gethCourse() == null) ? 0 : gethCourse().hashCode());
        result = prime * result + ((gethUper() == null) ? 0 : gethUper().hashCode());
        result = prime * result + ((gethUptime() == null) ? 0 : gethUptime().hashCode());
        result = prime * result + ((gethStarttime() == null) ? 0 : gethStarttime().hashCode());
        result = prime * result + ((gethEndtime() == null) ? 0 : gethEndtime().hashCode());
        result = prime * result + ((gethDeltime() == null) ? 0 : gethDeltime().hashCode());
        result = prime * result + ((gethStatus() == null) ? 0 : gethStatus().hashCode());
        result = prime * result + ((gethComment() == null) ? 0 : gethComment().hashCode());
        return result;
    }
}