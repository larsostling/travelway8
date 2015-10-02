package com.jayway.travelway8.backend.model;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

import java.util.Date;

/**
 * Created by erikchrissopoulos on 02/10/15.
 */
public class Travel {

    private Date departureDate;
    private Date returnDate;
    private final String name;

    private Location departureLocation;
    private Location returnLocation;

    private String data;

    public Travel(String name){
        Validate.isTrue(StringUtils.isNotEmpty(name));
        this.name=name;
    }

    public Travel() {
        name="";
    }

    public void setReturnDate(Date date) {
        //Validate.notNull(date);
        this.returnDate = date;
    }


    public Location getDepartureLocation() {
        return departureLocation;
    }


    public Location getReturnLocation() {
        return returnLocation;
    }


    public void setReturnLocation(Location location) {
        //Validate.notNull(location);
        this.returnLocation = location;
    }


    public String getData() {
        return data;
    }


    public void setData(String data) {
        Validate.isTrue(StringUtils.isNotEmpty(data));
        this.data = data;
    }



    public Date getDepartureDate() {
        return departureDate;
    }


    public void setDepartureDate(Date date) {
        //Validate.notNull(date);
        this.departureDate=date;

    }


    public Date getReturnDate() {
        return returnDate;
    }



    public void setDepartureLocation(Location location) {
        //Validate.notNull(location);
        this.departureLocation=location;

    }
}
