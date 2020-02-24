package com.Codeclan.example.eventevaderscraper.components;

import com.Codeclan.example.eventevaderscraper.clients.EventClient;
import com.Codeclan.example.eventevaderscraper.models.Event;
import com.Codeclan.example.eventevaderscraper.models.Venue;
import com.Codeclan.example.eventevaderscraper.payloads.TheListEvent;
import com.Codeclan.example.eventevaderscraper.repositories.EventRepository;
import com.Codeclan.example.eventevaderscraper.repositories.VenueRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class TheListReader {

    @Autowired
    EventClient eventClient;

    @Autowired
    EventRepository eventRepository;

    @Autowired
    VenueRepository venueRepository;


    public void getEvents() throws JsonProcessingException {

//        initialize array for payload events
        List<TheListEvent> allEvents = new ArrayList<>();

//        Declare mapper
        ObjectMapper objectMapper = new ObjectMapper();

//        declare time formatter        sample timestamp: 2020-02-29T00:00:00+00:00
        DateTimeFormatter formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME;

//         initialize array for placeids
        ArrayList<String> placeIds = new ArrayList<>();

//        pull all venues
        List<Venue> venues = venueRepository.findAll();

//       for each venue in DB, call out for all events matching place_id
        for (Venue venue : venues){
            String placeId = venue.getPlaceId();
            placeIds.add(placeId);
        }

//       for each place_id, call TheListApi and get matching events
        for (String placeId : placeIds){
            String eventsResponse = eventClient.requestEventsByPlaceId(placeId);

//       for each event make a payload event and store it in a list
            TheListEvent[] foundEvents = objectMapper.readValue(eventsResponse, TheListEvent[].class);
            for (TheListEvent event : foundEvents) {
                allEvents.add(event);
            }
        }

//       for each event received, make an Event Object and save it.
        for (TheListEvent listEvent : allEvents){

//            Prepare data for EventObject properties
            String placeId = listEvent.getPlaceId();
            List<Venue> venueByPlaceId = venueRepository.findByPlaceId(placeId);
            Venue venue = venueByPlaceId.get(0);
            LocalDateTime startTime = LocalDateTime.parse(listEvent.getStartTime(), formatter);
            String title =  listEvent.getName();

//            save an event object(finally!)
            Event eventObject = new Event(startTime, title, venue);
            eventRepository.save(eventObject);

        }
    }
}