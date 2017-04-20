package com.cheney.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cheney.dao.RightsDao;
import com.cheney.entity.Rights;
import com.cheney.service.RightsBiz;
@Service
public class RightsBizImpl implements RightsBiz {
	@Resource
	private RightsDao rightsDao;
	
	public List<Rights> queryAllRights() {
		 
		return rightsDao.queryAllRightsBiz();
	}

}
