package com.xphsc.hibernate.model;

import lombok.Data;


import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ${huipei.x} on 2017-2-25.
 * qq群593802274
 */
@Data
@Entity(name="t_user")
//@Table(name="t_user")
public class User implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String uname;
    private String age;
    private String password;




}

