package com.xphsc.hibernate.service.impl;

import com.xphsc.hibernate.dao.UserDao;
import com.xphsc.hibernate.model.User;
import com.xphsc.hibernate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ${huipei.x} on 2017-2-25
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> listUser(){
        return   userDao.findAll(User.class);
    }
}
