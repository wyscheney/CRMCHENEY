package com.cheney.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cheney.dao.DepartmentDao;
import com.cheney.entity.Department;
import com.cheney.service.DepartmentBiz;

@Service
public class DepartmentBizImpl implements DepartmentBiz {
	@Resource
	private DepartmentDao departmentDao;
	
	public List<Department> queryAll() {
		
		
		return departmentDao.queryAll();
	}

}
