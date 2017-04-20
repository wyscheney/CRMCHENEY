package com.cheney.controller;

import java.util.List;

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
import com.cheney.entity.Rights;
import com.cheney.service.JobRightBiz;
import com.cheney.service.UserBiz;

@Controller
public class UserController {
	
	@Resource
	private UserBiz userBiz;
	@Resource
	private JobRightBiz jobRightBiz;
	
	
	@RequestMapping("login")
	public @ResponseBody String login(HttpServletRequest request,String username,String pass){
		Employee user = userBiz.login(username, pass);
		
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

}
