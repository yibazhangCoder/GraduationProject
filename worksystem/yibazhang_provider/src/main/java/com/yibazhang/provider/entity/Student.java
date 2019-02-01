package com.yibazhang.provider.entity;

import java.io.Serializable;

public class Student implements Serializable {
    private Integer sId;

    private String sName;

    private String sSex;

    private Integer sAge;

    private String sPhone;

    private Integer sAca;

    private String sClass;

    private String sPassword;

    private static final long serialVersionUID = 1L;

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName == null ? null : sName.trim();
    }

    public String getsSex() {
        return sSex;
    }

    public void setsSex(String sSex) {
        this.sSex = sSex == null ? null : sSex.trim();
    }

    public Integer getsAge() {
        return sAge;
    }

    public void setsAge(Integer sAge) {
        this.sAge = sAge;
    }

    public String getsPhone() {
        return sPhone;
    }

    public void setsPhone(String sPhone) {
        this.sPhone = sPhone == null ? null : sPhone.trim();
    }

    public Integer getsAca() {
        return sAca;
    }

    public void setsAca(Integer sAca) {
        this.sAca = sAca;
    }

    public String getsClass() {
        return sClass;
    }

    public void setsClass(String sClass) {
        this.sClass = sClass == null ? null : sClass.trim();
    }

    public String getsPassword() {
        return sPassword;
    }

    public void setsPassword(String sPassword) {
        this.sPassword = sPassword == null ? null : sPassword.trim();
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
        Student other = (Student) that;
        return (this.getsId() == null ? other.getsId() == null : this.getsId().equals(other.getsId()))
            && (this.getsName() == null ? other.getsName() == null : this.getsName().equals(other.getsName()))
            && (this.getsSex() == null ? other.getsSex() == null : this.getsSex().equals(other.getsSex()))
            && (this.getsAge() == null ? other.getsAge() == null : this.getsAge().equals(other.getsAge()))
            && (this.getsPhone() == null ? other.getsPhone() == null : this.getsPhone().equals(other.getsPhone()))
            && (this.getsAca() == null ? other.getsAca() == null : this.getsAca().equals(other.getsAca()))
            && (this.getsClass() == null ? other.getsClass() == null : this.getsClass().equals(other.getsClass()))
            && (this.getsPassword() == null ? other.getsPassword() == null : this.getsPassword().equals(other.getsPassword()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getsId() == null) ? 0 : getsId().hashCode());
        result = prime * result + ((getsName() == null) ? 0 : getsName().hashCode());
        result = prime * result + ((getsSex() == null) ? 0 : getsSex().hashCode());
        result = prime * result + ((getsAge() == null) ? 0 : getsAge().hashCode());
        result = prime * result + ((getsPhone() == null) ? 0 : getsPhone().hashCode());
        result = prime * result + ((getsAca() == null) ? 0 : getsAca().hashCode());
        result = prime * result + ((getsClass() == null) ? 0 : getsClass().hashCode());
        result = prime * result + ((getsPassword() == null) ? 0 : getsPassword().hashCode());
        return result;
    }
}