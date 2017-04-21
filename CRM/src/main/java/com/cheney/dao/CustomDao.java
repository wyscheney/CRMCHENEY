package com.cheney.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cheney.entity.Custom;

@Repository
public interface CustomDao {

	public int insertCustom(Custom custom);
	
	public List<Custom> queryCustom(Custom custom);

	public int updateCustom(Custom custom);
	
	public Integer[] selectIdsByStatus(String CustomStatus);

	public int updateTOSalse(Integer[] ids);
}