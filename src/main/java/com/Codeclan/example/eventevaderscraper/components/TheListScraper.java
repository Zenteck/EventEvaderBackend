package com.Codeclan.example.eventevaderscraper.components;

import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Arrays;

public class TheListScraper {

    public static void getEvents() {

//        The second alternative allows initiating a WebClient instance with a given base URI:
//
        WebClient client1 = WebClient.create("https://api.list.co.uk/");

        WebClient.UriSpec<WebClient.RequestBodySpec> request1 = client1.method(HttpMethod.GET);

        WebClient.RequestBodySpec uri1 = client1.method(HttpMethod.GET).uri("/search?query=glasgow");



    }

}

//    Authorization: Bearer API_KEY_HERE
//    eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjoiOWRhZjc2MjAtOGEwOS00ZDY3LThkOTItOGE5Y2ViNTBhODRkIiwia2V5X2lkIjoiZDA5ZWJkZjUtYzk5My00OGY2LWEwZjgtOGZkNTg3ZDZjY2E5IiwiaWF0IjoxNTgyMjE4NjA4fQ.ghY5tAbaV8nm5Sb9gFe5B7XauQnY6_BvalWq5ARyHUY
//
//    restTemplate.getForObject(, )
//
//////     https://api.list.co.uk/v1/search
//}
