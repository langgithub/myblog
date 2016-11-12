package com.demo.service;

import java.util.List;

import com.demo.model.User;

public interface UserService {

	public int insertUser(User user);
    public int queryId(String name);
    public User loginUser(User user);
    public List<User> queryUserList();
    public void deleteUser(int id);
}
