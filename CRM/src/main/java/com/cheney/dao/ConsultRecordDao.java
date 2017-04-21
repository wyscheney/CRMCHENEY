package com.cheney.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.cheney.entity.ConsultRecord;
@Repository
public interface ConsultRecordDao {

	public int addConsultRecord(ConsultRecord consultRecord);
	
	
	public ConsultRecord selectByCustomId(@Param("customId")Integer customId);

	public List<ConsultRecord> queryRecord(@Param("consultManId")Integer consultManId,@Param("customName")String customName,@Param("phoneNo")String phoneNo,@Param("consultDate") Date consultDate,@Param("endDate")Date endDate);
	
	
	public List<Map<String, Object>> queryRecordMap(@Param("consultManId")Integer consultManId,@Param("customName")String customName,@Param("phoneNo")String phoneNo,@Param("consultDate") Date consultDate,@Param("endDate")Date endDate);


	public int updateRecord(ConsultRecord consultRecord);


	public int addResult(@Param("id")Integer id,@Param("result")String result);
}