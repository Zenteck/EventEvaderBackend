package com.Codeclan.example.eventevaderscraper.clients;

import com.Codeclan.example.eventevaderscraper.models.Event;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class EventClient {

    public EventClient() {
    }

    public ResponseEntity<String> requestEvents(){

        String url = "https://api.list.co.uk/v1/search?query=glasgow";

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();

        headers.set("Authorization", "Bearer " + "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjoiOWRhZjc2MjAtOGEwOS00ZDY3LThkOTItOGE5Y2ViNTBhODRkIiwia2V5X2lkIjoiZDA5ZWJkZjUtYzk5My00OGY2LWEwZjgtOGZkNTg3ZDZjY2E5IiwiaWF0IjoxNTgyMjE4NjA4fQ.ghY5tAbaV8nm5Sb9gFe5B7XauQnY6_BvalWq5ARyHUY");

        HttpEntity request = new HttpEntity(headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET,request, String.class, 1);

        System.out.println(response);

        return response;
    }

//    public Event requestEvent(){
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<String> allEvents = requestEvents();
//
//    }
}
