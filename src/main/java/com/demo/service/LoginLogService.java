package com.demo.service;

import java.util.List;

import com.demo.model.LoginLog;

public interface LoginLogService {

	public void insertLoginLog(LoginLog loginLog);
	public List<LoginLog> queryLoginLogList();
	public void deleteLoginOne(int id);
}
