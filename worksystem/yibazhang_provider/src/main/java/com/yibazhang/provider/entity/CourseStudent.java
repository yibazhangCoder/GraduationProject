package com.yibazhang.provider.entity;

import java.io.Serializable;

public class CourseStudent implements Serializable {
    private Integer id;

    private Integer sId;

    private Integer crId;

    private Integer selectStatus;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public Integer getCrId() {
        return crId;
    }

    public void setCrId(Integer crId) {
        this.crId = crId;
    }

    public Integer getSelectStatus() {
        return selectStatus;
    }

    public void setSelectStatus(Integer selectStatus) {
        this.selectStatus = selectStatus;
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
        CourseStudent other = (CourseStudent) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getsId() == null ? other.getsId() == null : this.getsId().equals(other.getsId()))
            && (this.getCrId() == null ? other.getCrId() == null : this.getCrId().equals(other.getCrId()))
            && (this.getSelectStatus() == null ? other.getSelectStatus() == null : this.getSelectStatus().equals(other.getSelectStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getsId() == null) ? 0 : getsId().hashCode());
        result = prime * result + ((getCrId() == null) ? 0 : getCrId().hashCode());
        result = prime * result + ((getSelectStatus() == null) ? 0 : getSelectStatus().hashCode());
        return result;
    }
}