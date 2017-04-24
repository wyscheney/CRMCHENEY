package com.cheney.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cheney.dao.RightsDao;
import com.cheney.entity.Employee;
import com.cheney.entity.JobRight;
import com.cheney.entity.Resetpass;
import com.cheney.entity.Rights;
import com.cheney.service.JobRightBiz;
import com.cheney.service.ResetPassBiz;
import com.cheney.service.UserBiz;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class UserController {
	
	@Resource
	private UserBiz userBiz;
	@Resource
	private JobRightBiz jobRightBiz;

	
	
	@RequestMapping("login")
	public @ResponseBody String login(HttpServletRequest request,String username,String pass){
		Employee user = userBiz.login(username, pass);
		System.out.println(pass);
		if(user !=null){
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		System.out.println(user);
		Integer jobInfoId = user.getJobInfoId();
		List<Rights> rights = jobRightBiz.queryJobRight(jobInfoId);session.setAttribute("rights", rights);
		
		return "1";
		}
		
		return "0";
		
	}
	
	@RequestMapping("checkUsername")
	public @ResponseBody String checkUsername(String username){
		System.out.println(username);
		boolean flag =userBiz.checkUsername(username);
		
		return String.valueOf(flag);
	}
	
	@RequestMapping(value="allEmployees",produces="application/json;charset=utf-8")
	public @ResponseBody String allEmployees(){
		List<Map<String, Object>> mapList = userBiz.queryAllEmployee();
		
		ObjectMapper mapper=new ObjectMapper();
		String json=null;
		try {
			json=mapper.writeValueAsString(mapList);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	}
	
	@RequestMapping("reqResetPass")
	public @ResponseBody String reqResetPass(String username,String phoneNo){
		int count = userBiz.reqResetPass(username,phoneNo);
		return count+"";
	}
	
	
	
	
}
