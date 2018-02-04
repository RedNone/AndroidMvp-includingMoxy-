package com.example.rednone.androidmvpincludingmoxy.DataLayer.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by RedNone on 24.12.2017.
 */
public class GeoModel {

    @SerializedName("lat")
    @Expose
    private String lat;
    @SerializedName("lng")
    @Expose
    private String lng;

    /**
     * No args constructor for use in serialization
     *
     */
    public GeoModel() {
    }

    /**
     *
     * @param lng
     * @param lat
     */
    public GeoModel(String lat, String lng) {
        super();
        this.lat = lat;
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

}