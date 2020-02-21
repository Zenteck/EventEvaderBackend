package com.Codeclan.example.eventevaderscraper.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")

public class User implements Serializable {


    @Column(name = "email")
    private String emailAddress;


    @JsonIgnoreProperties(value = "users")
    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            name = "users_venues",
            joinColumns = {@JoinColumn(name = "user_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name="venue_id", nullable = false, updatable = false)}
    )
    private List<Venue> venues;

    @JsonIgnoreProperties(value = "users")
    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            name = "users_events",
            joinColumns = {@JoinColumn(name = "user_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name="event_id", nullable = false, updatable = false)}
    )
    private List<Event> events;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public User(String emailAddress) {
        this.emailAddress = emailAddress;
        this.venues = new ArrayList<>();
        this.events = new ArrayList<>();
    }

    public User() {
    }


    public void addEvent(Event event){
        this.events.add(event);
    }

    public void removeEvent(Event event){
        this.events.remove(event);
    }


    public void addVenue(Venue venue){
        this.venues.add(venue);
    }

    public void removeVenue(Venue venue){
        this.venues.remove(venue);
    }


    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public List<Venue> getVenues() {
        return venues;
    }

    public void setVenues(List<Venue> venues) {
        this.venues = venues;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


}
