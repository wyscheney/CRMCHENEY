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
	/**
	 * 修改jobinfo
	 * 
	 * @param jobinfo
	 * @return
	 */
	public int update(Jobinfo jobinfo);
	
	/**
	 * 删除jobinfo
	 * @param id
	 * @return
	 */
	public int delete(Integer id);
	
}
