package com.xphsc.kotlin.controller

import com.github.xphsc.http.Response
import com.xphsc.kotlin.model.response.UserDTO
import com.xphsc.kotlin.service.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by ${huipei.x} on 2017-2-25
 */
@RestController
 class UserController(private val userService: UserService) {

    @GetMapping("/listUser")
    fun listUser():Response{
      val result : List<UserDTO>  =userService.listUser();
        return Response.successResult(result);
    }
}