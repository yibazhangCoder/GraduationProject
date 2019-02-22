package com.yibazhang.provider.entity;

import java.io.Serializable;

public class Course implements Serializable {
    private Integer crId;

    private String crName;

    private Integer crAca;

    private static final long serialVersionUID = 1L;

    public Integer getCrId() {
        return crId;
    }

    public void setCrId(Integer crId) {
        this.crId = crId;
    }

    public String getCrName() {
        return crName;
    }

    public void setCrName(String crName) {
        this.crName = crName == null ? null : crName.trim();
    }

    public Integer getCrAca() {
        return crAca;
    }

    public void setCrAca(Integer crAca) {
        this.crAca = crAca;
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
        Course other = (Course) that;
        return (this.getCrId() == null ? other.getCrId() == null : this.getCrId().equals(other.getCrId()))
            && (this.getCrName() == null ? other.getCrName() == null : this.getCrName().equals(other.getCrName()))
            && (this.getCrAca() == null ? other.getCrAca() == null : this.getCrAca().equals(other.getCrAca()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCrId() == null) ? 0 : getCrId().hashCode());
        result = prime * result + ((getCrName() == null) ? 0 : getCrName().hashCode());
        result = prime * result + ((getCrAca() == null) ? 0 : getCrAca().hashCode());
        return result;
    }
}