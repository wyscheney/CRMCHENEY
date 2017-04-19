package com.cheney.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.cheney.entity.Employee;

@Repository
public interface EmployeeDao {
	
	public Employee selectByNameAndPass(@Param("username")String username,@Param("pass")String pass);
	
	
}