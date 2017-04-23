package com.cheney.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.cheney.constant.ConsultStatu;
import com.cheney.constant.CustomStatu;
import com.cheney.dao.ConsultRecordDao;
import com.cheney.dao.CustomDao;
import com.cheney.dao.EmployeeDao;
import com.cheney.entity.ConsultRecord;
import com.cheney.entity.Custom;
import com.cheney.service.ConsultRecordBiz;
@Service
public class ConsultRecordBizImpl implements ConsultRecordBiz {
	
	@Resource
	private ConsultRecordDao consultRecordDao;
	@Resource
	private CustomDao customDao;
	@Resource
	private EmployeeDao employeeDao;
	
	
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


	public List<ConsultRecord> queryRecord(Integer consultManId,String customName, String phoneNo, Date consultDate, Date endDate) {
		
		return consultRecordDao.queryRecord(consultManId,customName, phoneNo, consultDate, endDate);
	}
	
	
	public List<Map<String, Object>> queryRecordMap(Integer consultManId,String customName, String phoneNo, Date consultDate, Date endDate){
		
		
		return consultRecordDao.queryRecordMap(consultManId, customName, phoneNo, consultDate, endDate);
	}


	public int updateRecord(ConsultRecord consultRecord) {
		
		return consultRecordDao.updateRecord(consultRecord);
	}


	public int addResult(Integer id, String result) {
		
		return consultRecordDao.addResult(id,result);
	}


	public Map<String, Object> selectCountByConsultManId(Integer[] consultManId,Integer departmentId) {
		/*<th field="newAllot" width="100" align="center">新增客户数</th>
		<th field="following" width="100" align="center">紧跟客户数</th>
		<th field="signed" width="100" align="center">已报名客户数</th>
		<th field="denied" width="100" align="center">死单客户数</th>
		<th field="refundment" width="100" align="center">报名后退费客户数</th>
		<th field="total" width="100" align="center">总分配客户数</th>*/
		if(departmentId!=null){
			Integer[] ids = employeeDao.queryIdsByDeptId(departmentId);
			consultManId=ids;
		}
		
		
		int newAllot = consultRecordDao.queryByStu(ConsultStatu.NEW,consultManId);
		int following = consultRecordDao.queryByStu(ConsultStatu.FOLLOW, consultManId);
		int signed = consultRecordDao.queryByStu(ConsultStatu.SIGNED, consultManId);
		int denied = consultRecordDao.queryByStu(ConsultStatu.DEAD_ORDER, consultManId);
		int refundment = consultRecordDao.queryByStu(ConsultStatu.REFOND, consultManId);
		int total = consultRecordDao.queryByStu(ConsultStatu.TOTAL, consultManId);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("newAllot", newAllot);
		map.put("following", following);
		map.put("denied", denied);
		map.put("refundment", refundment);
		map.put("total", total);
		map.put("signed", signed);
		
		return map;
	}



}
