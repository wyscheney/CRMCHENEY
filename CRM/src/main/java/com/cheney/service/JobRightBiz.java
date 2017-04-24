package com.cheney.service;

import java.util.List;

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
	
	
}
