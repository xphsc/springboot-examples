package com.xphsc.easysql.easyjdbc.sql;


import com.alibaba.fastjson.JSON;
import com.github.xtool.collect.Maps;
import com.xphsc.easyjdbc.builder.SQL;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * {@link }
 * @author <a href="xiongpeih@163.com">huipei.x</a>
 * @description:
 * @date:
 * @since 0.1.0
 */
@Slf4j
public class UserProvider {

    public String list(Map<String, Object> ParamsMap){
      // Map map ;
       return new SQL(){{
            SELECT("*")
            .FROM("t_user")
            .WHERE("id=:id");
       }

        }.toString();

    }
    public String list1(){
        return SQL.BUILD().SELECT("*").FROM("t_user").toString();
    }

    public String updateByUser(Map<String, Object> ParamsMap){
        SQL sql=SQL.BUILD();
        sql.UPDATE("t_user_copy");
        sql.SET("user_name=#{userName}");
        sql.WHERE("id=#{id}");
        return sql.toString();
    }
    public String insertByUser(Map<String, Object> ParamsMap){
        SQL sql=SQL.BUILD();
        sql.INSERT_INTO("t_user");
        sql.VALUES("id,user_name",
                "#{id},#{userName}");
        return sql.toString();
    }
    public String listByMap(Map<String, Object> paramsMap){
       SQL sql=SQL.BUILD();
       log.info("paramsMap:"+ JSON.toJSON(paramsMap));
        sql.SELECT("*,age as sum_age,id as user_id").FROM("t_user");
        if(Maps.containsKey(paramsMap,"id")){
            if( Maps.getInteger(paramsMap,"id")!=null){
                sql.WHERE("id=:id");
            }
        }
        return sql.toString();
    }

}
