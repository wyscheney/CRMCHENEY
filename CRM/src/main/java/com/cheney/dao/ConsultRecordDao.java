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
	/**
	 * 添加咨询记录
	 * @param consultRecord
	 * @return
	 */
	public int addConsultRecord(ConsultRecord consultRecord);
	
	/**
	 * 根据客户id 查找咨询记录
	 * @param customId
	 * @return
	 */
	public ConsultRecord selectByCustomId(@Param("customId")Integer customId);
    /**
     * 根据咨询师,以及
     * 用户名字,或者用户电话,或者分配的时间.
     * 查找相关的纪律
     * @param consultManId
     * @param customName
     * @param phoneNo
     * @param consultDate
     * @param endDate
     * @return
     */
	public List<ConsultRecord> queryRecord(@Param("consultManId")Integer consultManId,@Param("customName")String customName,@Param("phoneNo")String phoneNo,@Param("consultDate") Date consultDate,@Param("endDate")Date endDate);
	
	/**
	 * 根据咨询师,以及
     * 用户名字,或者用户电话,或者分配的时间.
     * 查找相关的纪律
	 * @param consultManId
	 * @param customName
	 * @param phoneNo
	 * @param consultDate
	 * @param endDate
	 * @return
	 */
	public List<Map<String, Object>> queryRecordMap(@Param("consultManId")Integer consultManId,@Param("customName")String customName,@Param("phoneNo")String phoneNo,@Param("consultDate") Date consultDate,@Param("endDate")Date endDate);

	/**
	 * 更新记录
	 * @param consultRecord
	 * @return
	 */
	public int updateRecord(ConsultRecord consultRecord);

	/**
	 * 跟新备注.
	 * @param id
	 * @param result
	 * @return
	 */
	public int addResult(@Param("id")Integer id,@Param("result")String result);
	/**
	 * 根据状态和跟进人查询条数.
	 * 如果跟进人的id =null 
	 * @param statu 传入的状态,如果是null ,查询所有的条数.
	 * @param consultManId 传入的跟进人id 如果是null 查询所有人.
	 * @return
	 */
	public int queryByStu(@Param("statu")String statu,@Param("consultManId")Integer[] consultManId);
}