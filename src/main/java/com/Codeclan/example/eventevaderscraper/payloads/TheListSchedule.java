package com.Codeclan.example.eventevaderscraper.payloads;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TheListSchedule {

    private String place_id;

    private String start_ts;

    private String end_ts;

    private String place_name;

    private String town;

    private String postal_code;

    private double lat;

    private double lng;

    public TheListSchedule(String place_id, String start_ts, String end_ts, String place_name, String town, String postal_code, double lat, double lng) {
        this.place_id = place_id;
        this.start_ts = start_ts;
        this.end_ts = end_ts;
        this.place_name = place_name;
        this.town = town;
        this.postal_code = postal_code;
        this.lat = lat;
        this.lng = lng;
    }

    public TheListSchedule() {
    }

    public String getPlace_id() {
        return place_id;
    }

    public void setPlace_id(String place_id) {
        this.place_id = place_id;
    }

    public String getStart_ts() {
        return start_ts;
    }

    public void setStart_ts(String start_ts) {
        this.start_ts = start_ts;
    }

    public String getEnd_ts() {
        return end_ts;
    }

    public void setEnd_ts(String end_ts) {
        this.end_ts = end_ts;
    }

    public String getPlace_name() {
        return place_name;
    }

    public void setPlace_name(String place_name) {
        this.place_name = place_name;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }
}
