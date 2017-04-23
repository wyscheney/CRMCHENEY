package com.cheney.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cheney.entity.Resetpass;

public interface ResetpassDao {

	public List<Resetpass> queryAllResetPass();

	public int delete(@Param("id")Integer id);
}