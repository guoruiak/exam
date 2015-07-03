package com.demo.manager;

import java.util.List;

import com.demo.dao.IUserDao;
import com.demo.entity.User;

public class WebServiceImpl implements IWebService {
	private IUserDao userDao;
	
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}
	@Override
	public List<User> getAllUser() {
		return userDao.getAllUser();
	}

}
