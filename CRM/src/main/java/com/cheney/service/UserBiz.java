package com.cheney.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cheney.dao.EmployeeDao;
import com.cheney.entity.Employee;


public interface UserBiz {
	
	public Employee login(String username,String pass);

	public List<Employee> queryByJobInfo(int i);

	public List<Employee> queryByDepId(Integer departmentId,Integer managerId);

	public Employee queryById(Integer followManId);

	/**
	 * 查询用户名是否存在
	 * @param username
	 * @return
	 */
	public boolean checkUsername(String username);
	/**
	 * 添加用户
	 * @param employee
	 * @return
	 */
	public int addUser(Employee employee);
	/**
	 * 注销员工
	 * @param username
	 * @return
	 */
	public int cancleUser(String username);

	public List<Map<String, Object>> queryAllEmployee();
	
	
	
}
