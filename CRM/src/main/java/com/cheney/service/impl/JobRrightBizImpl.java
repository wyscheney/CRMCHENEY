package com.cheney.service.impl;

import java.util.ArrayList;
import java.util.List;

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

}
