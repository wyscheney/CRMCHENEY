package com.cheney.entity;

public class JobRight {
    private Integer id;

    private Jobinfo jobinfo;

    private Rights rights;

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

    
}