package com.xphsc.easysql.easyjdbc.model;


import lombok.Data;

import java.util.Date;

/**
 * {@link }
 * @author <a href="xiongpeih@163.com">huipei.x</a>
 * @description:
 * @date:
 * @since 0.1.0
 */
@Data
public class UserDTO {
    private Integer userId;
    private String  userName;
    private Integer age;
    private Integer sumAge;
    private String password;
    private Date createTime;
}
