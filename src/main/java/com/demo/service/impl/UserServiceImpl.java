package com.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.demo.dao.UserDao;
import com.demo.model.User;
import com.demo.service.UserService;
 
 
 
@Service
public class UserServiceImpl implements UserService{
 
    @Autowired
    private UserDao userDao;
     
    public int insertUser(User user) {
    	return userDao.insertUser(user);
    }

	public int queryId(String name) {
		// TODO Auto-generated method stub
		return userDao.queryId(name);
	}

	public User loginUser(User user) {
		// TODO Auto-generated method stub
		return userDao.loginUser(user);
	}

	public List<User> queryUserList() {
		// TODO Auto-generated method stub
		return userDao.queryUserList();
	}

	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		userDao.deleteUser(id);
	}
 
}