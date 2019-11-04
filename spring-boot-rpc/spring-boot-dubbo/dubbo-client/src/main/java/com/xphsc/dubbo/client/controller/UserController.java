package com.xphsc.dubbo.client.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.xphsc.http.Response;
import com.xphsc.dubbo.api.model.response.UserDTO;
import com.xphsc.dubbo.api.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by ${huipei.x} on 2017-2-25.
 * qq群593802274
 */
@RestController
public class UserController {

    @Reference
    private UserService userService;

    @GetMapping("/listUser")
    public Response listUser(){
        List<UserDTO> result= userService.listUser();
        return Response.successResult(result);
    }

}
