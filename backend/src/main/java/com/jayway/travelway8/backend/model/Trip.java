package com.jayway.travelway8.backend.model;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by erikchrissopoulos on 02/10/15.
 */
public interface Trip {
    String getName();

    public Map<Travel,User> getTravelers();

    public List<User> getParticipants();

    public void addParticipant(User user);

    public void removeParticipant(User user);

    public void addEvent(Event event);

    public List<Event> getEvents();

    public Date getStartDate();

    public void setStartDate(Date date);

    public Date getEndDate();

    public void setEndDate(Date date);

    Location getDestination();

    void setDestination(Location location);

    void addTravel(Travel travel);

    void setUserTravel(User user, Travel travel);



}
