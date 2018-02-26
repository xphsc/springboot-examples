package com.xphsc.redis.controller;

import com.github.xphsc.http.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by ${huipei.x} on 2017-2-25.
 * qq群593802274
 */
@RestController
public class UserController {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;;

    @GetMapping("/listUser")
    public Response listUser(){
        Map<Object, Object> objectMap= stringRedisTemplate.opsForHash().entries("User");
        return Response.successResult(objectMap);
    }

}
