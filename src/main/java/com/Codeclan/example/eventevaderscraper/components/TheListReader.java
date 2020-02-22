package com.Codeclan.example.eventevaderscraper.components;

import com.Codeclan.example.eventevaderscraper.clients.EventClient;
import com.Codeclan.example.eventevaderscraper.payloads.TheListEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
