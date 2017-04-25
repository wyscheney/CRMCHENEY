package com.cheney.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.cheney.entity.JobRight;
@Repository
public interface JobRightDao {
	
	
	public List<JobRight> selectByRid(@Param("id")Integer id);
	/**
	 * 根据jobRight查询
	 * @param jobRight
	 * @return
	 */
	public JobRight query(JobRight jobRight);
	
	/**
	 * 添加权限对照表
	 * @param jobRight
	 * @return
	 */
	public int insert(JobRight jobRight);
	/**
	 * 根据职位id查找权限.
	 * @param jobinfoId
	 * @return
	 */
	public List<Map<String, Object>> queryByJobinfoId(@Param("jobinfoId")String jobinfoId);
	/**
	 * 根据id删除
	 * @param id
	 * @return
	 */
	public int deleteById(@Param("id")Integer id);
}