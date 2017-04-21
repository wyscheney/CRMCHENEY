package com.cheney.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cheney.dao.CustominfoDao;
import com.cheney.entity.Custominfo;
import com.cheney.service.CustomInfoBiz;
@Service
public class CustomInfoBizImpl implements CustomInfoBiz{
	@Resource
	private CustominfoDao custominfoDao;
	
	public List<Map<String, Object>> selaseSelect(Integer followManId, Integer src) {
		
		return custominfoDao.selectCustom(followManId, src);
	}

	public int updateCustomInfo(Custominfo coustominfo) {
		
		return custominfoDao.updateCustomInfo(coustominfo);
	}

	public int insertCustomInfo(Custominfo coustominfo) {
		return custominfoDao.insertCustominfo(coustominfo);
	}

}
