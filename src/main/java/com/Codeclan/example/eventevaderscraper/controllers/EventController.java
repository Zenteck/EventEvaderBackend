package com.Codeclan.example.eventevaderscraper.controllers;

import com.Codeclan.example.eventevaderscraper.models.Event;
import com.Codeclan.example.eventevaderscraper.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
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
        return new ResponseEntity<>(eventRepository.findById(id), HttpStatus.FOUND);
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
        return new ResponseEntity<>(found, HttpStatus.OK);
    }



    @GetMapping(value = "/events/venue/{venueId}")
    public ResponseEntity<List<Event>> postEventByVenue(@PathVariable Long venueId){
            List<Event> eventsOfVenue = eventRepository.findByVenueId(venueId);
            return new ResponseEntity<>(eventsOfVenue, HttpStatus.OK);
    }

    @GetMapping(value = "/events/today")
    public ResponseEntity<List<Event>> getAllEventsToday(){
        LocalDateTime today = LocalDateTime.now();
        List<Event> todaysEvents = eventRepository.findByStartTime(today);
        return new ResponseEntity<>(todaysEvents, HttpStatus.OK);
    }

    @GetMapping(value = "/events/tomorrow")
    public ResponseEntity<List<Event>> getAllEventsTomorrow(){
        LocalDateTime tomorrow = LocalDateTime.now().plusDays(1);
        List<Event> tomorrowsEvents = eventRepository.findByStartTime(tomorrow);
        return new ResponseEntity<>(tomorrowsEvents, HttpStatus.OK);
    }

    @GetMapping(value = "/events/next7days")
    public ResponseEntity<List<Event>> getEventsNext7Days(){
        LocalDateTime startDate = LocalDateTime.now();
        LocalDateTime endDate = startDate.plusDays(7);
        List<Event> eventsInNext7Days = eventRepository.findByStartTimeBetween(startDate,endDate);
        return new ResponseEntity<>(eventsInNext7Days, HttpStatus.OK);
    }


    @GetMapping(value = "events/next30days")
    public ResponseEntity<List<Event>> getEventsNext30Days(){
        LocalDateTime startDate = LocalDateTime.now();
        LocalDateTime endDate = startDate.plusDays(30);
        List<Event> eventsInNext30Days = eventRepository.findByStartTimeBetween(startDate,endDate);
        return new ResponseEntity<>(eventsInNext30Days, HttpStatus.OK);
    }




}