package com.xphsc.jersey.controller;


import com.xphsc.jersey.model.response.UserDTO;
import com.xphsc.jersey.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

/**
 * Created by ${huipei.x} on 2017-2-25.
 */

@Path("/user")
@Transactional
@Component
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findUserByid(@PathParam("id")Integer id){
        UserDTO result= userService.findUserByid(id);
        return Response.ok(result).build();
    }

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findUser(){
        List<UserDTO> result= userService.listUser();
        return Response.ok(result).build();

    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addUser(UserDTO userDTO) {
        UserDTO us= userService.addUser(userDTO);
        if (us==null) {
            log.info("user already exits.");
            return Response.status(Response.Status.CONFLICT).build();
        }
        return Response.created(URI.create("/user/" + us.getId())).build();
    }



}
