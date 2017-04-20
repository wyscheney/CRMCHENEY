package com.cheney.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.cheney.entity.ConsultRecord;
@Repository
public interface ConsultRecordDao {

	public int addConsultRecord(ConsultRecord consultRecord);
	
	
	public ConsultRecord selectByCustomId(@Param("customId")Integer customId);
 
}