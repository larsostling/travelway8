package com.jayway.travelway8.backend.resources;

import com.codahale.metrics.annotation.Timed;
import com.jayway.travelway8.backend.db.TripRepository;
import com.jayway.travelway8.backend.model.Trip;
import com.jayway.travelway8.backend.model.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

@Path(value = "/trip")
@Produces(value = MediaType.APPLICATION_JSON)
public class TripResource {

    private TripRepository tripRepository;

    public TripResource(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    @POST
    @Timed
    public Trip add(Trip trip) {
        tripRepository.addTrip(trip);
        return tripRepository.getTripByName(trip.getName());
    }

    @POST
    @Path("{tripName}/user")
    @Timed
    public void addTraveler(@PathParam(value = "tripName") String tripName, User user) {
        // add traveller to trip
    }

    @GET
    @Timed
    public Collection<Trip> getTrips() {
        return tripRepository.getAllTrips();
    }

}
