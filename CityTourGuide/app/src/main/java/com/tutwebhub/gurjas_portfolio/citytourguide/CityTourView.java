package com.tutwebhub.gurjas_portfolio.citytourguide;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by gurjas on 30-06-2017.
 */

public class CityTourView {

    private String cityName, locationName;

    public CityTourView(String cityName, String locationName)
    {
        this.cityName = cityName;
        this.locationName = locationName;
    }

    public String getCityName()
    {
        return cityName;
    }

    public String getLocationName()
    {
        return locationName;
    }
}
