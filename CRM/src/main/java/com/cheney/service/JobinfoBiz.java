package com.cheney.service;

import java.util.List;

import com.cheney.entity.Jobinfo;

public interface JobinfoBiz {
	
	
	public List<Jobinfo> queryAllJobinfo(Integer deptmentId);
	
}
