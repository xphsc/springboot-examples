package com.xphsc.sql2o.model;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by ${huipei.x} on 2017-2-25.
 *
 */


@Data
public class User implements Serializable{

    private Integer id;
    private String uname;
    private String age;
    private String password;




}

