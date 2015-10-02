package com.jayway.travelway8.backend.model;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

import java.util.*;

/**
 * Created by erikchrissopoulos on 02/10/15.
 */
public class TripImpl implements Trip {
    private final List<User> participants =new ArrayList<>();
    private final List<Travel> travels=new ArrayList<>();
    private final Map<Travel,User> travelers=new HashMap<>();

    private String name="";

    private Date startDate;
    private Date endDate;

    private Location location;

    private final List<Event> events=new ArrayList<>();

    public TripImpl(String name) {
        Validate.isTrue(StringUtils.isNotEmpty(name));
        this.name=name;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public Map<Travel,User> getTravelers() {
        return travelers;
    }

    @Override
    public List<User> getParticipants() {
        return participants;
    }

    @Override
    public void addParticipant(User user) {
        Validate.notNull(user);
        participants.add(user);
    }

    @Override
    public void removeParticipant(User user) {
        Validate.notNull(user);
        participants.remove(user);
    }

    @Override
    public void addEvent(Event event) {
        Validate.notNull(event);
        events.add(event);
    }

    @Override
    public List<Event> getEvents() {
        return events;
    }

    @Override
    public Date getStartDate() {
        return startDate;
    }

    @Override
    public void setStartDate(Date date) {
        Validate.notNull(date);
        startDate=date;
    }

    @Override
    public Date getEndDate() {
        return endDate;
    }

    @Override
    public void setEndDate(Date date) {
        Validate.notNull(date);
        endDate=date;

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
    public void addTravel(Travel travel) {
        Validate.notNull(travel);
        travels.add(travel);


    }

    @Override
    public void setUserTravel(User user, Travel travel) {
        Validate.notNull(user);
        Validate.notNull(travel);
        if(!travels.contains(travel)){
            travels.add(travel);
        }
        if(!participants.contains(user)){
            participants.add(user);
        }
        travelers.put(travel,user);

    }
}
