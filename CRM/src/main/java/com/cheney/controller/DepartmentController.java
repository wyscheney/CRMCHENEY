package com.cheney.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cheney.entity.Employee;
import com.cheney.service.ConsultRecordBiz;
import com.cheney.service.CustomInfoBiz;
import com.cheney.service.UserBiz;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class DepartmentController {
	
	@Resource
	private UserBiz userBizImpl;
	
	@Resource
	private CustomInfoBiz customInfoBiz;
	
	@Resource
	private ConsultRecordBiz consultRecordBiz;
	
	@RequestMapping(value="empForDepart",produces="application/json;charset=UTF-8")
	public @ResponseBody String empForDepart(Integer departmentId,Integer managerId){
		
		List<Employee> list = userBizImpl.queryByDepId(departmentId,managerId);
		ObjectMapper mapper = new ObjectMapper();
		String json="";
		try {
			json =mapper.writeValueAsString(list);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(json);
		return json;
	}
	
	@RequestMapping("countInfo")
	public @ResponseBody String countInfo(Integer[] followManId){
		Map<String, Object> map = customInfoBiz.selectCustominfo(followManId,null);
		//查询根据跟单人查询相关的groupby数据.
		
		ObjectMapper mapper = new ObjectMapper();
		String json="";
		try {
			json =mapper.writeValueAsString(map);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "["+json+"]";
		
	}
	
	@RequestMapping("countConsult")
	public @ResponseBody String countConsult(Integer[] consultManId){
		
		Map<String,Object> map=consultRecordBiz.selectCountByConsultManId(consultManId,null);
		
		String json="";
		ObjectMapper mapper = new ObjectMapper();
		try {
			json =mapper.writeValueAsString(map);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "["+json+"]";
	}
	
	@RequestMapping("countInfoForDepart")
	public @ResponseBody String countInfoForDepart(Integer departmentId){
		System.out.println(departmentId);
		Map<String,Object> map=customInfoBiz.selectCustominfo(null,departmentId);
		
		System.out.println("map4"+map);
		String json="";
		ObjectMapper mapper = new ObjectMapper();
		try {
			json =mapper.writeValueAsString(map);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "["+json+"]";
	}
	
	@RequestMapping("countConsultForDepart")
	public @ResponseBody String countConsultForDepart(Integer departmentId){
		
		
		Map<String, Object> map = consultRecordBiz.selectCountByConsultManId(null,departmentId);
		String json="";
		ObjectMapper mapper = new ObjectMapper();
		try {
			json =mapper.writeValueAsString(map);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "["+json+"]";
	}
	
}
