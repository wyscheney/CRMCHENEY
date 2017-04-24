package com.cheney.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cheney.entity.Resetpass;

public interface ResetpassDao {

	public List<Resetpass> queryAllResetPass();

	public int delete(@Param("id")Integer id);
	/**
	 * 添加修改密码请求表中的数据.
	 * @param username
	 * @param phoneNo
	 */
	public int insert(@Param("username")String username,@Param("phoneNo")String phoneNo);
	
	/**
	 * 查看是否有发送过请求.
	 * @param username
	 * @param phoneNo
	 * @return
	 */
	public Resetpass queryResetPass(@Param("username")String username);
}