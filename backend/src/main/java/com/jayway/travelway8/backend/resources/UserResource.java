package com.jayway.travelway8.backend.resources;

import com.codahale.metrics.annotation.Timed;
import com.jayway.travelway8.backend.db.UserRepository;
import com.jayway.travelway8.backend.model.User;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

@Path(value = "/user")
@Produces(value = MediaType.APPLICATION_JSON)
public class UserResource {

    UserRepository userRepository;

    public UserResource(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @POST
    @Timed
    public User add(User user) {
        userRepository.addUser(user);
        return userRepository.getUserByName(user.getPassportName());
    }

    @GET
    @Timed
    public Collection<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

}
