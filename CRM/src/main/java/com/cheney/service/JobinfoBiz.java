package com.cheney.service;

import java.util.List;

import com.cheney.entity.Jobinfo;

public interface JobinfoBiz {
	
	/**
	 * 根据部门查找jobinfo
	 * @param deptmentId
	 * @return
	 */
	public List<Jobinfo> queryAllJobinfo(Integer deptmentId);
	/**
	 * 添加jobinfo
	 * @param jobinfo
	 * @return
	 */
	public int insert(Jobinfo jobinfo);
	
}
