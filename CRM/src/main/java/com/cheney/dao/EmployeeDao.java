package com.cheney.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.cheney.entity.Employee;

@Repository
public interface EmployeeDao {
	
	public Employee selectByNameAndPass(@Param("username")String username,@Param("pass")String pass);
	/**
	 * 根据jobinfoId 查找员工.
	 * @param i
	 * @return
	 */
	public List<Employee> queryByJobInfo(@Param("jobInfoId")int i);
	/**
	 * 根据部门查找员工.
	 * @param depaartmentId
	 * @return
	 */
	public List<Employee> selectEmployBydepaartmentId(@Param("departmentId")Integer depaartmentId,@Param("jobInfoId")Integer jobinInfo);
}