package com.github.candyacao.dao;

import com.github.candyacao.bean.User;

public interface UserDao {
	
	    int deleteByPrimaryKey(String id);
	    int insert(User record);
	    int insertSelective(User record);
	    User selectByPrimaryKey(String id);
	    int updateByPrimaryKeySelective(User record);
	    int updateByPrimaryKey(User record);
		User selectByUsernameAndPasswd(User user);
		User selectByUsername(String username);
}
