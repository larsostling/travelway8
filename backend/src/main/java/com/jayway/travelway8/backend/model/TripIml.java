package com.jayway.travelway8.backend.model;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by erikchrissopoulos on 02/10/15.
 */
public class TripIml implements Trip {
    private final List<User> travelers=new ArrayList<User>();
    private final String name="";

    public TripIml(String name) {
        Validate.isTrue(StringUtils.isNotEmpty(name));
        name=name;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public List<User> getTravelers() {
        return travelers;
    }

    @Override
    public void addTraveler(User user) {
        Validate.notNull(user);
        travelers.add(user);
    }

    @Override
    public void removeTraveler(User user) {
        Validate.notNull(user);
        travelers.remove(user);
    }
}
