package com.demo.dao;

import java.util.List;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.demo.model.LoginLog;

@Transactional(readOnly=false,isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRES_NEW)
public interface LoginLogDao {

	public void insertLoginLog(LoginLog loginLog);
	public List<LoginLog> queryLoginLogList();
	public void deleteLoginOne(int id);
}
