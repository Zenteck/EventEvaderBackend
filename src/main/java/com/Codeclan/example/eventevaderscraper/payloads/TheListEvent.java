package com.Codeclan.example.eventevaderscraper.payloads;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TheListEvent {


    private String event_id;

    private String name;

    private List<String> tags;

    private ArrayList<TheListSchedule> schedules;

    public TheListEvent(String event_id, String name, List<String> tags, ArrayList<TheListSchedule> schedules) {
        this.event_id = event_id;
        this.name = name;
        this.tags = tags;
        this.schedules = schedules;
    }

    public TheListEvent() {
    }

    public String getEvent_id() {
        return event_id;
    }

    public void setEvent_id(String event_id) {
        this.event_id = event_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public ArrayList<TheListSchedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(ArrayList<TheListSchedule> schedules) {
        this.schedules = schedules;
    }


//    Schedule getters

    public String getPlaceId(){
       return this.schedules.get(0).getPlace_id();
    }

    public String getStartTime(){
        return this.schedules.get(0).getStart_ts();
    }

    public String getTown(){
        return this.schedules.get(0).getTown();
    }

    public String getPostcode(){
        return this.schedules.get(0).getPostal_code();
    }

    public double getLat(){
        return this.schedules.get(0).getLat();
    }

    public double getLng(){
        return this.schedules.get(0).getLng();
    }







}


//{
//        "event_id": "9654b832-ebf5-d79d-887e-a4e500175a3a",
//        "name": "Glasgow Green - the story of Glasgow's oldest public park",
//        "tags": [
//        "talks & lectures",
//        "kids"
//        ],
//        "place_id": "1030eadd-4f1e-b60e-65e0-bcc400004e9d",
//        "start_ts": "2020-02-27T18:00:00.000Z",
//        "end_ts": "2020-02-27T18:00:00.000Z",
//        "place_name": "Bridgeton Library",
//        "town": "Glasgow",
//        "postal_code": "G40 2QH",
//        "lat": "55.84945",
//        "lng": "-4.22633",
//        "performance_count": 1
//        }