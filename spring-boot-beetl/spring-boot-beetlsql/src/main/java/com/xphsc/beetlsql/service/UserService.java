package com.xphsc.beetlsql.service;

import com.xphsc.beetlsql.model.User;

import java.util.List;

/**
 * Created by ${huipei.x} on 2017-2-25
 */
public interface UserService {
    public List<User> listUser();
    public User getUserByname(String name);
}
