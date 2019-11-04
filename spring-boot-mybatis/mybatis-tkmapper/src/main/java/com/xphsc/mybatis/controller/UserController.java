package com.xphsc.mybatis.controller;

import com.github.xphsc.http.Response;
import com.xphsc.mybatis.model.response.UserDTO;
import com.xphsc.mybatis.service.UserService;
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
    private UserService userService;
    @GetMapping("/listUser")
    public Response listUser(){

        List<UserDTO> result= userService.listUser();
        return Response.successResult(result);
    }

}
