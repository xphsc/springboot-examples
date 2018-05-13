package com.xphsc.mybatis.mapper;

import com.baomidou.mybatisplus.annotations.SqlParser;
import com.xphsc.mybatis.base.BaseMapper;
import com.xphsc.mybatis.model.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by ${huipei.x} on 2017-2-25.
 */
public interface UserMapper extends BaseMapper<User> {
    @SqlParser(filter = true)
    @Select("select id as id, uname, age, password from t_user")
    public List<User> selectListBySQL();
}
