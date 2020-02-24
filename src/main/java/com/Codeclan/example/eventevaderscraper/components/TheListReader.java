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

    public List<TheListEvent> getEvents() throws JsonProcessingException, InterruptedException {

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
            wait(10000);

            TheListEvent[] foundEvents = objectMapper.readValue(eventsResponse, TheListEvent[].class);
            for (TheListEvent event : foundEvents) {
                System.out.println(event);
                allEvents.add(event);
            }
        }
//        for each event received, make an event object and save it.
        for (TheListEvent listEvent : allEvents){
            String placeId = listEvent.getPlace_id();
            Venue venue = venueRepository.findByPlaceId(placeId);
            Event eventObject = new Event(
                    listEvent.getStart_ts(),
                    listEvent.getEnd_ts(),
                    listEvent.getName(),
                    venue);
            eventRepository.save(eventObject);

        }
        return allEvents;
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