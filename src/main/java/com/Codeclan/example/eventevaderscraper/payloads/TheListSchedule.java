package com.Codeclan.example.eventevaderscraper.payloads;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TheListSchedule {

    private String place_id;

    public TheListSchedule(String place_id) {
        this.place_id = place_id;
    }

    public TheListSchedule() {
    }

    public String getPlace_id() {
        return place_id;
    }

    public void setPlace_id(String place_id) {
        this.place_id = place_id;
    }
}
