package com.lumenagile.mapafinal.models;

/**
 * Created by ludk on 28/11/15.
 */
public class MyLocation {

    public String longitude;

    public String latitude;

    public String time;

    public MyLocation() {
    }

    public MyLocation(String latitude, String longitude, String time) {
        this.time = time;
        this.longitude = longitude;
        this.latitude = latitude;
    }
}
