package com.github.candyacao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.candyacao.bean.User;
import com.github.candyacao.dao.UserDao;
import com.github.candyacao.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	public User getUserById(String id) {
		return userDao.selectByPrimaryKey(id);
	}
}
