package com.jayway.travelway8.backend.model;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

import java.util.*;

/**
 * Created by erikchrissopoulos on 02/10/15.
 */
public class Trip {
    private final List<User> participants =new ArrayList<>();
    private final List<Travel> travels=new ArrayList<>();
    private final Map<Travel,User> travelers=new HashMap<>();

    private final String name;

    private Date startDate;
    private Date endDate;

    private Location location;

    private final List<Event> events=new ArrayList<>();

    public Trip(String name) {
        Validate.isTrue(StringUtils.isNotEmpty(name));
        this.name=name;
    }


    public String getName(){
        return name;
    }


    public Map<Travel,User> getTravelers() {
        return travelers;
    }


    public List<User> getParticipants() {
        return participants;
    }


    public void addParticipant(User user) {
        Validate.notNull(user);
        participants.add(user);
    }


    public void removeParticipant(User user) {
        Validate.notNull(user);
        participants.remove(user);
    }


    public void addEvent(Event event) {
        Validate.notNull(event);
        events.add(event);
    }


    public List<Event> getEvents() {
        return events;
    }


    public Date getStartDate() {
        return startDate;
    }


    public void setStartDate(Date date) {
        Validate.notNull(date);
        startDate=date;
    }


    public Date getEndDate() {
        return endDate;
    }


    public void setEndDate(Date date) {
        Validate.notNull(date);
        endDate=date;

    }


    public Location getDestination() {
        return location;
    }


    public void setDestination(Location location) {
        Validate.notNull(location);
        this.location=location;
    }


    public void addTravel(Travel travel) {
        Validate.notNull(travel);
        travels.add(travel);


    }


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
