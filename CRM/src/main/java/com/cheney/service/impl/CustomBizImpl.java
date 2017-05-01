package com.cheney.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cheney.constant.CustomStatu;
import com.cheney.dao.CustomDao;
import com.cheney.dao.CustominfoDao;
import com.cheney.dao.EmployeeDao;
import com.cheney.entity.Custom;
import com.cheney.entity.Custominfo;
import com.cheney.entity.Employee;
import com.cheney.service.CustomBiz;

@Service
public class CustomBizImpl implements CustomBiz {
	
	@Resource
	private CustomDao customDao;
	@Resource
	private EmployeeDao employeeDao;
	
	@Resource
	private CustominfoDao custominfo;
	
	
	public int insertCustom(Custom custom) {
		int count = customDao.insertCustom(custom);
		//System.out.println(custom.getId());
		return count;
	}


	public List<Custom> queryCustom(Custom custom) {
		return customDao.queryCustom(custom);
	}


	public int updateCustom(Custom custom) {
		String customStatu = custom.getCustomStatu();
		return customDao.updateCustom(custom);
	}

	/**
	 * 自动分配客户
	 */
	public int allotCustom() {
		//获取订单编号
		Integer[] ids = customDao.selectIdsByStatus(CustomStatu.NONE_VISITED);
		
		//获取所有销售员
		List<Employee> salses = employeeDao.selectEmployBydepaartmentId(2,8);
		List<Custominfo> custominfos =new ArrayList<Custominfo>();
		//订单数量
		int i = ids.length;
		if(i<=0){
			return 0;
		}
		//销售员数量
		int s = salses.size();
		
		//如果订单数量大于销售员
		if(i/s >0){
			//根据倍数遍历
			for (int j = 0; j < i/s; j++) {
				//定义销售员下标
				int count = 0;	
				//根据倍数遍历
				for (int k = j*s; k < (j+1)*s; k++) {
						Custominfo Custominfo =new Custominfo(ids[k], salses.get(count).getId(), "0", new Date());
						custominfos.add(Custominfo);
						count++;
					}
			}
		}
		int sid = i/s *s;
		for(int j = sid ; j<ids.length;j++){
			Random random = new Random();
		    int r = random.nextInt(salses.size());
			Custominfo Custominfo =new Custominfo(ids[j], salses.get(r).getId(), "0", new Date());
			custominfos.add(Custominfo);
		}
		
		
		int addcustominfos = custominfo.addcustominfos(custominfos);
		
		int count = customDao.updateTOSalse(ids);
		
		return count;
	}


	public int insertCustoms(List<Custom> customs) {
		
		return customDao.insertCustoms(customs);
	}


	public List<Custom> queryCustombyType(Integer type) {
		if(type==1){
			return customDao.queryCustomByWeek();
		}else if(type==2){
			return customDao.queryCustomByMonth();
		}else{
			return customDao.queryAllCustom();
		}
	}

}
