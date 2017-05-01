package com.cheney.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cheney.entity.Jobinfo;
import com.cheney.service.JobinfoBiz;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class JobManagerController {
	@Resource
	private JobinfoBiz jobinfoBiz;
	
	@RequestMapping(value ="queryAllJobs",produces="application/json;charset=utf-8")
	public @ResponseBody String queryAllJobs(){
		List<Jobinfo> jobinfos = jobinfoBiz.queryAllJobinfo(null);
		
		ObjectMapper mapper = new ObjectMapper();
		String json="";
		try {
			json=mapper.writeValueAsString(jobinfos);
		} catch (JsonProcessingException e) {
			
			e.printStackTrace();
		}
		return json;
	}
	@RequestMapping("insertJob")
	public @ResponseBody String insertJob(Jobinfo jobinfo){
		int count = jobinfoBiz.insert(jobinfo);
		return count+"";
	}
	
	@RequestMapping("updateJob")
	public @ResponseBody String updateJob(Jobinfo jobinfo){
		
		int count =jobinfoBiz.update(jobinfo);
		
		
		return count+"";
	}
	@RequestMapping("deleteJob")
	public @ResponseBody String deleteJob(Integer id){
		int count = jobinfoBiz.delete(id);
		
		return count+"";
	}
}
