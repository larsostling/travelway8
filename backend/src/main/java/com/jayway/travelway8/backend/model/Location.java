package com.jayway.travelway8.backend.model;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

public class Location{

    private final double longitude;
    private final double lattitude;
    private final String name;

    public Location(String name, double longitude, double lattitude) {
        Validate.isTrue(StringUtils.isNotEmpty(name));
        this.longitude=longitude;
        this.lattitude=lattitude;
        this.name=name;
    }

    public Location() {
        longitude=0;
        lattitude=0;
        name="";
    }

    public double getLongitude() {
        return longitude;
    }


    public double getLattitude() {
        return lattitude;
    }


    public String getName() {
        return name;
    }
}
