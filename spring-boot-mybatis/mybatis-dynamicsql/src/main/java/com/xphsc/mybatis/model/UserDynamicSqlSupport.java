package com.xphsc.mybatis.model;

import lombok.Data;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import java.sql.JDBCType;

/**
 * Created by ${huipei.x} on 2018-5-6.
 */

public class UserDynamicSqlSupport {
    public static final User user = new User();
    public static final SqlColumn<Integer> id = user.id;
    public static final SqlColumn<String> uname = user.uname;
    public static final SqlColumn<String> age = user.age;
    public static final SqlColumn<String> password = user.password;

    public static final class User extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);
        public final SqlColumn<String> uname = column("uname", JDBCType.VARCHAR);
        public final SqlColumn<String> age = column("age", JDBCType.VARCHAR);
        public final SqlColumn<String> password = column("password", JDBCType.VARCHAR);

        public User() {
            super("t_user");
        }


    }

    public static User getUser() {
        return user;
    }

    public static SqlColumn<Integer> getId() {
        return id;
    }

    public static SqlColumn<String> getUname() {
        return uname;
    }

    public static SqlColumn<String> getAge() {
        return age;
    }

    public static SqlColumn<String> getPassword() {
        return password;
    }
}
