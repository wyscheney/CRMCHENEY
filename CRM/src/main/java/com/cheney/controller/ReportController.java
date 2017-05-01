package com.cheney.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cheney.entity.Custom;
import com.cheney.service.CustomBiz;
import com.cheny.utils.CustomExcelOut;

@Controller
public class ReportController {
	
	@Resource
	private CustomBiz customBiz;
	
	@RequestMapping(value="exportCustom",produces="application/vnd.ms-excel")
	public @ResponseBody ResponseEntity<byte[]> exportCustom(Integer type,HttpServletResponse response) throws IOException{
		 
		//response.addHeader(name, value);
		List<Custom> list = customBiz.queryCustombyType(type);
		/*List<Custom> list =new ArrayList<Custom>();
		Custom custom=new Custom();
		custom.setName("wang");
		custom.setId(0);
		list.add(custom);*/
		
		CustomExcelOut co= new CustomExcelOut();
		byte[] b = co.getExcelBytes(list);
          
        HttpHeaders headers = new HttpHeaders();    
        String fileName=new String("客户信息表.xls".getBytes("UTF-8"),"iso-8859-1");//为了解决中文名称乱码问题  
        headers.setContentDispositionFormData("attachment", fileName);   
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);   
          
        return new ResponseEntity<byte[]>(b,headers, HttpStatus.CREATED);    
		
	
	}

}
