package com.yibazhang.provider.entity;

import java.io.Serializable;

public class HomeWorkStudent implements Serializable {
    private Integer id;

    private Integer sId;

    private Long hId;

    private Integer hStatusStu;

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

    public Long gethId() {
        return hId;
    }

    public void sethId(Long hId) {
        this.hId = hId;
    }

    public Integer gethStatusStu() {
        return hStatusStu;
    }

    public void sethStatusStu(Integer hStatusStu) {
        this.hStatusStu = hStatusStu;
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
        HomeWorkStudent other = (HomeWorkStudent) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getsId() == null ? other.getsId() == null : this.getsId().equals(other.getsId()))
            && (this.gethId() == null ? other.gethId() == null : this.gethId().equals(other.gethId()))
            && (this.gethStatusStu() == null ? other.gethStatusStu() == null : this.gethStatusStu().equals(other.gethStatusStu()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getsId() == null) ? 0 : getsId().hashCode());
        result = prime * result + ((gethId() == null) ? 0 : gethId().hashCode());
        result = prime * result + ((gethStatusStu() == null) ? 0 : gethStatusStu().hashCode());
        return result;
    }
}