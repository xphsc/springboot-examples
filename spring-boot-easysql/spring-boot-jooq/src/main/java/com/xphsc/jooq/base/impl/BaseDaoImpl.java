package com.xphsc.jooq.base.impl;


import com.xphsc.jooq.base.BaseDao;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;


/**
 * Created by ${huipei.x} on 2017-2-25
 */
@Repository
public class BaseDaoImpl implements BaseDao {
    @Autowired
    private DSLContext dslContext;

    public DSLContext getDslContext() {
        return dslContext;
    }



}
