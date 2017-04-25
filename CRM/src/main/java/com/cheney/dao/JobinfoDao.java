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
	 * 添加职位信息
	 * @param jobinfo
	 * @return
	 */
	public int insert(Jobinfo jobinfo);
	/**
	 * 修改职位信息
	 * @param jobinfo
	 * @return
	 */
	public int update(Jobinfo jobinfo);
	/**
	 * 根据id删除jobinfo
	 * @param id
	 * @return
	 */
	public int delete(@Param("id")Integer id);
}