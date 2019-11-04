package com.xphsc.resteasy.resource;


import com.xphsc.resteasy.model.User;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


/**
 * Created by ${huipei.x} on 2017-2-25
 * qq群593802274
 */
@Component
@Path("/")
public class UserService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/test")
    public Response findUser( ) {
        User user=new User();
        user.setId(1);
        user.setName("小王");
        return Response.status(200).entity(user).build();
    }


}
