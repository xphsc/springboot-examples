package com.xphsc.sql2o.dao.impl;

import com.xphsc.sql2o.base.impl.BaseDaoImpl;
import com.xphsc.sql2o.dao.UserDao;
import com.xphsc.sql2o.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ${huipei.x} on 2017-2-25
 */
@Repository
public class UserDaoImpl extends BaseDaoImpl implements UserDao  {

    public List listUser(){
        String sql = "SELECT * FROM t_user ";
         List<User>  users= this.getConnection().createQuery(sql).executeAndFetch(User.class);
        return users;
        }


}
