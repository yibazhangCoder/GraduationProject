package com.yibazhang.provider.entity;

import java.io.Serializable;
import java.util.Date;

public class StudentHomeworkCommit implements Serializable {
    private Integer id;

    private Integer sId;

    private String sName;

    private String studentHomeworkPath;

    private String studentHomeworkName;

    private Integer isCommited;

    private Date commitedTime;

    private Integer isReceive;

    private Date receiveTime;

    private Integer difficult;

    private Date useTime;

    private Integer pleasured;

    private Integer studentHomeworkStatus;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getStudentHomeworkPath() {
        return studentHomeworkPath;
    }

    public void setStudentHomeworkPath(String studentHomeworkPath) {
        this.studentHomeworkPath = studentHomeworkPath == null ? null : studentHomeworkPath.trim();
    }

    public String getStudentHomeworkName() {
        return studentHomeworkName;
    }

    public void setStudentHomeworkName(String studentHomeworkName) {
        this.studentHomeworkName = studentHomeworkName == null ? null : studentHomeworkName.trim();
    }

    public Integer getIsCommited() {
        return isCommited;
    }

    public void setIsCommited(Integer isCommited) {
        this.isCommited = isCommited;
    }

    public Date getCommitedTime() {
        return commitedTime;
    }

    public void setCommitedTime(Date commitedTime) {
        this.commitedTime = commitedTime;
    }

    public Integer getIsReceive() {
        return isReceive;
    }

    public void setIsReceive(Integer isReceive) {
        this.isReceive = isReceive;
    }

    public Date getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }

    public Integer getDifficult() {
        return difficult;
    }

    public void setDifficult(Integer difficult) {
        this.difficult = difficult;
    }

    public Date getUseTime() {
        return useTime;
    }

    public void setUseTime(Date useTime) {
        this.useTime = useTime;
    }

    public Integer getPleasured() {
        return pleasured;
    }

    public void setPleasured(Integer pleasured) {
        this.pleasured = pleasured;
    }

    public Integer getStudentHomeworkStatus() {
        return studentHomeworkStatus;
    }

    public void setStudentHomeworkStatus(Integer studentHomeworkStatus) {
        this.studentHomeworkStatus = studentHomeworkStatus;
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
        StudentHomeworkCommit other = (StudentHomeworkCommit) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getsId() == null ? other.getsId() == null : this.getsId().equals(other.getsId()))
            && (this.getsName() == null ? other.getsName() == null : this.getsName().equals(other.getsName()))
            && (this.getStudentHomeworkPath() == null ? other.getStudentHomeworkPath() == null : this.getStudentHomeworkPath().equals(other.getStudentHomeworkPath()))
            && (this.getStudentHomeworkName() == null ? other.getStudentHomeworkName() == null : this.getStudentHomeworkName().equals(other.getStudentHomeworkName()))
            && (this.getIsCommited() == null ? other.getIsCommited() == null : this.getIsCommited().equals(other.getIsCommited()))
            && (this.getCommitedTime() == null ? other.getCommitedTime() == null : this.getCommitedTime().equals(other.getCommitedTime()))
            && (this.getIsReceive() == null ? other.getIsReceive() == null : this.getIsReceive().equals(other.getIsReceive()))
            && (this.getReceiveTime() == null ? other.getReceiveTime() == null : this.getReceiveTime().equals(other.getReceiveTime()))
            && (this.getDifficult() == null ? other.getDifficult() == null : this.getDifficult().equals(other.getDifficult()))
            && (this.getUseTime() == null ? other.getUseTime() == null : this.getUseTime().equals(other.getUseTime()))
            && (this.getPleasured() == null ? other.getPleasured() == null : this.getPleasured().equals(other.getPleasured()))
            && (this.getStudentHomeworkStatus() == null ? other.getStudentHomeworkStatus() == null : this.getStudentHomeworkStatus().equals(other.getStudentHomeworkStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getsId() == null) ? 0 : getsId().hashCode());
        result = prime * result + ((getsName() == null) ? 0 : getsName().hashCode());
        result = prime * result + ((getStudentHomeworkPath() == null) ? 0 : getStudentHomeworkPath().hashCode());
        result = prime * result + ((getStudentHomeworkName() == null) ? 0 : getStudentHomeworkName().hashCode());
        result = prime * result + ((getIsCommited() == null) ? 0 : getIsCommited().hashCode());
        result = prime * result + ((getCommitedTime() == null) ? 0 : getCommitedTime().hashCode());
        result = prime * result + ((getIsReceive() == null) ? 0 : getIsReceive().hashCode());
        result = prime * result + ((getReceiveTime() == null) ? 0 : getReceiveTime().hashCode());
        result = prime * result + ((getDifficult() == null) ? 0 : getDifficult().hashCode());
        result = prime * result + ((getUseTime() == null) ? 0 : getUseTime().hashCode());
        result = prime * result + ((getPleasured() == null) ? 0 : getPleasured().hashCode());
        result = prime * result + ((getStudentHomeworkStatus() == null) ? 0 : getStudentHomeworkStatus().hashCode());
        return result;
    }
}