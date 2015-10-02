package com.jayway.travelway8.backend.resources;

import com.codahale.metrics.annotation.Timed;
import com.jayway.travelway8.backend.model.User;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path(value = "/user")
@Produces(value = MediaType.APPLICATION_JSON)
public class UserResource {

    @POST
    @Timed
    public User add(User user) {
        return user;
    }

}
