package com.yibazhang.provider.entity.ext;

import com.yibazhang.provider.common.BaseExt;


public class TeacherExt extends BaseExt {
    private Integer tId;

    private String tName;

    private String acaName;
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


    public String getAcaName() {
        return acaName;
    }

    public void setAcaName(String acaName) {
        this.acaName = acaName;
    }
}