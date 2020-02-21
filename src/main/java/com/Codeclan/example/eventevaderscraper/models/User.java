package com.Codeclan.example.eventevaderscraper.models;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;

@Entity
@Table(name = "users")

public class User implements Serializable {


    @Column(name = "email")
    private String emailAddress;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private ArrayList<Venue> venues;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private ArrayList<Event> events;

    public User(String emailAddress) {
        this.emailAddress = emailAddress;
        this.venues = new ArrayList<>();
        this.events = new ArrayList<>();
    }

    public User() {
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public ArrayList<Venue> getVenues() {
        return venues;
    }

    public void setVenues(ArrayList<Venue> venues) {
        this.venues = venues;
    }

    public ArrayList<Event> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<Event> events) {
        this.events = events;
    }
}
