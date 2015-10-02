package com.jayway.travelway8.backend.model;

import java.util.Date;

/**
 * Created by erikchrissopoulos on 02/10/15.
 */
public interface Travel {

    Location getDepartureLocation();

    Location getReturnLocation();

    void setReturnLocation(Location location);

    String getData();

    void setData(String data);

    Date getDepartureDate();
    void setDepartureDate(Date date);

    Date getReturnDate();
    void setReturnDate(Date date);

    void setDepartureLocation(Location location);

}
