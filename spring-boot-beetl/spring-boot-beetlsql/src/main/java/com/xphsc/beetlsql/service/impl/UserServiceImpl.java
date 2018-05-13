package com.xphsc.beetlsql.service.impl;

import com.xphsc.beetlsql.dao.UserDao;
import com.xphsc.beetlsql.model.User;
import com.xphsc.beetlsql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ${huipei.x} on 2017-2-25
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public User getUserByname(String name){
        return userDao.findByName(name);
    }

    public List<User> listUser(){
        return userDao.all();
    }
}
