package com.xphsc.easysql.easyjdbc.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * {@link }
 * @author <a href="xiongpeih@163.com">huipei.x</a>
 * @description:
 * @date:
 * @since 0.1.0
 */
@Data
@Entity
@Table(name="t_user")
public class User implements Serializable {
    @Id
    @GeneratedValue
     Integer id;
    @Column(name="user_name")
    private String  userName;
    private Integer age;
    private String password;
    @Column(name="create_time")
       private Date createTime;
    public Integer getId() {
        return id;
    }

    public  void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public  Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
