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

    public User login(User user) {
        return userDao.selectByUsernameAndPasswd(user);
    }

    public boolean saveUser(User user) {
        int times = 5;
        int num = userDao.insertSelective(user);
        while (times > 0) {
            if (num <= 0) {
                times--;
                System.out.println("重新次数："+times);
            } else {
                break;
            }
        }
        return num > 0;
    }

    public User getUserById(String id) {
        return userDao.selectByPrimaryKey(id);
    }
}
