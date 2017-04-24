package com.cheney.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cheney.dao.JobinfoDao;
import com.cheney.entity.Jobinfo;
import com.cheney.service.JobinfoBiz;
@Service
public class JobinfoBizImpl implements JobinfoBiz {
	
	@Resource
	private JobinfoDao jobinfoDao;
	
	public List<Jobinfo> queryAllJobinfo(Integer deptmentid) {
		return jobinfoDao.queryAllJobinfo(deptmentid);
	}

	public int insert(Jobinfo jobinfo) {
		int count =0;
		
		Jobinfo job =jobinfoDao.queryjobinfo(jobinfo.getJob());
		if(job==null){
			count =	jobinfoDao.insert(jobinfo)>0?1:0;
		
		}else{
			count=2;
		}
		return count;
	}

}
