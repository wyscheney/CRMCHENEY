package com.cheney.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cheney.constant.ConsultStatu;
import com.cheney.constant.CustomStatu;
import com.cheney.dao.ConsultRecordDao;
import com.cheney.dao.CustomDao;
import com.cheney.entity.ConsultRecord;
import com.cheney.entity.Custom;
import com.cheney.service.ConsultRecordBiz;
@Service
public class ConsultRecordBizImpl implements ConsultRecordBiz {
	
	@Resource
	private ConsultRecordDao consultRecordDao;
	@Resource
	private CustomDao customDao;
	
	
	public int allotToConsult(Integer consultManId, Integer customId) {
		int count =0;
		Custom custom =new Custom();
		custom.setId(customId);
		custom.setCustomStatu(CustomStatu.CONSULTING);
		customDao.updateCustom(custom);
		
		
		ConsultRecord consultRecord=new ConsultRecord(customId, consultManId, ConsultStatu.NEW, new Date());
		
		ConsultRecord cr = consultRecordDao.selectByCustomId(customId);
		if(cr==null){
			count= consultRecordDao.addConsultRecord(consultRecord);
		}
		return count;
	}

}
