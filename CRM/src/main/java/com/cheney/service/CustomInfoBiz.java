package com.cheney.service;

import java.util.List;
import java.util.Map;

import com.cheney.entity.Custominfo;

public interface CustomInfoBiz {
	
	public List<Map<String, Object>> selaseSelect(Integer followManId,Integer src);
	
	/**
	 * 修改客户信息
	 * @param coustominfo
	 * @return
	 */
	public int updateCustomInfo(Custominfo coustominfo);
	
	
	
	public int insertCustomInfo(Custominfo coustominfo);
	
}
