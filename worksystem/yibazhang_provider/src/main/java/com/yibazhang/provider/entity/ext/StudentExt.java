package com.yibazhang.provider.entity.ext;

import com.yibazhang.provider.common.BaseExt;

import java.io.Serializable;

public class StudentExt extends BaseExt {
    private Integer sId;

    private Integer sAge;

    private String sName;

    private String sSex;

    private String sMobile;

    private String sEmail;

    private Integer sAca;

    private Integer sProfession;

    private Integer sClass;

    private String acaName;

    private String professionName;

    public String getAcaName() {
        return acaName;
    }

    public void setAcaName(String acaName) {
        this.acaName = acaName;
    }

    public String getProfessionName() {
        return professionName;
    }

    public void setProfessionName(String professionName) {
        this.professionName = professionName;
    }



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

}