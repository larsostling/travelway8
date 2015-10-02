package com.jayway.travelway8.backend.model;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

import java.util.Date;

/**
 * Created by erikchrissopoulos on 02/10/15.
 */
public class TravelImpl implements Travel {

    private Date departureDate;
    private Date returnDate;
    private final String name;

    private Location departureLocation;
    private Location returnLocation;

    private String data;

    public TravelImpl(String name){
        Validate.isTrue(StringUtils.isNotEmpty(name));
        this.name=name;
    }

    @Override
    public void setReturnDate(Date date) {
        Validate.notNull(date);
        this.returnDate = date;
    }

    @Override
    public Location getDepartureLocation() {
        return departureLocation;
    }

    @Override
    public Location getReturnLocation() {
        return returnLocation;
    }

    @Override
    public void setReturnLocation(Location location) {
        Validate.notNull(location);
        this.returnLocation = location;
    }

    @Override
    public String getData() {
        return data;
    }

    @Override
    public void setData(String data) {
        Validate.isTrue(StringUtils.isNotEmpty(data));
        this.data = data;
    }


    @Override
    public Date getDepartureDate() {
        return departureDate;
    }

    @Override
    public void setDepartureDate(Date date) {
        Validate.notNull(date);
        this.departureDate=date;

    }

    @Override
    public Date getReturnDate() {
        return returnDate;
    }


    @Override
    public void setDepartureLocation(Location location) {
        Validate.notNull(location);
        this.departureLocation=location;

    }
}
