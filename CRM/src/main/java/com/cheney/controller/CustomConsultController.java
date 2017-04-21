package com.cheney.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cheney.entity.ConsultRecord;
import com.cheney.service.ConsultRecordBiz;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class CustomConsultController {
	
	@Resource
	private ConsultRecordBiz consultRecordBiz;
	
	@RequestMapping(value="queryRecord",produces="application/json; charset=UTF-8")
	public @ResponseBody String queryRecord(Integer consultManId,String customName,String customPhoneNo,Date consultDate,Date endDate){
		
		List<Map<String, Object>> maps = consultRecordBiz.queryRecordMap(consultManId, customName, customPhoneNo, consultDate, endDate);
		ObjectMapper mapper = new ObjectMapper();
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
		mapper.setDateFormat(sdf); 
		String json="";
		try {
			json=mapper.writeValueAsString(maps);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	}
	
	@RequestMapping("updateRecord")
	public String updateRecord(ConsultRecord consultRecord){
		int count =consultRecordBiz.updateRecord(consultRecord);
		return count+"";
		
	}
	
	@RequestMapping("addResult")
	public @ResponseBody String addResult(Integer id,String result){
		
		int count =consultRecordBiz.addResult(id,result);
		return count+"";
	}
	
	
	
	
}
