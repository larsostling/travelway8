package com.jayway.travelway8.backend.model;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by erikchrissopoulos on 02/10/15.
 */
public class Event {
    private final String name;
    private final List<User> participants=new ArrayList<>();
    private Location location;

    public Event(String name){
        Validate.isTrue(StringUtils.isNotEmpty(name));
        this.name=name;
    }


    public String getName(){
        return name;
    }



    public void addParticipant(User user){
        Validate.notNull(user);
        participants.add(user);
    }


    public List<User> getParticipants(){
        return participants;
    }


    public Location getLocation() {
        return location;
    }


    public void setLocation(Location location) {
       Validate.notNull(location);
        this.location=location;

    }


    public void removeParticipant(User user) {
        Validate.notNull(user);
        participants.remove(user);
    }

}
