package com.jayway.travelway8.backend.model;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by erikchrissopoulos on 02/10/15.
 */
public class EventImpl implements Event {
    private final String name;
    private final List<User> participants=new ArrayList<>();
    private Location location;

    public EventImpl(String name){
        Validate.isTrue(StringUtils.isNotEmpty(name));
        this.name=name;
    }

    @Override
    public String getName(){
        return name;
    }


    @Override
    public void addParticipant(User user){
        Validate.notNull(user);
        participants.add(user);
    }

    @Override
    public List<User> getParticipants(){
        return participants;
    }

    @Override
    public Location getLocation() {
        return location;
    }

    @Override
    public void setLocation(Location location) {
       Validate.notNull(location);
        this.location=location;

    }

    @Override
    public void removeParticipant(User user) {
        Validate.notNull(user);
        participants.remove(user);
    }

}
