package com.Codeclan.example.eventevaderscraper.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

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

        public Event(String date, String startTime, String title, Venue venue) {
            this.date = date;
            this.startTime = startTime;
            this.title = title;
            this.venue = venue;
        }

        public Event() {
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
            return venue;
        }

        public void setVenue(Venue venue) {
            this.venue = venue;
        }

    }
