package com.yibazhang.provider.entity;

import java.io.Serializable;

public class Academy implements Serializable {
    private Integer acaId;

    private String acaName;

    private static final long serialVersionUID = 1L;

    public Integer getAcaId() {
        return acaId;
    }

    public void setAcaId(Integer acaId) {
        this.acaId = acaId;
    }

    public String getAcaName() {
        return acaName;
    }

    public void setAcaName(String acaName) {
        this.acaName = acaName == null ? null : acaName.trim();
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
        Academy other = (Academy) that;
        return (this.getAcaId() == null ? other.getAcaId() == null : this.getAcaId().equals(other.getAcaId()))
            && (this.getAcaName() == null ? other.getAcaName() == null : this.getAcaName().equals(other.getAcaName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAcaId() == null) ? 0 : getAcaId().hashCode());
        result = prime * result + ((getAcaName() == null) ? 0 : getAcaName().hashCode());
        return result;
    }
}