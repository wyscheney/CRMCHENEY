package com.cheney.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cheney.constant.CustomInfoStatu;
import com.cheney.dao.CustominfoDao;
import com.cheney.dao.EmployeeDao;
import com.cheney.entity.Custominfo;
import com.cheney.entity.Employee;
import com.cheney.service.CustomInfoBiz;
@Service
public class CustomInfoBizImpl implements CustomInfoBiz{
	@Resource
	private CustominfoDao custominfoDao;
	@Resource
	private EmployeeDao employeeDao;
	
	public List<Map<String, Object>> selaseSelect(Integer followManId, Integer src) {
		
		return custominfoDao.selectCustom(followManId, src);
	}

	public int updateCustomInfo(Custominfo coustominfo) {
		
		return custominfoDao.updateCustomInfo(coustominfo);
	}

	public int insertCustomInfo(Custominfo coustominfo) {
		return custominfoDao.insertCustominfo(coustominfo);
	}

	public Map<String, Object> selectCustominfo(Integer[] followManIds,Integer departmentId) {
		if(departmentId!=null){
			Integer[] ids = employeeDao.queryIdsByDeptId(departmentId);
			followManIds=ids;
		}
		
		
		int newAllot = custominfoDao.selectCountByStatu(CustomInfoStatu.NEWALLOT, followManIds);
		System.out.println(newAllot);
		int visited =  custominfoDao.selectCountByStatu(CustomInfoStatu.VISITED, followManIds);
		int disConnect =  custominfoDao.selectCountByStatu(CustomInfoStatu.DISCONNECT, followManIds);
		int invalid =  custominfoDao.selectCountByStatu(CustomInfoStatu.INVALID, followManIds);
		int denied =  custominfoDao.selectCountByStatu(CustomInfoStatu.DENIED, followManIds);
		int following =  custominfoDao.selectCountByStatu(CustomInfoStatu.FOLLOWING, followManIds);
		int total = custominfoDao.selectCountByStatu(null, followManIds);
		
		Map<String, Object> map =new LinkedHashMap<String, Object>();
		map.put("newAllot", newAllot);
		map.put("visited", visited);
		map.put("disConnect", disConnect);
		map.put("invalid", invalid);
		map.put("denied", denied);
		map.put("following", following);
		map.put("total", total);
		System.out.println(map);
		return map;
	}

}
