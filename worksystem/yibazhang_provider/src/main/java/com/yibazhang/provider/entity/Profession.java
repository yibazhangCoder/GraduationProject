package com.yibazhang.provider.entity;

import java.io.Serializable;

public class Profession implements Serializable {
    private Integer professionId;

    private String professionName;

    private Integer professionAca;

    private static final long serialVersionUID = 1L;

    public Integer getProfessionId() {
        return professionId;
    }

    public void setProfessionId(Integer professionId) {
        this.professionId = professionId;
    }

    public String getProfessionName() {
        return professionName;
    }

    public void setProfessionName(String professionName) {
        this.professionName = professionName == null ? null : professionName.trim();
    }

    public Integer getProfessionAca() {
        return professionAca;
    }

    public void setProfessionAca(Integer professionAca) {
        this.professionAca = professionAca;
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
        Profession other = (Profession) that;
        return (this.getProfessionId() == null ? other.getProfessionId() == null : this.getProfessionId().equals(other.getProfessionId()))
            && (this.getProfessionName() == null ? other.getProfessionName() == null : this.getProfessionName().equals(other.getProfessionName()))
            && (this.getProfessionAca() == null ? other.getProfessionAca() == null : this.getProfessionAca().equals(other.getProfessionAca()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getProfessionId() == null) ? 0 : getProfessionId().hashCode());
        result = prime * result + ((getProfessionName() == null) ? 0 : getProfessionName().hashCode());
        result = prime * result + ((getProfessionAca() == null) ? 0 : getProfessionAca().hashCode());
        return result;
    }
}