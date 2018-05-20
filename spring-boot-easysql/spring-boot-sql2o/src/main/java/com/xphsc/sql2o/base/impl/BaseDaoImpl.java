package com.xphsc.sql2o.base.impl;

import com.xphsc.sql2o.base.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

/**
 * Created by ${huipei.x} on 2017-2-25
 */
@Repository
public class BaseDaoImpl implements BaseDao {
    @Autowired
    private Sql2o sql2o;


    public Connection getConnection(){
        Connection con = sql2o.open();
        return con;
    }



}
