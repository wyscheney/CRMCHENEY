package com.cheney.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cheney.dao.EmployeeDao;
import com.cheney.entity.Employee;


public interface UserBiz {
	
	public Employee login(String username,String pass);

	public List<Employee> queryByJobInfo(int i);
	
	
	
}
