package com.cheney.service;

import java.util.List;
import java.util.Map;

import com.cheney.entity.JobRight;
import com.cheney.entity.Rights;

public interface JobRightBiz {
	
	
	public List<Rights> queryJobRight(Integer jobinfoId);
	/**
	 * // 查询,是否已经有这个对照了
	 * @param jobRight
	 * @return ,如果有返回2如果没有添加. 返回1.失败返回0;
	 */
	public int allotjobRights(JobRight jobRight);
	
	/**
	 * 根据职位查找所有权限
	 * 
	 * @param jobinfoId
	 * @return
	 */
	public List<Map<String, Object>> queryJobRightByJobinfoId(String jobinfoId);
	/**
	 * 删除权限
	 * @param rightId
	 * @return
	 */
	public int removeById(Integer rightId);
	
	
}
