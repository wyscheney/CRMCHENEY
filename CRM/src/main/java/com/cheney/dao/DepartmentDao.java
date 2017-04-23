package com.cheney.dao;

import java.util.List;

import com.cheney.entity.Department;

public interface DepartmentDao {

	public List<Department> queryAll();
}