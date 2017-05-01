package com.cheny.utils;


import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.cheney.entity.Custom;
import java.io.IOException;  
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;  
 
import org.apache.poi.hssf.usermodel.HSSFCell;  
import org.apache.poi.hssf.usermodel.HSSFDateUtil;  
import org.apache.poi.hssf.usermodel.HSSFRow;  
import org.apache.poi.hssf.usermodel.HSSFSheet;  
import org.apache.poi.poifs.filesystem.POIFSFileSystem;  
  

/** 
* 操作Excel表格的功能类 
*/ 
public class CustomExcelIn {  
    private POIFSFileSystem fs;  
    private HSSFWorkbook wb;  //操作xls功能。
    private HSSFSheet sheet;  
    private HSSFRow row;  
  
    /** 
     * 读取Excel表格表头的内容 
     * @param InputStream 
     * @return String 表头内容的数组 
     */  
    @SuppressWarnings("deprecation")
	public String[] readExcelTitle(InputStream is) {  
        try {  
            fs = new POIFSFileSystem(is);  
            wb = new HSSFWorkbook(fs);  
            
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        sheet = wb.getSheetAt(0);  
        row = sheet.getRow(0);  
        // 标题总列数    
        int colNum = row.getPhysicalNumberOfCells();  
        //System.out.println("colNum:" + colNum);  
        String[] title = new String[colNum];  
        for (int i = 0; i < colNum; i++) {  
            //title[i] = getStringCellValue(row.getCell((short) i));  
            title[i] = getCellFormatValue(row.getCell((short) i));  
        }  
        return title;  
    }  
  
    /** 
     * 读取Excel数据内容 
     * @param InputStream 
     * @return list 包含单元格数据内容的Custom对象
     */ 
    public List<Custom> readExcelContent(InputStream is) {  
        List<Custom> customs=new ArrayList<Custom>();
        try {  
            fs = new POIFSFileSystem(is);  
            wb = new HSSFWorkbook(fs);  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        sheet = wb.getSheetAt(0);  
     // 得到总行数  
        int rowNum = sheet.getLastRowNum();  
        row = sheet.getRow(0);  
        int colNum = row.getPhysicalNumberOfCells();  
        // 正文内容应该从第二行开始,第一行为表头的标题 
        for (int i = 1; i <= rowNum; i++) {  
            row = sheet.getRow(i); 
            Custom custom =new Custom();
          //得到excel每个列的数据。
            for(int j=0;j<colNum;j++){
            	switch (j) {
				case 0:
					
					break;
				case 1:
					String name=getCellFormatValue(row.getCell((short)j)).trim();
					custom.setName(name);
					break;
				case 2:
					String education=getCellFormatValue(row.getCell((short)j)).trim();
					if("本科".equals(education)){
						custom.setEducation("1");
					}else if("大专".equals(education)){
						custom.setEducation("2");
					}else if("高中".equals(education)){
						custom.setEducation("3");
					}else if("硕士".equals(education)){
						custom.setEducation("4");
					}
					break;
				case 3:
					String phoneNo=getCellFormatValue(row.getCell((short)j)).trim();
					custom.setPhoneNo(phoneNo);
					break;
				case 4:
					String qq=getCellFormatValue(row.getCell((short)j)).trim();
					if(qq==null ||"".equals(qq)){
						custom.setQq(null);
					}else{
						custom.setQq(Integer.parseInt(qq));
					}
					
					
					break;
				case 5:
					String c_email=getCellFormatValue(row.getCell((short)j)).trim();
					custom.setEmail(c_email);
					break;
				case 6:
					String customStatu=getCellFormatValue(row.getCell((short)j)).trim();
					custom.setCustomStatu(customStatu);
					break;
				case 7:
					String createDate=getCellFormatValue(row.getCell((short)j)).trim();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");  
					try {
						custom.setCreateDate(sdf.parse(createDate));
					} catch (ParseException e) {
						e.printStackTrace();
					}
					break;
				case 8:
					String inviteName=getCellFormatValue(row.getCell((short)j)).trim();
					custom.setInviteName(inviteName);
					break;
				default:
					break;
				}
            	
            }
            customs.add(custom);
        }  
        return customs;  
    }  
  
    /** 
     * 获取单元格数据内容为日期类型的数据 
     *  
     * @param cell 
     *            Excel单元格 
     * @return String 单元格数据内容 
     */  
    private String getStringCellValue(HSSFCell cell) {  
        String strCell = "";  
        switch (cell.getCellType()) {  
        case HSSFCell.CELL_TYPE_STRING:  
            strCell = cell.getStringCellValue();  
            break;  
        case HSSFCell.CELL_TYPE_NUMERIC:  
            strCell = String.valueOf(cell.getNumericCellValue());  
            break;  
        case HSSFCell.CELL_TYPE_BOOLEAN:  
            strCell = String.valueOf(cell.getBooleanCellValue());  
            break;  
        case HSSFCell.CELL_TYPE_BLANK:  
            strCell = "";  
            break;  
        default:  
            strCell = "";  
            break;  
        }  
        if (strCell.equals("") || strCell == null) {  
            return "";  
        }  
        return strCell;  
    }  
  
    /** 
     * 获取单元格数据内容为字符串类型的数据 
     *  
     * @param cell Excel单元格 
     * @return String 单元格数据内容 
     */  
    private String getDateCellValue(HSSFCell cell) {  
        String result = "";  
        try {  
            int cellType = cell.getCellType();  
            if (cellType == HSSFCell.CELL_TYPE_NUMERIC) {  
                Date date = cell.getDateCellValue();  
                result = (date.getYear() + 1900) + "-" + (date.getMonth() + 1)  
                        + "-" + date.getDate();  
            } else if (cellType == HSSFCell.CELL_TYPE_STRING) {  
                String date = getStringCellValue(cell);  
                result = date.replaceAll("[����]", "-").replace("��", "").trim();  
            } else if (cellType == HSSFCell.CELL_TYPE_BLANK) {  
                result = "";  
            }  
        } catch (Exception e) {  
            System.out.println("���ڸ�ʽ����ȷ!");  
            e.printStackTrace();  
        }  
        return result;  
    }  
  
    /** 
     * 根据HSSFCell类型设置数据 
     * @param cell 
     * @return 
     */  
    private String getCellFormatValue(HSSFCell cell) {  
        String cellvalue = "";  
        if (cell != null) {  
            // 判断当前Cell的Type  
            switch (cell.getCellType()) {  
            // 如果当前Cell的Type为NUMERIC  
            case HSSFCell.CELL_TYPE_NUMERIC:  
            case HSSFCell.CELL_TYPE_FORMULA: {  
                // 判断当前的cell是否为Date  
                if (HSSFDateUtil.isCellDateFormatted(cell)) {  
                    // 如果是Date类型则，转化为Data格式  
                      
                    //方法1：这样子的data格式是带时分秒的：2011-10-12 0:00:00  
                    //cellvalue = cell.getDateCellValue().toLocaleString();  
                      
                    //方法2：这样子的data格式是不带带时分秒的：2011-10-12  
                    Date date = cell.getDateCellValue();  
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
                    cellvalue = sdf.format(date);  
                      
                }  
                // 如果是纯数字  
                else {  
                    // 取得当前Cell的数值  
                    //cellvalue = String.valueOf(cell.getNumericCellValue());  
                    DecimalFormat df = new DecimalFormat("#");
                    cellvalue =df.format(cell.getNumericCellValue());
                    
                    
                }  
                break;  
            }  
            // 如果当前Cell的Type为STRIN  
            case HSSFCell.CELL_TYPE_STRING:  
                // 取得当前的Cell字符串  
                cellvalue = cell.getRichStringCellValue().getString();  
                break;  
            // 默认的Cell值  
            default:  
                cellvalue = " ";  
            }  
        } else {  
            cellvalue = "";  
        }  
        return cellvalue;  
  
    }    
  

}  
