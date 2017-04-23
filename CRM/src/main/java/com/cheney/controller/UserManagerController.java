package com.cheney.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cheney.entity.Department;
import com.cheney.entity.Employee;
import com.cheney.entity.Jobinfo;
import com.cheney.entity.Resetpass;
import com.cheney.service.DepartmentBiz;
import com.cheney.service.JobinfoBiz;
import com.cheney.service.ResetPassBiz;
import com.cheney.service.UserBiz;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class UserManagerController {
	
	@Resource
	private JobinfoBiz jobinfoBiz;
	@Resource
	private DepartmentBiz departmentBiz;
	@Resource
	private UserBiz userBiz;
	
	@Resource
	private ResetPassBiz resetPassBiz;
	
	@RequestMapping(value="getDepartment",produces="application/json;charset=UTF-8")
	public @ResponseBody String getDepartment(){
		List<Department> list =departmentBiz.queryAll();
		list.remove(0);
		ObjectMapper mapper = new ObjectMapper();
		
		String json=null;
		try {
			json=mapper.writeValueAsString(list);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	}
	
	@RequestMapping(value="getJobByDid",produces="application/json;charset=UTF-8")
	public @ResponseBody String beiyong(Integer departmentId){
		
		
		List<Jobinfo> list = jobinfoBiz.queryAllJobinfo(departmentId);
		ObjectMapper mapper = new ObjectMapper();
		
		String json=null;
		try {
			json=mapper.writeValueAsString(list);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	return json;
	}
	
	@RequestMapping("addUser")
	public @ResponseBody String addUser(Employee employee){
		if(employee.getJobInfoId()==null){
			employee.setJobInfoId(2);
			employee.setDepartmentId(1);
			
		}
		employee.setNickname(employee.getRealname());
		int count =userBiz.addUser(employee);
		return count +"";
	};
	
	
	@RequestMapping("querRestRequest")
	public @ResponseBody String querRestRequest(){
		List<Resetpass> list = resetPassBiz.queryAllResetPass();
		ObjectMapper mapper = new ObjectMapper();
		
		String json=null;
		try {
			json=mapper.writeValueAsString(list);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return json;

	}
	@RequestMapping("resetPass")
	public @ResponseBody String resetPass(Resetpass resetPass){
		
		//System.out.println(resetPass);
		int count = resetPassBiz.resetPass(resetPass);
		return count +"";
	}
	
	@RequestMapping("cancleUser")
	public @ResponseBody String cancleUser(String username){
		
		int count = userBiz.cancleUser(username);
		
		
		return count+"";
	}
	

}
