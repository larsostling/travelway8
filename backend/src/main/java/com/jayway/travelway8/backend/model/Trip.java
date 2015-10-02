package com.jayway.travelway8.backend.model;

import java.util.List;

/**
 * Created by erikchrissopoulos on 02/10/15.
 */
public interface Trip {
    public List<User> getTravelers();

    public void addTraveler(User user);

    public void removeTraveler(User user);

}