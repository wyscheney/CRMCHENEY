package com.cheney.service;

import java.util.List;

import com.cheney.entity.Custom;

public interface CustomBiz {

	public int insertCustom(Custom custom);
	
	public List<Custom> queryCustom(Custom custom);

	public int updateCustom(Custom custom);

	public int allotCustom();

	public int insertCustoms(List<Custom> list);
	/**
	 * 根据类型查找客户信息
	 * @param type
	 */
	public List<Custom> queryCustombyType(Integer type);
	

}
