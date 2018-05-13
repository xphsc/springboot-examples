package com.xphsc.mybatis.base.impl;

import com.xphsc.mybatis.base.BaseMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by ${huipei.x} on 2017-2-25.
 */
@Repository
public class BaseMapperImpl implements BaseMapper {
    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    public SqlSession getSqlSession(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession;
    }

    public SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }

    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }
}
