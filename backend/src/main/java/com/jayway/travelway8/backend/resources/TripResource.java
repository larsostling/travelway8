package com.jayway.travelway8.backend.resources;

import com.codahale.metrics.annotation.Timed;
import com.jayway.travelway8.backend.model.Trip;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path(value = "/trip")
@Produces(value = MediaType.APPLICATION_JSON)
public class TripResource {

    @POST
    @Timed
    public Trip add(Trip trip) {
        return trip;
    }
}
