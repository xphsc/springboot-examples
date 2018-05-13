package com.xphsc.mybatis.base;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by ${huipei.x} on 2017-2-25.
 */

public interface BaseMapper {


    public SqlSession getSqlSession();
}
