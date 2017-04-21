package com.cheney.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.cheney.entity.Custominfo;

public interface CustominfoDao {

	public int addcustominfos(List<Custominfo> custominfos);
	
	
	public List<Map<String, Object>> selectCustom(@Param("followManId")Integer followManId,@Param("src")Integer src);
	
	
	
	public int updateCustomInfo(Custominfo custominfo);
	
	
	public int insertCustominfo(Custominfo custominfo);
	
}