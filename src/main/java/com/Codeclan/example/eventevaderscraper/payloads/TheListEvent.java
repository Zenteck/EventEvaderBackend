package com.Codeclan.example.eventevaderscraper.payloads;


import java.util.List;

public class TheListEvent {

    private String event_id;

    private String name;

    private List<String> tags;

    private String place_id;

    private String start_ts;

    private String end_ts;

    private String place_name;

    private String town;

    private String postal_code;

    private double lat;

    private double lng;

    private int performance_count;

    public TheListEvent(String event_id, String name, List<String> tags, String place_id, String start_ts, String end_ts, String place_name, String town, String postal_code, double lat, double lng, int performance_count) {
        this.event_id = event_id;
        this.name = name;
        this.tags = tags;
        this.place_id = place_id;
        this.start_ts = start_ts;
        this.end_ts = end_ts;
        this.place_name = place_name;
        this.town = town;
        this.postal_code = postal_code;
        this.lat = lat;
        this.lng = lng;
        this.performance_count = performance_count;
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

    public int getPerformance_count() {
        return performance_count;
    }

    public void setPerformance_count(int performance_count) {
        this.performance_count = performance_count;
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