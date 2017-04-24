package com.cheney.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import com.cheney.dao.EmployeeDao;
import com.cheney.dao.ResetpassDao;
import com.cheney.entity.Employee;
import com.cheney.entity.Resetpass;
import com.cheney.service.UserBiz;

@Service
public class UserBizImpl implements UserBiz{
	@Resource
	private EmployeeDao employeeDao;
	@Resource
	private ResetpassDao resetpassDao;
	
	
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
		String pass = DigestUtils.sha1Hex("123456");
		
		employee.setPass(pass);
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

	public int reqResetPass(String username, String phoneNo) {
		int count=0;
		Resetpass resetpass = resetpassDao.queryResetPass(username);
		if(resetpass==null){
			Employee employee = employeeDao.queryEmployee(username,phoneNo);
			if(employee!=null){
				count=resetpassDao.insert(username,phoneNo);
			}
		}else{
			count = 2;
		}
		return count;
	}

}
