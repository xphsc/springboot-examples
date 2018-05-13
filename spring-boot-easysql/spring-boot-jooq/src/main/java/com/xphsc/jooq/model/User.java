package com.xphsc.jooq.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jooq.*;
import org.jooq.impl.TableImpl;

import java.io.Serializable;

/**
 * Created by ${huipei.x} on 2017-2-25.
 *
 */


@Data
public class User  extends TableImpl<Record> {

  /*  private Integer id;
    private String uname;
    private String age;
    private String password;
*/
    /**
     * The column <code>PUBLIC.CUSTOMER.ID</code>.
     */
    public final TableField<Record, Integer> id = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>PUBLIC.CUSTOMER.NAME</code>.
     */
    public final TableField<Record, String> uname = createField("uname", org.jooq.impl.SQLDataType.VARCHAR.length(20).nullable(false), this, "");

    /**
     * The column <code>PUBLIC.CUSTOMER.EMAIL</code>.
     */
    public final TableField<Record, String> age = createField("age", org.jooq.impl.SQLDataType.VARCHAR.length(50), this, "");





        public static final User t_user = new User();
    public User() {
        this("t_user", null);
    }
    public User(String alias) {
        this(alias, t_user);
    }

    public User(String alias, Table<Record> aliased) {
        this(alias, aliased, null);
    }

    public User(String alias, Table<Record> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

   /* public User(String name, Schema schema, Table<Record> aliased) {
        super(name, schema, aliased);
    }

    public User(String name, Schema schema, Table<Record> aliased, Field<?>[] parameters) {
        super(name, schema, aliased, parameters);
    }

    public User(String name, Schema schema, Table<Record> aliased, Field<?>[] parameters, String comment) {
        super(name, schema, aliased, parameters, comment);
    }

    *//**
         * The class holding records for this type
         *//*
        @Override
        public Class<Record> getRecordType() {
            return Record.class;
        }
*/


}

