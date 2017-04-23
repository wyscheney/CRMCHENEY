package com.cheney.service;

import java.util.List;

import com.cheney.entity.Resetpass;

public interface ResetPassBiz {

	public List<Resetpass> queryAllResetPass();
	
	
	public int resetPass(Resetpass Resetpass);

}
