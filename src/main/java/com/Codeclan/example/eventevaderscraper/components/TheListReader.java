package com.Codeclan.example.eventevaderscraper.components;

import com.Codeclan.example.eventevaderscraper.clients.EventClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class TheListReader {

    @Autowired
    EventClient eventClient;

    public void getEvents() {
        ResponseEntity<String> eventsList = eventClient.requestEvents();


    }


}
