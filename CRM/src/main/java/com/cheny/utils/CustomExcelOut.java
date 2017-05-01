package com.cheny.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import com.cheney.entity.Custom;

public class CustomExcelOut {
	
	public byte[] getExcelBytes(List<Custom> customs) throws IOException{
		// 声明一个工作薄
	    HSSFWorkbook wb = new HSSFWorkbook();
	    //声明一个单子并命名
	    HSSFSheet sheet = wb.createSheet("客户信息表");
	    //给单子名称一个长度
	    sheet.setDefaultColumnWidth((short)15);
	    // 生成一个样式  
	    HSSFCellStyle style = wb.createCellStyle();
	    //创建第一行（也可以称为表头）
	    HSSFRow row = sheet.createRow(0);
	    //样式字体居中
	    style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
	    //给表头第一行一次创建单元格
	    HSSFCell cell = row.createCell((short) 0);
	    cell.setCellValue("id"); 
	    cell.setCellStyle(style);
	    cell = row.createCell( (short) 1);  
	    cell.setCellValue("name");  
	    cell.setCellStyle(style);  
	    cell = row.createCell( (short) 2);  
	    cell.setCellValue("education");  
	    cell.setCellStyle(style);
	    cell = row.createCell( (short) 3);  
	    cell.setCellValue("phoneNo");  
	    cell.setCellStyle(style);
	    cell = row.createCell( (short) 4);  
	    cell.setCellValue("qq");  
	    cell.setCellStyle(style);
	    cell = row.createCell( (short) 5);  
	    cell.setCellValue("email");  
	    cell.setCellStyle(style);
	    cell = row.createCell( (short) 6);  
	    cell.setCellValue("customStatu");  
	    cell.setCellStyle(style);
	    cell = row.createCell( (short) 7);  
	    cell.setCellValue("createDate");  
	    cell.setCellStyle(style);
	    cell = row.createCell( (short) 8);  
	    cell.setCellValue("inviteName");  
	    cell.setCellStyle(style);
	    
	    //向单元格里填充数据
	    for (short i = 0; i < customs.size(); i++) {
	    row = sheet.createRow(i + 1);
	    row.createCell(0).setCellValue(customs.get(i).getId());
	    row.createCell(1).setCellValue(customs.get(i).getName());
	    row.createCell(2).setCellValue(customs.get(i).getEducation());
	    row.createCell(3).setCellValue(customs.get(i).getPhoneNo());
	    if(customs.get(i).getQq()==null){
	    	row.createCell(4).setCellValue("");
	    }else{
	    	row.createCell(4).setCellValue(customs.get(i).getQq());
	    }
	    
	    	row.createCell(5).setCellValue(customs.get(i).getEmail());
	    	row.createCell(6).setCellValue(customs.get(i).getCustomStatu());
	    if(customs.get(i).getCreateDate()==null){
	    	row.createCell(7).setCellValue("");
	    }else{
	    	row.createCell(7).setCellValue(customs.get(i).getCreateDate());
	    }
	    	row.createCell(8).setCellValue(customs.get(i).getInviteName());
	    }
		
	    ByteArrayOutputStream os = new ByteArrayOutputStream();
		try {
			wb.write(os);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			byte[] b = os.toByteArray();
		
			os.close();
	      
	      return b;   

	}
}
