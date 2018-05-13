package com.xphsc.mybatis.service.impl;

import com.github.xphsc.bean.BeanByRefMapper;
import com.github.xphsc.collect.Lists;
import com.xphsc.mybatis.mapper.UserMapper;

import com.xphsc.mybatis.model.User;
import com.xphsc.mybatis.model.UserDynamicSqlSupport;
import com.xphsc.mybatis.service.UserService;

import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.render.RenderingStrategy;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.mybatis.dynamic.sql.SqlBuilder.isNotBetween;
import static org.mybatis.dynamic.sql.select.SelectDSL.select;


/**
 * Created by ${huipei.x} on 2017-2-25.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public  List<User> listAll(){
        UserDynamicSqlSupport.User user=new UserDynamicSqlSupport.User();
     //  UserMapper mapper = userMapper.getSqlSession().getMapper(UserMapper.class);
        SelectStatementProvider selectStatement = select(user.id, user.uname)
                .from(user)
                .where(user.id, SqlBuilder.isEqualTo(1))
                .build()
                .render(RenderingStrategy.MYBATIS3);
        List<User> userlist = userMapper.selectMany(selectStatement);
        return userlist;
    }



}
