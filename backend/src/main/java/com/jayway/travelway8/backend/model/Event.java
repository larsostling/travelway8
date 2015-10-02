package com.jayway.travelway8.backend.model;

import java.util.List;

/**
 * Created by erikchrissopoulos on 02/10/15.
 */
public interface Event {

    String getName();

    void addParticipant(User user);

    List<User> getParticipants();
}
