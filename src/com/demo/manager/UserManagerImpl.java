package com.demo.manager;

import java.util.List;

import com.demo.dao.IUserDao;
import com.demo.entity.User;

public class UserManagerImpl implements IUserManager {

	private IUserDao userDao;
	
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public User getUser(String id) {
		return userDao.getUser(id);
	}

	@Override
	public List<User> getAllUser() {
		return userDao.getAllUser();
	}

	@Override
	public void addUser(User user) {
		userDao.addUser(user);
	}

	@Override
	public boolean delUser(String id) {
		
		return userDao.delUser(id);
	}

	@Override
	public boolean updateUser(User user) {
		return userDao.updateUser(user);
	}

}