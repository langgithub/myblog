package com.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.LoginLogDao;
import com.demo.model.LoginLog;
import com.demo.service.LoginLogService;

@Service
public class LoginLogServiceImpl implements LoginLogService{

	@Autowired
	private LoginLogDao loginLogDao;
	
	public void insertLoginLog(LoginLog loginLog) {
		// TODO Auto-generated method stub
		System.out.println("===befor=================");
		loginLogDao.insertLoginLog(loginLog);
		System.out.println("===after================");
	}

	public List<LoginLog> queryLoginLogList() {
		// TODO Auto-generated method stub
		return loginLogDao.queryLoginLogList();
	}

	public void deleteLoginOne(int id) {
		// TODO Auto-generated method stub
		loginLogDao.deleteLoginOne(id);
	}

}
