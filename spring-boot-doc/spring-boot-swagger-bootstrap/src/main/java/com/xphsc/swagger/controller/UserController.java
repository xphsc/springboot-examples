package com.xphsc.swagger.controller;

import com.xphsc.swagger.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *Created by ${huipei.x} on 2017-2-25
 */
@RestController
@Api(tags = "/user",description="用户")
public class UserController {

    @GetMapping("/querrString")
    @ApiOperation(value="swagger测试", response = User.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = User.class),
            @ApiResponse(code = 500, message = "Internal Server Error") })
    public String querrString(){
        return "swagger测试";
    }
}
