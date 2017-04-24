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
	/**
	 * 
	 * 查找用户信息,包括名字,联系方式,部门,职位.
	 * @return
	 */
	public List<Map<String, Object>> queryAllEmployee();
	/**
	 * 根据用户名字和密码查询是否发起重置.
	 * @param username
	 * @param phoneNo
	 * @return
	 */
	public int reqResetPass(String username, String phoneNo);
	
	
	
}
