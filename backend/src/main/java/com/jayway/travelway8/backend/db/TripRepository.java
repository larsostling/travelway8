package com.jayway.travelway8.backend.db;

import com.jayway.travelway8.backend.model.Trip;

import java.util.Collection;

public interface TripRepository {
    void addTrip(Trip trip);
    Trip getTripByName(String tripName);
    Collection<Trip> getAllTrips();
}
