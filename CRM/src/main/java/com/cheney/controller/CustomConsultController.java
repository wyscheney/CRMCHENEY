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
	/**
	 * 分页暂时使用sublist来替代,实际使用可以把page和rows传入后台,用limit控制.把fromIndex和toIndex传入
	 * @param consultManId
	 * @param customName
	 * @param customPhoneNo
	 * @param consultDate
	 * @param endDate
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping(value="queryRecord",produces="application/json; charset=UTF-8")
	public @ResponseBody String queryRecord(Integer consultManId,String customName,String customPhoneNo,Date consultDate,Date endDate,Integer page,Integer rows){
		
		List<Map<String, Object>> maps = consultRecordBiz.queryRecordMap(consultManId, customName, customPhoneNo, consultDate, endDate);
		int fromIndex = (page-1)*rows;
		int toIndex =page*rows;
		if(toIndex>maps.size()){
			toIndex=maps.size();
		}
		List<Map<String, Object>> subList = maps.subList(fromIndex, toIndex);
		
		ObjectMapper mapper = new ObjectMapper();
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
		mapper.setDateFormat(sdf); 
		String json="";
		try {
			json=mapper.writeValueAsString(subList);
		} catch (JsonProcessingException e) {
			
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
