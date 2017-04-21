package com.cheney.entity;

import java.util.Date;

public class ConsultRecord {
    private Integer id;

    private Integer customId;

    private Integer consultManId;

    private String consultStatu;

    private Date consultDate;

    private String result;

    private Custom custom;
    
    
    
    public Custom getCustom() {
		return custom;
	}

	public void setCustom(Custom custom) {
		this.custom = custom;
	}

	public ConsultRecord(Integer customId, Integer consultManId, String consultStatu, Date consultDate) {
		super();
		this.customId = customId;
		this.consultManId = consultManId;
		this.consultStatu = consultStatu;
		this.consultDate = consultDate;
	}

	public ConsultRecord() {
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

    public Integer getConsultManId() {
        return consultManId;
    }

    public void setConsultManId(Integer consultManId) {
        this.consultManId = consultManId;
    }

    public String getConsultStatu() {
        return consultStatu;
    }

    public void setConsultStatu(String consultStatu) {
        this.consultStatu = consultStatu;
    }

    public Date getConsultDate() {
        return consultDate;
    }

    public void setConsultDate(Date consultDate) {
        this.consultDate = consultDate;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

	@Override
	public String toString() {
		return "Consultrecord [id=" + id + ", customId=" + customId + ", consultManId=" + consultManId
				+ ", consultStatu=" + consultStatu + ", consultDate=" + consultDate + ", result=" + result + "]";
	}
    
}