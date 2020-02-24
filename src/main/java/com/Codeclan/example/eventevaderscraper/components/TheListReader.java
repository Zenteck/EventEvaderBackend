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

        ObjectMapper objectMapper = new ObjectMapper();

        List<TheListEvent> allEvents = new ArrayList<>();

//        for each venue in DB, call out for all events matching place_id
        ArrayList<String> placeIds = new ArrayList<>();
        List<Venue> venues = venueRepository.findAll();
        for (Venue venue : venues){
            String placeId = venue.getPlaceId();
            placeIds.add(placeId);
        }

        for (String placeId : placeIds){
            String eventsResponse = eventClient.requestEventsByPlaceId(placeId);


            TheListEvent[] foundEvents = objectMapper.readValue(eventsResponse, TheListEvent[].class);
            for (TheListEvent event : foundEvents) {
                allEvents.add(event);
            }
        }

//        for each event received, make an event object and save it.
        for (TheListEvent listEvent : allEvents){

            String placeId = listEvent.getPlaceId();
            List<Venue> venueByPlaceId = venueRepository.findByPlaceId(placeId);
            Venue venue = venueByPlaceId.get(0);
                   String date = listEvent.getStartTime();
                   String startTime = listEvent.getStartTime();
                   String title =  listEvent.getName();
            Event eventObject = new Event(date, startTime, title, venue);
            eventRepository.save(eventObject);
            System.out.println(eventObject.getVenue().getPlaceId());

        }
    }


}