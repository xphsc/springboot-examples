package com.xphsc.mybatis.model;

import com.baomidou.mybatisplus.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by ${huipei.x} on 2017-2-25.
 * qq群593802274
 */
@Data
public class User   extends Model<User> implements Serializable{


    private Integer id;
    private String uname;
    private String age;
    private String password;


    @Override
    protected Serializable pkVal() {
        return null;
    }
}

