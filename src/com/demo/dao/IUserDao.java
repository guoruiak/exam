package com.demo.dao;

import java.util.List;

import com.demo.entity.User;

public interface IUserDao {

	public User getUser(String id);
	
	public List<User> getAllUser();
	
	public void addUser(User user);
	
	public boolean delUser(String id);
	
	public boolean updateUser(User user);
}