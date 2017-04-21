package com.cheney.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.cheney.entity.ConsultRecord;

public interface ConsultRecordBiz {
	
	/**
	 * 分配咨询师
	 * @param consultManId
	 * @param customId
	 * @return
	 */
	public int allotToConsult(Integer consultManId, Integer customId);
	/**
	 * 根据查询条件查询记录.
	 * @param consultRecord
	 * @param consultDate
	 * @param endDate
	 * @return
	 * @throws ParseException 
	 */
	public List<ConsultRecord> queryRecord(Integer consultManId,String customName,String phoneNo, Date consultDate, Date endDate);
	
	public List<Map<String, Object>> queryRecordMap(Integer consultManId,String customName, String phoneNo, Date consultDate, Date endDate);
	
	
	public int updateRecord(ConsultRecord consultRecord);
	
	/**
	 * 添加备注
	 * @param id
	 * @param result
	 * @return
	 */
	public int addResult(Integer id, String result);
}
