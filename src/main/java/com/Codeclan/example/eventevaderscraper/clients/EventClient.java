package com.Codeclan.example.eventevaderscraper.clients;

import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class EventClient {

    public EventClient() {
    }

    public String requestEvents(){

        String url = "https://api.list.co.uk/v1/events?location=glasgow&max_date=31/08/20";

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();

        headers.set("Authorization", "Bearer " + "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjoiOWRhZjc2MjAtOGEwOS00ZDY3LThkOTItOGE5Y2ViNTBhODRkIiwia2V5X2lkIjoiZDA5ZWJkZjUtYzk5My00OGY2LWEwZjgtOGZkNTg3ZDZjY2E5IiwiaWF0IjoxNTgyMjE4NjA4fQ.ghY5tAbaV8nm5Sb9gFe5B7XauQnY6_BvalWq5ARyHUY");

        HttpEntity request = new HttpEntity(headers);

        ResponseEntity<String> listResponse = restTemplate.exchange(url, HttpMethod.GET,request, String.class, 1);



        System.out.println(listResponse.getStatusCode());

        String response = listResponse.getBody();

        return response;
    }
}
