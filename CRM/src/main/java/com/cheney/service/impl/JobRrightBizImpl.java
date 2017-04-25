package com.cheney.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cheney.dao.JobRightDao;
import com.cheney.entity.JobRight;
import com.cheney.entity.Rights;
import com.cheney.service.JobRightBiz;
@Service
public class JobRrightBizImpl implements JobRightBiz {
	@Resource
	private JobRightDao jobRightDao;
	
	public List<Rights> queryJobRight(Integer jobinfoIds) {
		List<JobRight> jobRights = jobRightDao.selectByRid(jobinfoIds);
		List<Rights> list =new ArrayList<Rights>();
		
		for (JobRight jobRight : jobRights) {
			Rights rights = jobRight.getRights();
			list.add(rights);
		}
		return list;
	}

	public int allotjobRights(JobRight jobRight) {
		// 查询,是否已经有这个对照了,如果有返回2
		//如果没有添加. 返回1.
		//失败返回0;
		int count = 0;
		JobRight jr =jobRightDao.query(jobRight);
		
		if(jr==null){
			count =jobRightDao.insert(jobRight);
		}else{
			count= 2;
		}
		
		return count;
	}

	public List<Map<String, Object>> queryJobRightByJobinfoId(String jobinfoId) {
		
		return jobRightDao.queryByJobinfoId(jobinfoId);
	}

	public int removeById(Integer rightId) {
		
		return jobRightDao.deleteById(rightId);
	}

}
