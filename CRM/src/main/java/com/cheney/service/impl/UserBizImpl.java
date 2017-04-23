package com.cheney.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cheney.dao.EmployeeDao;
import com.cheney.entity.Employee;
import com.cheney.service.UserBiz;

@Service
public class UserBizImpl implements UserBiz{
	@Resource
	private EmployeeDao employeeDao;
	
	public Employee login(String username, String pass) {
		
		Employee e = employeeDao.selectEmployee(username, pass, "1");
		
		return e;
	}

	public List<Employee> queryByJobInfo(int i) {
		
		return employeeDao.queryByJobInfo(i);
	}

	public List<Employee> queryByDepId(Integer departmentId,Integer managerId) {
		
		return employeeDao.queryByDeptId(departmentId,managerId);
	}

	public Employee queryById(Integer followManId) {
		
		return employeeDao.queryById(followManId);
	}

	public boolean checkUsername(String username) {
		
		
		boolean flag = employeeDao.selectEmployee(username, null, null)==null;
		
		return flag;
		
		
		
	}

	public int addUser(Employee employee) {
		
		employee.setWorkStatu("1");
		employee.setPass("123456");
		
		return employeeDao.addUser(employee);
	}

	public int cancleUser(String username) {
		Employee employee = employeeDao.selectEmployee(username, null, null);
		employee.setWorkStatu("0");
		return employeeDao.updateUser(employee);
	}

	public List<Map<String, Object>> queryAllEmployee() {
		
		return employeeDao.queryAllEmployee();
	}

}
