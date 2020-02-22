package com.Codeclan.example.eventevaderscraper.components;

import com.Codeclan.example.eventevaderscraper.clients.EventClient;
import com.Codeclan.example.eventevaderscraper.payloads.TheListEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class TheListReader {

    @Autowired
    EventClient eventClient;

        public TheListEvent[] getEvents() throws JsonProcessingException {

            String eventsResponse = eventClient.requestEvents();

        ObjectMapper objectMapper = new ObjectMapper();

            TheListEvent[] eventsList = objectMapper.readValue(eventsResponse, TheListEvent[].class);
                    for (TheListEvent event : eventsList){
                        System.out.println(event);
                    }
            return eventsList;
    }

}

//    private String event_id;
//    private String name;
//    private List<String> tags;
//    private String place_id;
//    private String start_ts;
//    private String end_ts;
//    private String place_name;
//    private String town;
//    private String postal_code;
//    private double lat;
//    private double lng;
//    private int performance_count;
