package com.cheney.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.cheney.entity.Custom;

@Repository
public interface CustomDao {
	/**
	 * 根据用户对象,在客户表中添加客户数据.
	 * @param custom
	 * @return
	 */
	public int insertCustom(Custom custom);
	/**
	 * 根据客户对象,查找客户信息.
	 * @param custom
	 * @return
	 */
	public List<Custom> queryCustom(Custom custom);
	/**
	 * 更新客户信息.
	 * @param custom
	 * @return
	 */
	public int updateCustom(Custom custom);
	/**
	 * 根据客户状态查找id集合
	 * @param CustomStatus
	 * @return
	 */
	public Integer[] selectIdsByStatus(String CustomStatus);
	/**
	 * 更新客户信息到销售跟进
	 * @param ids
	 * @return
	 */
	public int updateTOSalse(Integer[] ids);
	
	/**
	 * 批量插入客户信息
	 * @param customs
	 * @return
	 */
	public int insertCustoms(@Param("customs")List<Custom> customs);
	
	public List<Custom> queryAllCustom();
	
	/**
	 * 查询本周客户信息.
	 * @return
	 */
	public List<Custom> queryCustomByWeek();
	/**
	 * 查询本月客户信息
	 * @return
	 */
	public List<Custom> queryCustomByMonth();
	
}