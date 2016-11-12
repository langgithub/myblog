package com.demo.dao;

import java.util.List;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.demo.model.User;
@Transactional(propagation=Propagation.REQUIRES_NEW,readOnly=false,isolation=Isolation.DEFAULT)
public interface UserDao {
	public int insertUser(User user);
	public int queryId(String name);
	public User loginUser(User user);
	public List<User> queryUserList();
	public void deleteUser(int id);
}
