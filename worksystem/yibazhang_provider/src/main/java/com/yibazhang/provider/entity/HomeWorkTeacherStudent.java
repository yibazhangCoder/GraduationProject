package com.yibazhang.provider.entity;

import java.io.Serializable;

public class HomeWorkTeacherStudent implements Serializable {
    private Integer id;

    private Integer tId;

    private Long hId;

    private Integer sId;

    private Integer isReceived;

    private String tRemark;

    private Double sScore;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public Long gethId() {
        return hId;
    }

    public void sethId(Long hId) {
        this.hId = hId;
    }

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public Integer getIsReceived() {
        return isReceived;
    }

    public void setIsReceived(Integer isReceived) {
        this.isReceived = isReceived;
    }

    public String gettRemark() {
        return tRemark;
    }

    public void settRemark(String tRemark) {
        this.tRemark = tRemark == null ? null : tRemark.trim();
    }

    public Double getsScore() {
        return sScore;
    }

    public void setsScore(Double sScore) {
        this.sScore = sScore;
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
        HomeWorkTeacherStudent other = (HomeWorkTeacherStudent) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.gettId() == null ? other.gettId() == null : this.gettId().equals(other.gettId()))
            && (this.gethId() == null ? other.gethId() == null : this.gethId().equals(other.gethId()))
            && (this.getsId() == null ? other.getsId() == null : this.getsId().equals(other.getsId()))
            && (this.getIsReceived() == null ? other.getIsReceived() == null : this.getIsReceived().equals(other.getIsReceived()))
            && (this.gettRemark() == null ? other.gettRemark() == null : this.gettRemark().equals(other.gettRemark()))
            && (this.getsScore() == null ? other.getsScore() == null : this.getsScore().equals(other.getsScore()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((gettId() == null) ? 0 : gettId().hashCode());
        result = prime * result + ((gethId() == null) ? 0 : gethId().hashCode());
        result = prime * result + ((getsId() == null) ? 0 : getsId().hashCode());
        result = prime * result + ((getIsReceived() == null) ? 0 : getIsReceived().hashCode());
        result = prime * result + ((gettRemark() == null) ? 0 : gettRemark().hashCode());
        result = prime * result + ((getsScore() == null) ? 0 : getsScore().hashCode());
        return result;
    }
}