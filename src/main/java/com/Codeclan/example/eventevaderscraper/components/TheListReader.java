package com.Codeclan.example.eventevaderscraper.components;

import com.Codeclan.example.eventevaderscraper.clients.EventClient;
import com.Codeclan.example.eventevaderscraper.payloads.TheListEvent;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

public class TheListReader {

    @Autowired
    EventClient eventClient;

    public ArrayList<TheListEvent> getEvents() {
        String eventsResponse = eventClient.requestEvents();






    }

}
