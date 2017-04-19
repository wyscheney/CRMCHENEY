package com.cheney.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.cheney.entity.JobRight;
@Repository
public interface JobRightDao {
	
	
	public List<JobRight> selectByRid(@Param("id")Integer id);
}