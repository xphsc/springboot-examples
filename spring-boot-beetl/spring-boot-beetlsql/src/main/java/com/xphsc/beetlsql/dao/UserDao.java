package com.xphsc.beetlsql.dao;

import com.xphsc.beetlsql.base.BaseMapper;
import com.xphsc.beetlsql.model.User;
import org.beetl.sql.core.annotatoin.SqlStatement;
import org.springframework.stereotype.Repository;

/**
 * Created by ${huipei.x} on 2017-2-25
 */
@Repository
public interface UserDao  extends BaseMapper<User> {
    /**
     * 根据用户名查询用户信息
     *
     * @param uname 用户名
     * @return 用户信息
     */
    @SqlStatement(params = "uname")
    User findByName(String uname);

    /**
     * 根据用户Id查询用户信息
     *
     * @param id 用户id
     * @return 用户信息
     */
    @SqlStatement(params = "id")
    User findById(Integer id);
}
