package com.xphsc.swagger.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by ${huipei.x} on 2017-2-25.
 *
 */


@Data
@ApiModel(description="User查询类")
public class User implements Serializable{
    @ApiModelProperty("id")
    private Integer id;
    @ApiModelProperty("用户名")
    private String uname;
    @ApiModelProperty("年龄")
    private String age;
    @ApiModelProperty("密码")
    private String password;




}

