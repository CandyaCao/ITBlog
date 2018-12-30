package com.github.candyacao.service;

import com.github.candyacao.bean.User;

public interface UserService {
	/**
	 * 根据ID获取用户信息
	 */
	public User getUserById(String id);
}
