package com.jayway.travelway8.backend.db;

import com.jayway.travelway8.backend.model.Trip;
import com.jayway.travelway8.backend.model.TripImpl;
import org.jvnet.hk2.annotations.Service;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class InMemoryTripRepository implements TripRepository {

    private Map<String, Trip> cache = new ConcurrentHashMap<>();

    public InMemoryTripRepository() {
        // Add dummy data
        addTrip(new TripImpl("Toledo"));
        addTrip(new TripImpl("Barcelona"));
    }

    @Override
    public void addTrip(Trip trip) {
        cache.put(trip.getName(), trip);
    }

    @Override
    public Trip getTripByName(String tripName) {
        return cache.get(tripName);
    }

    @Override
    public Collection<Trip> getAllTrips() {
        return cache.values();
    }
}
