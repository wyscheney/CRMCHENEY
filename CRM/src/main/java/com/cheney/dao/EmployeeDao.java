package com.cheney.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.cheney.entity.Employee;

@Repository
public interface EmployeeDao {
	
	public Employee selectEmployee(@Param("username")String username,@Param("pass")String pass,@Param("workStatu")String workStatu);
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
	/**
	 * 查找部门员工.如果为0则查找所有
	 * @param departmentId
	 * @return
	 */
	public List<Employee> queryByDeptId(@Param("deptId")Integer departmentId,@Param("managerId")Integer managerId);
	/**
	 * g根据id查找用户
	 * @param id
	 * @return
	 */
	public Employee queryById(Integer id);
	
	
	
	public Integer[] queryIdsByDeptId(@Param("deptId")Integer departmentId);
	/**
	 * 添加用户
	 * @param employee
	 * @return
	 */
	public int addUser(Employee employee);
	
	/**
	 * 修改用户.
	 * @param employee
	 * @return
	 */
	public int updateUser(Employee employee);
	/**
	 * 
	 * 查询所有的用户信息
	 * @return
	 */
	public List<Map<String, Object>> queryAllEmployee();
	/**
	 * 根据用户名字和电话查询是否有这个用户.
	 * @param username
	 * @param phoneNo
	 * @return
	 */
	public Employee queryEmployee(@Param("username")String username,@Param("phoneNo")String phoneNo);
	
	
	
	
}