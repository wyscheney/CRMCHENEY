package com.cheney.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cheney.entity.Jobinfo;

public interface JobinfoDao {

	public List<Jobinfo> queryAllJobinfo(@Param("departmentId")Integer departmentId);


}