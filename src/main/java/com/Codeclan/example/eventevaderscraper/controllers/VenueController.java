package com.Codeclan.example.eventevaderscraper.controllers;

import com.Codeclan.example.eventevaderscraper.models.Venue;
import com.Codeclan.example.eventevaderscraper.repositories.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VenueController {

    @Autowired
    VenueRepository venueRepository;



    @GetMapping(value = "/venues")
    public ResponseEntity<List<Venue>> getAllVenues(){
        return new ResponseEntity<>(venueRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/venues/{id}")
    public ResponseEntity getVenue(@PathVariable Long id){
        return new ResponseEntity<>(venueRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/venues")
    public ResponseEntity<Venue> createVenue(@RequestBody Venue venue){
        venueRepository.save(venue);
        return new ResponseEntity<>(venue, HttpStatus.CREATED);
    }

    @PatchMapping(value = "/venues/{id}")
    public ResponseEntity<Venue> updateVenue(@RequestBody Venue venue){
        venueRepository.save(venue);
        return new ResponseEntity<>(venue, HttpStatus.OK);
    }

    @DeleteMapping(value = "/venues/{id}")
    public ResponseEntity<Venue> deleteVenue(@PathVariable Long id) {
        Venue found = venueRepository.getOne(id);
        venueRepository.delete(found);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }





}
