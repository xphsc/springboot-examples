package com.xphsc.jdbc.service.impl;


import com.xphsc.jdbc.dao.UserDao;
import com.xphsc.jdbc.service.UserService;
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

    public List listUser(){
        String sql="select * FROM t_user";
        return  userDao.queryForList(sql,null);
    }

}
