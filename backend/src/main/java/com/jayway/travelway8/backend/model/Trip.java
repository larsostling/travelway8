package com.jayway.travelway8.backend.model;

import java.time.Duration;
import java.util.Date;
import java.util.List;

/**
 * Created by erikchrissopoulos on 02/10/15.
 */
public interface Trip {
    String getName();

    public List<User> getTravelers();

    public void addTraveler(User user);

    public void removeTraveler(User user);

    public void addEvent(Event event);

    public List<Event> getEvents();

    public Date getStartDate();

    public void setStartDate(Date date);

    public Date getEndDate();

    public void setEndDate(Date date);

}
