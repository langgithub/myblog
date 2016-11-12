package com.demo.dao;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.demo.model.Admin;

@Transactional(readOnly=false,isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRES_NEW)
public interface AdminDao {
	public Admin checkAdmin(Admin admin);
	public String getPwd(int id);
	public int updateAdmin(Admin admin);
}
