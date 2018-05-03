package com.xphsc.beetlsql.model;

import lombok.Data;
import org.beetl.sql.core.annotatoin.Table;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by ${huipei.x} on 2017-2-25.
 *
 */
@Entity
@Table(name="t_user")
@Data
public class User implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String uname;
    private String age;
    private String password;




}

