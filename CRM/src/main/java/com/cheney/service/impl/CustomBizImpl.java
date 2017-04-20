package com.cheney.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cheney.dao.CustomDao;
import com.cheney.entity.Custom;
import com.cheney.service.CustomBiz;

@Service
public class CustomBizImpl implements CustomBiz {
	
	@Resource
	private CustomDao customDao;
	
	
	public int insertCustom(Custom custom) {
		
		return customDao.insertCustom(custom);
	}


	public List<Custom> queryCustom(Custom custom) {
		// TODO Auto-generated method stub
		return customDao.queryCustom(custom);
	}


	public int updateCustom(Custom custom) {
		
		return customDao.updateCustom(custom);
	}

}
