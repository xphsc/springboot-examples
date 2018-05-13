package com.xphsc.beetlsql.model;

import lombok.Data;
import org.beetl.sql.core.annotatoin.Table;


import java.io.Serializable;

/**
 * Created by ${huipei.x} on 2017-2-25.
 *
 */

@Table(name="t_user")
@Data
public class User implements Serializable{

    private Integer id;
    private String uname;
    private String age;
    private String password;




}

