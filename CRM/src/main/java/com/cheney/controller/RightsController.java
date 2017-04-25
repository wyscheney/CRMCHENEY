package com.cheney.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cheney.entity.JobRight;
import com.cheney.entity.Jobinfo;
import com.cheney.entity.Rights;
import com.cheney.service.JobRightBiz;
import com.cheney.service.RightsBiz;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class RightsController {
	
	@Resource
	private RightsBiz rightsBiz;
	@Resource
	private JobRightBiz jobRightBiz;
	
	@RequestMapping(value="queryAllRights",produces = "application/json; charset=utf-8")
	public @ResponseBody String queryRights(){
		
		List<Rights> rights = rightsBiz.queryAllRights();
		
		Map<String, Object> map =new HashMap<String, Object>();
		map.put("rows", rights);
		
		ObjectMapper mapper =new ObjectMapper();
		String rightsJason=null;
		try {
			rightsJason = mapper.writeValueAsString(map);
			System.out.println(rightsJason);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return rightsJason;
	}
	
	
	@RequestMapping("allotjobRights")
	public @ResponseBody String allotjobRights(JobRight jobRight){
		
		int count = jobRightBiz.allotjobRights(jobRight);
		
		return count+"";
	}
	
	@RequestMapping(value="queryRights",produces = "application/json; charset=utf-8")
	public @ResponseBody String queryRights(String jobinfoId){
		
		List<Map<String, Object>> map = jobRightBiz.queryJobRightByJobinfoId(jobinfoId);
		ObjectMapper mapper =new ObjectMapper();
		String Json=null;
		try {
			Json = mapper.writeValueAsString(map);
			System.out.println(Json);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		}
		return Json;
	}
	
	@RequestMapping("removeRights")
	public @ResponseBody String removeRights(Integer rightId){
		int count = jobRightBiz.removeById(rightId);
		
		return count+"";
	}
	
	
}
