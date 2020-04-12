package com.xphsc.easysql.easyjdbc.dao;

import com.xphsc.datasource.annotation.DynamicDataSource;
import com.xphsc.easyjdbc.annotation.*;
import com.xphsc.easyjdbc.core.EasyJdbcDao;
import com.xphsc.easysql.easyjdbc.model.User;
import com.xphsc.easysql.easyjdbc.model.UserDTO;
import com.xphsc.easysql.easyjdbc.sql.UserProvider;

import java.util.List;
import java.util.Map;

/**
 * {@link }
 * @author <a href="xiongpeih@163.com">huipei.x</a>
 * @description:
 * @date:
 * @since 0.1.0
 */
@EasyDao
@DynamicDataSource(value = "slave")
public  interface  UserDao extends EasyJdbcDao<User> {
    @SqlSelect(value = "select" +
            " *,id as user_id,age as sum_age " +
            "from " +
            "t_user",
            entityClass = UserDTO.class )
    public List<UserDTO> listUser();

    @SqlSelectProvider(type = UserProvider.class
            ,method = "listByMap",
            entityClass =UserDTO.class )
    public List<UserDTO> listUserByMap(Map map);

    @SqlInsertProvider(type = UserProvider.class,method = "insertByUser")
    Integer insertByUser(Map map);
    @SqlInsert(value = "INSERT INTO t_user(id,user_name) VALUES (:user.id,:user.userName)")
    @SqlOptions(useGeneratedKeys = true)
    Integer saveUser(@SqlParam("user") User user );


    @SqlSelect(value = "UPDATE   t_user set age=#{user.age}  ")
    Integer updateAge(@SqlParam("user") User user );

}
