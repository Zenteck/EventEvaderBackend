package com.Codeclan.example.eventevaderscraper.controllers;

import com.Codeclan.example.eventevaderscraper.models.Event;
import com.Codeclan.example.eventevaderscraper.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
public class    EventController {

    @Autowired
    EventRepository eventRepository;

    @GetMapping(value = "/events")
    public ResponseEntity<List<Event>> getAllEvents(){
        return new ResponseEntity<>(eventRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/events/{id}")
    public ResponseEntity getEvent(@PathVariable Long id){
        return new ResponseEntity<>(eventRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/events")
    public ResponseEntity<Event> createEvent(@RequestBody Event event){
        eventRepository.save(event);
        return new ResponseEntity<>(event, HttpStatus.CREATED);
    }

    @PatchMapping(value = "/events/{id}")
    public ResponseEntity<Event> updateEvent(@RequestBody Event event){
        eventRepository.save(event);
        return new ResponseEntity<>(event, HttpStatus.OK);
    }

    @DeleteMapping(value = "/events/{id}")
    public ResponseEntity<Event> deleteEvent(@PathVariable Long id) {
        Event found = eventRepository.getOne(id);
        eventRepository.delete(found);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping(value = "/event/{venueId}")
    public ResponseEntity<Event> postEventByVenue(@PathVariable Long venueId){
            List<Event> eventsOfVenue = eventRepository.findByVenueId(venueId);
            return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping(value = "/event/today")
    public ResponseEntity<Event> getAllEventsToday(){
        LocalDate today = LocalDate.now();
        List<Event> todaysEvents = eventRepository.findByDate(today);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping(value = "/events/tomorrow")
    public ResponseEntity<Event> getAllEventsTomorrow(){
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        List<Event> tomorrowsEvents = eventRepository.findByDate(tomorrow);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping(value = "/events/next7days")
    public ResponseEntity<Event> getEventsNext7Days(){
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.plusDays(7);
        List<Event> eventsInNext7Days = eventRepository.findByDateBetween(startDate,endDate);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }


}