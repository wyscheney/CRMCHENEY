package com.cheney.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cheney.entity.Custominfo;
import com.cheney.service.CustomInfoBiz;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class CustomdevController {
	
	@Resource
	private CustomInfoBiz customInfoBiz;
	
	@RequestMapping(value="customInfo",produces = "application/json; charset=utf-8")
	public @ResponseBody String customInfo(Integer followManId,Integer src){
		
		System.out.println(src);
		List<Map<String,Object>> list = customInfoBiz.selaseSelect(followManId, src);
		
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("rows", list);
		
		ObjectMapper mapper = new ObjectMapper();
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");  
		mapper.setDateFormat(fmt);  
		String json="";
		try {
			json=mapper.writeValueAsString(map);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return json;
	}
	
	@RequestMapping("updateCustomInfo")
	public @ResponseBody String updateCustomInfo(Custominfo coustominfo){
		
		if(coustominfo.getPlanDate()==null){
			coustominfo.setPlanDate(new Date());
			coustominfo.setLastFollowDate(new Date());
			
		}
		int count = customInfoBiz.updateCustomInfo(coustominfo);
			
		return count+"";
	}
	@RequestMapping("addMark")
	public @ResponseBody String addMark(Custominfo coustominfo){
		int count = customInfoBiz.updateCustomInfo(coustominfo);
		return count+"";
	}
	
	
	
	
}
