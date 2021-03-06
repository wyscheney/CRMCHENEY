package com.cheney.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.omg.CORBA.Request;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.cheney.constant.CustomStatu;
import com.cheney.entity.Custom;
import com.cheney.entity.Custominfo;
import com.cheney.entity.Employee;
import com.cheney.service.ConsultRecordBiz;
import com.cheney.service.CustomBiz;
import com.cheney.service.CustomInfoBiz;
import com.cheney.service.UserBiz;
import com.cheny.utils.CustomExcelIn;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.fabric.xmlrpc.base.Data;

@Controller
public class CustomController {
	
	@Resource
	private CustomBiz customBiz;
	
	@Resource
	private UserBiz userBiz;
	
	@Resource
	private ConsultRecordBiz consultRecordBiz;
	@Resource
	private CustomInfoBiz customInfoBiz;
	
	
	//添加客户
	@RequestMapping("insertCustom")
	public @ResponseBody String insertCustom(Custom custom,HttpServletRequest request){
		HttpSession session = request.getSession();
		Employee user = (Employee) session.getAttribute("user");
		custom.setInviteName(user.getRealname()); 
		custom.setCreateDate(new Date());
		 
		int count = customBiz.insertCustom(custom);
		System.out.println(user.getJobInfo());
		if(user.getJobInfoId()==5){
			Custominfo custominfo = new Custominfo(custom.getId(), user.getId(), "0", new Date());	
			count=customInfoBiz.insertCustomInfo(custominfo);
		}
		return count+"";
	}
	
	
	//查询所有客户信息
	@RequestMapping(value="queryCustom",produces = "application/json; charset=utf-8")
	public @ResponseBody String queryCustom(Custom custom,Integer page,Integer rows){
		
		List<Custom> list = customBiz.queryCustom(custom);
		int fromIndex = (page-1)*rows;
		int toIndex =page*rows;
		if(toIndex>list.size()){
			toIndex=list.size();
		}
		
		List<Custom> subList = list.subList(fromIndex, toIndex);
		
		
		ObjectMapper mapper =new ObjectMapper();
		
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");  
		mapper.setDateFormat(fmt);  
		
		String customResult ="";
		
		try {
			customResult=mapper.writeValueAsString(subList);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "{\"total\":"+list.size()+",\"rows\":"+customResult+"}";
	};
	
	//修改客户信息
	@RequestMapping("updateCustom")
	public @ResponseBody String updateCustom(Custom custom){
		
		int count = customBiz.updateCustom(custom);
		return count+"";
	}
	
	
	
	
	@RequestMapping("allotToConsult")
	public @ResponseBody String allotCustom(Integer consultManId,Integer customId){
		int count = consultRecordBiz.allotToConsult(consultManId,customId);
		return count+"";
	}
	
	
	//获取所有咨询师界面
	@RequestMapping(value ="queryConsulters",produces = "application/json; charset=utf-8")
	public @ResponseBody String Consulters(){
		
		List<Employee> employees = userBiz.queryByJobInfo(3);
		ObjectMapper mapper =new ObjectMapper();
		String e="";
		try {
			e = mapper.writeValueAsString(employees);
		} catch (JsonProcessingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return e;
	}
	@RequestMapping("allotCustom")
	public @ResponseBody String allotCustom(){
		int count = customBiz.allotCustom();
		return count>0?"1":"0";
	}
	
	@RequestMapping("batchImportCustom")
	public @ResponseBody String batchImportCustom(@RequestParam("file") CommonsMultipartFile file){
		CustomExcelIn exceReader = new CustomExcelIn();
		int count = 0;
		try {
			InputStream is = file.getInputStream();
			List<Custom> list = exceReader.readExcelContent(is);
			count = customBiz.insertCustoms(list);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count>0?"1":"0";
	}
	
}
