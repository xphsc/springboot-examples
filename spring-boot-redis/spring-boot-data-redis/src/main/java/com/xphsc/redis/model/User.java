package com.xphsc.redis.model;

import lombok.Data;

import java.io.Serializable;

/**
 *  Created by ${huipei.x} on 2017-2-25
 */
@Data
public class User implements Serializable {
    private String id;
    private String name;
}
