package com.xphsc.hibernate.controller;

import com.github.xphsc.http.Response;
import com.xphsc.hibernate.model.User;
import com.xphsc.hibernate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by ${huipei.x} on 2017-2-25.
 *
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/listUser")
    public Response listUser(){
        List<User> result= userService.listUser();
        return Response.successResult(result);
    }

}
