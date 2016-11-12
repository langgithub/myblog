package com.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.AdminDao;
import com.demo.model.Admin;
import com.demo.service.AdminService;

@Service
public class AdminServiceImple implements AdminService{

	@Autowired
	private AdminDao adminDao;
	
	public Admin checkAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return adminDao.checkAdmin(admin);
	}

	public int updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return adminDao.updateAdmin(admin);
	}

	public String getPwd(int id) {
		// TODO Auto-generated method stub
		return adminDao.getPwd(id);
	}

}
