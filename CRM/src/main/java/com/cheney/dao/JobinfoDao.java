package com.cheney.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cheney.entity.Jobinfo;

public interface JobinfoDao {

	public List<Jobinfo> queryAllJobinfo(@Param("departmentId")Integer departmentId);
	
	/**
	 * 根据名字查询职位.
	 * @param job
	 * @return
	 */
	public Jobinfo queryjobinfo(@Param("job")String job);
	/**
	 * 插入
	 * @param jobinfo
	 * @return
	 */
	public int insert(Jobinfo jobinfo);


}