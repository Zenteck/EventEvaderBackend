package com.Codeclan.example.eventevaderscraper.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
    @Table(name = "events")

    public class Event implements Serializable{

        @Column(name = "date")
        private String date;

        @Column(name = "startTime")
        private String startTime;

        @Column(name = "title")
        private String title;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        @JsonIgnoreProperties(value="events")
        @ManyToOne
        @JoinColumn(name = "venue_id", nullable = false)
        private Venue venue;

        @JsonIgnoreProperties(value="events")
        @ManyToMany
        @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
        @JoinTable(
                joinColumns = {@JoinColumn(name = "event_id", nullable = false, updatable = false)},
                inverseJoinColumns = {@JoinColumn(name = "user_id", nullable = false, updatable = false)}
        )
        private List<User> users;

        public Event(String date, String startTime, String title, Venue venue) {
            this.date = date;
            this.startTime = startTime;
            this.title = title;
            this.venue = venue;
            this.users = new ArrayList<>();
        }

        public Event() {
        }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public Venue getVenue() {
            return this.venue;
        }

        public void setVenue(Venue venue) {
            this.venue = venue;
        }

    }
