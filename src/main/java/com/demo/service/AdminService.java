package com.demo.service;

import com.demo.model.Admin;

public interface AdminService {

	public Admin checkAdmin(Admin admin);
	public int updateAdmin(Admin admin);
	public String getPwd(int id);
}
