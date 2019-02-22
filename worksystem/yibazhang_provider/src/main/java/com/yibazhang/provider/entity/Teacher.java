package com.yibazhang.provider.entity;

import java.io.Serializable;

public class Teacher implements Serializable {
    private Integer tId;

    private String tName;

    private String tSex;

    private String tMobile;

    private String tEmail;

    private Integer tAca;

    private static final long serialVersionUID = 1L;

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName == null ? null : tName.trim();
    }

    public String gettSex() {
        return tSex;
    }

    public void settSex(String tSex) {
        this.tSex = tSex == null ? null : tSex.trim();
    }

    public String gettMobile() {
        return tMobile;
    }

    public void settMobile(String tMobile) {
        this.tMobile = tMobile == null ? null : tMobile.trim();
    }

    public String gettEmail() {
        return tEmail;
    }

    public void settEmail(String tEmail) {
        this.tEmail = tEmail == null ? null : tEmail.trim();
    }

    public Integer gettAca() {
        return tAca;
    }

    public void settAca(Integer tAca) {
        this.tAca = tAca;
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
        Teacher other = (Teacher) that;
        return (this.gettId() == null ? other.gettId() == null : this.gettId().equals(other.gettId()))
            && (this.gettName() == null ? other.gettName() == null : this.gettName().equals(other.gettName()))
            && (this.gettSex() == null ? other.gettSex() == null : this.gettSex().equals(other.gettSex()))
            && (this.gettMobile() == null ? other.gettMobile() == null : this.gettMobile().equals(other.gettMobile()))
            && (this.gettEmail() == null ? other.gettEmail() == null : this.gettEmail().equals(other.gettEmail()))
            && (this.gettAca() == null ? other.gettAca() == null : this.gettAca().equals(other.gettAca()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((gettId() == null) ? 0 : gettId().hashCode());
        result = prime * result + ((gettName() == null) ? 0 : gettName().hashCode());
        result = prime * result + ((gettSex() == null) ? 0 : gettSex().hashCode());
        result = prime * result + ((gettMobile() == null) ? 0 : gettMobile().hashCode());
        result = prime * result + ((gettEmail() == null) ? 0 : gettEmail().hashCode());
        result = prime * result + ((gettAca() == null) ? 0 : gettAca().hashCode());
        return result;
    }
}