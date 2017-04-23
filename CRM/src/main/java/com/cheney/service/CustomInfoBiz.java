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
	
	
	/**
	 * 插入客户跟进数据
	 * @param coustominfo
	 * @return
	 */
	public int insertCustomInfo(Custominfo coustominfo);
	
	/**
	 * 根据部门id 和 跟进人查找.
	 * selectCountByStatu
	 * @param followManId 如果为null 则查询所有人.
	 * @param departmentId 如果为null 则不按照部门 
	 * @return
	 */
	public Map<String, Object> selectCustominfo(Integer[] followManId,Integer departmentId);
	
}
