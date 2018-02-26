package com.xphsc.mongo.controller;

import com.github.xphsc.http.Response;
import com.xphsc.mongo.model.MongoUser;
import com.xphsc.mongo.repository.dao.MongoUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by ${huipei.x} on 2017-2-25.
 * qq群593802274
 */
@RestController
public class UserController {
    @Autowired
    private MongoUserDao mongoUserDao;

    @GetMapping("/listUser")
    public Response listUser(){
        List<MongoUser> result= mongoUserDao.findAll();
        return Response.successResult(result);
    }

}
