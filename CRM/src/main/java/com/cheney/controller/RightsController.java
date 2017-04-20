package com.cheney.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cheney.entity.Rights;
import com.cheney.service.RightsBiz;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class RightsController {
	
	@Resource
	private RightsBiz rightsBiz;
	
	@RequestMapping(value="queryAllRights",produces = "application/json; charset=utf-8")
	public @ResponseBody String queryRights(){
		
		List<Rights> rights = rightsBiz.queryAllRights();
		for (Rights r : rights) {
			System.out.println(r);
		}
		
		ObjectMapper mapper =new ObjectMapper();
		String rightsJason=null;
		try {
			rightsJason = mapper.writeValueAsString(rights);
			System.out.println(rightsJason);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		}
		
		
		return rightsJason;
	}
	
}
