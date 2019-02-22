package com.yibazhang.provider.entity;

import java.io.Serializable;

public class Class implements Serializable {
    private Integer cId;

    private String cName;

    private Integer cProfession;

    private Integer cAca;

    private static final long serialVersionUID = 1L;

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName == null ? null : cName.trim();
    }

    public Integer getcProfession() {
        return cProfession;
    }

    public void setcProfession(Integer cProfession) {
        this.cProfession = cProfession;
    }

    public Integer getcAca() {
        return cAca;
    }

    public void setcAca(Integer cAca) {
        this.cAca = cAca;
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
        Class other = (Class) that;
        return (this.getcId() == null ? other.getcId() == null : this.getcId().equals(other.getcId()))
            && (this.getcName() == null ? other.getcName() == null : this.getcName().equals(other.getcName()))
            && (this.getcProfession() == null ? other.getcProfession() == null : this.getcProfession().equals(other.getcProfession()))
            && (this.getcAca() == null ? other.getcAca() == null : this.getcAca().equals(other.getcAca()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getcId() == null) ? 0 : getcId().hashCode());
        result = prime * result + ((getcName() == null) ? 0 : getcName().hashCode());
        result = prime * result + ((getcProfession() == null) ? 0 : getcProfession().hashCode());
        result = prime * result + ((getcAca() == null) ? 0 : getcAca().hashCode());
        return result;
    }
}