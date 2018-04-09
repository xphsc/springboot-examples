package com.xphsc.hibernate.dao.impl;

import com.xphsc.hibernate.base.BaseDaoImpl;
import com.xphsc.hibernate.dao.UserDao;
import com.xphsc.hibernate.model.User;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * Created by ${huipei.x} on 2017-2-25
 */
@Repository
public class UserDaoImpl extends BaseDaoImpl<User,Serializable> implements UserDao {
}
