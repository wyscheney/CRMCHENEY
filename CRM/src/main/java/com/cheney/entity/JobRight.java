package com.cheney.entity;

public class JobRight {
    private Integer id;

    private Jobinfo jobinfo;
    
    private Integer jobinfoId;
    
    
    private Rights rights;

    private Integer rightId;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

	public Jobinfo getJobinfo() {
		return jobinfo;
	}

	public void setJobinfo(Jobinfo jobinfo) {
		this.jobinfo = jobinfo;
	}

	public Rights getRights() {
		return rights;
	}

	public void setRights(Rights rights) {
		this.rights = rights;
	}

	public Integer getRightId() {
		return rightId;
	}

	public void setRightId(Integer rightId) {
		this.rightId = rightId;
	}

	public Integer getJobinfoId() {
		return jobinfoId;
	}

	public void setJobinfoId(Integer jobinfoId) {
		this.jobinfoId = jobinfoId;
	}



	

    
}