package com.cheney.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Custominfo {
    private Integer id;

    private Integer customId;

    private Integer followManId;

    private String statu;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date startDate;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date lastFollowDate;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date planDate;

    private String mark;
    
    
    
    
    
    public Custominfo(Integer customId, Integer followManId, String statu, Date startDate) {
		super();
		this.customId = customId;
		this.followManId = followManId;
		this.statu = statu;
		this.startDate = startDate;
	}

	public Custominfo() {
		super();
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustomId() {
        return customId;
    }

    public void setCustomId(Integer customId) {
        this.customId = customId;
    }

    public Integer getFollowManId() {
        return followManId;
    }

    public void setFollowManId(Integer followManId) {
        this.followManId = followManId;
    }

    public String getStatu() {
        return statu;
    }

    public void setStatu(String statu) {
        this.statu = statu;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getLastFollowDate() {
        return lastFollowDate;
    }

    public void setLastFollowDate(Date lastFollowDate) {
        this.lastFollowDate = lastFollowDate;
    }

    public Date getPlanDate() {
        return planDate;
    }

    public void setPlanDate(Date planDate) {
        this.planDate = planDate;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

	@Override
	public String toString() {
		return "Custominfo [id=" + id + ", customId=" + customId + ", followManId=" + followManId + ", statu=" + statu
				+ ", startDate=" + startDate + ", lastFollowDate=" + lastFollowDate + ", planDate=" + planDate
				+ ", mark=" + mark + "]";
	}
    
}