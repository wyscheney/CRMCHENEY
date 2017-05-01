package com.cheney.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.cheney.entity.Custominfo;

public interface CustominfoDao {
	/**
	 * 添加客户跟进表.
	 * @param custominfos
	 * @return
	 */
	public int addcustominfos(List<Custominfo> custominfos);
	
	/**
	 * 根据跟进的人员和src标示查找数据.
	 * @param followManId
	 * @param src
	 * @return
	 */
	public List<Map<String, Object>> selectCustom(@Param("followManId")Integer followManId,@Param("src")Integer src);
	
	
	/**
	 * 更新跟进信息
	 */
	public int updateCustomInfo(Custominfo custominfo);
	
	/**
	 * 添加更新信息.
	 * @param custominfo
	 * @return
	 */
	public int insertCustominfo(Custominfo custominfo);
	
	/**
	 * 根据客户状态查询信息.
	 * @param statu
	 * @return
	 */
	public int selectCountByStatu(@Param("statu")String statu,@Param("followManId")Integer[] followManId);
	
	
	
	public Custominfo selectCustomInfo(@Param("id")Integer id);
}