package com.xphsc.mybatis.mapper;


import com.xphsc.mybatis.base.BaseMapper;


import com.xphsc.mybatis.model.User;
import com.xphsc.mybatis.model.UserDynamicSqlSupport;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.mybatis.dynamic.sql.render.RenderingStrategy;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;

import java.util.List;

import static org.mybatis.dynamic.sql.SqlBuilder.select;

/**
 * Created by ${huipei.x} on 2017-2-25.
 */
public interface UserMapper extends BaseMapper {


    @Results(id="userResult", value={
            @Result(column="id", property="id", id=true),
            @Result(column="uname", property="uname"),
            @Result(column="age", property="age"),
            @Result(column="password", property="password")
    })
   @SelectProvider(type=SqlProviderAdapter.class, method="select")
    List<User> selectMany(SelectStatementProvider selectStatement);
}
