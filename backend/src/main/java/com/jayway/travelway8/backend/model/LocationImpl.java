package com.jayway.travelway8.backend.model;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

public class LocationImpl implements Location{

    private final double longitude;
    private final double lattitude;
    private final String name;

    public LocationImpl(String name, double longitude, double lattitude) {
        Validate.isTrue(StringUtils.isNotEmpty(name));
        this.longitude=longitude;
        this.lattitude=lattitude;
        this.name=name;
    }

    @Override
    public double getLongitude() {
        return longitude;
    }

    @Override
    public double getLattitude() {
        return lattitude;
    }

    @Override
    public String getName() {
        return name;
    }
}
