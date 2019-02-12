package com.yibazhang.provider.entity;

import java.io.Serializable;

public class Student implements Serializable {
    private Integer sId;

    private Integer sAge;

    private String sName;

    private String sSex;

    private String sMobile;

    private String sEmail;

    private Integer sAca;

    private Integer sProfession;

    private Integer sClass;

    private static final long serialVersionUID = 1L;

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public Integer getsAge() {
        return sAge;
    }

    public void setsAge(Integer sAge) {
        this.sAge = sAge;
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

    public String getsMobile() {
        return sMobile;
    }

    public void setsMobile(String sMobile) {
        this.sMobile = sMobile == null ? null : sMobile.trim();
    }

    public String getsEmail() {
        return sEmail;
    }

    public void setsEmail(String sEmail) {
        this.sEmail = sEmail == null ? null : sEmail.trim();
    }

    public Integer getsAca() {
        return sAca;
    }

    public void setsAca(Integer sAca) {
        this.sAca = sAca;
    }

    public Integer getsProfession() {
        return sProfession;
    }

    public void setsProfession(Integer sProfession) {
        this.sProfession = sProfession;
    }

    public Integer getsClass() {
        return sClass;
    }

    public void setsClass(Integer sClass) {
        this.sClass = sClass;
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
            && (this.getsAge() == null ? other.getsAge() == null : this.getsAge().equals(other.getsAge()))
            && (this.getsName() == null ? other.getsName() == null : this.getsName().equals(other.getsName()))
            && (this.getsSex() == null ? other.getsSex() == null : this.getsSex().equals(other.getsSex()))
            && (this.getsMobile() == null ? other.getsMobile() == null : this.getsMobile().equals(other.getsMobile()))
            && (this.getsEmail() == null ? other.getsEmail() == null : this.getsEmail().equals(other.getsEmail()))
            && (this.getsAca() == null ? other.getsAca() == null : this.getsAca().equals(other.getsAca()))
            && (this.getsProfession() == null ? other.getsProfession() == null : this.getsProfession().equals(other.getsProfession()))
            && (this.getsClass() == null ? other.getsClass() == null : this.getsClass().equals(other.getsClass()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getsId() == null) ? 0 : getsId().hashCode());
        result = prime * result + ((getsAge() == null) ? 0 : getsAge().hashCode());
        result = prime * result + ((getsName() == null) ? 0 : getsName().hashCode());
        result = prime * result + ((getsSex() == null) ? 0 : getsSex().hashCode());
        result = prime * result + ((getsMobile() == null) ? 0 : getsMobile().hashCode());
        result = prime * result + ((getsEmail() == null) ? 0 : getsEmail().hashCode());
        result = prime * result + ((getsAca() == null) ? 0 : getsAca().hashCode());
        result = prime * result + ((getsProfession() == null) ? 0 : getsProfession().hashCode());
        result = prime * result + ((getsClass() == null) ? 0 : getsClass().hashCode());
        return result;
    }
}