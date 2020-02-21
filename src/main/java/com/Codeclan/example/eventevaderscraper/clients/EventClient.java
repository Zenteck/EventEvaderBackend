package com.Codeclan.example.eventevaderscraper.clients;

import com.Codeclan.example.eventevaderscraper.models.Event;
import com.Codeclan.example.eventevaderscraper.payloads.TheListEvent;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class EventClient {

    public EventClient() {
    }

    public List<TheListEvent> requestEvents(){

        String url = "https://api.list.co.uk/search?query=glasgow";

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();

        headers.set("Authorization: Bearer", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjoiOWRhZjc2MjAtOGEwOS00ZDY3LThkOTItOGE5Y2ViNTBhODRkIiwia2V5X2lkIjoiZDA5ZWJkZjUtYzk5My00OGY2LWEwZjgtOGZkNTg3ZDZjY2E5IiwiaWF0IjoxNTgyMjE4NjA4fQ.ghY5tAbaV8nm5Sb9gFe5B7XauQnY6_BvalWq5ARyHUY");

        HttpEntity request = new HttpEntity(headers);

        ResponseEntity<List<TheListEvent>> response = restTemplate.exchange(url, HttpMethod.GET,request, List<TheListEvent>.class, 1);

        return response;

    }
}
