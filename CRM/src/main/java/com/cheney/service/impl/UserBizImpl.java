package com.cheney.service.impl;

import java.util.List;

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
		System.out.println(username);
		Employee e = employeeDao.selectByNameAndPass(username, pass);
		System.out.println(e);
		return e;
	}

	public List<Employee> queryByJobInfo(int i) {
		
		return employeeDao.queryByJobInfo(i);
	}

}
