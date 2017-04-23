package com.cheney.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cheney.dao.EmployeeDao;
import com.cheney.dao.ResetpassDao;
import com.cheney.entity.Employee;
import com.cheney.entity.Resetpass;
import com.cheney.service.ResetPassBiz;
@Service
public class ResetPassBizImpl implements ResetPassBiz {
	@Resource
	private ResetpassDao resetpassDao;
	
	@Resource
	private EmployeeDao employeeDao;
	
	public List<Resetpass> queryAllResetPass() {
		
		return resetpassDao.queryAllResetPass();
	}

	

	public int resetPass(Resetpass resetpass) {
		Employee employee = employeeDao.selectEmployee(resetpass.getUsername(), null, null);
		int count =0;
		employee.setPass("123456");
		count = employeeDao.updateUser(employee);
		
		count=resetpassDao.delete(resetpass.getId());
		
		return count;
	}

}
