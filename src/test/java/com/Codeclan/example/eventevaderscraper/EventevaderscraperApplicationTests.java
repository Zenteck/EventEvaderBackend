package com.Codeclan.example.eventevaderscraper;

import com.Codeclan.example.eventevaderscraper.clients.EventClient;
import com.Codeclan.example.eventevaderscraper.components.TheListReader;
import com.Codeclan.example.eventevaderscraper.models.Venue;
import com.Codeclan.example.eventevaderscraper.payloads.TheListEvent;
import com.Codeclan.example.eventevaderscraper.repositories.EventRepository;
import com.Codeclan.example.eventevaderscraper.repositories.VenueRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class EventevaderscraperApplicationTests {


	@Autowired
	EventClient eventClient;

	@Autowired
	TheListReader theListReader;

	@Autowired
	VenueRepository venueRepository;

	@Autowired
	EventRepository eventRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void canGetStringBack(){
		String response = eventClient.requestEventsByPlaceId("b940eadd-4f1e-b60e-85e0-bcc40000356f");
//		Passing Celtic Park place_id
		System.out.println(response);
	}

	@Test
	void canParseString() throws JsonProcessingException, InterruptedException {
		List<TheListEvent> events = theListReader.getEvents();
	}

	@Test
	void canGetVenuesLocally(){
		List<Venue> venues = venueRepository.findAll();
		System.out.println(venues);
	}

	@Test
	void canGetPlaceIds(){
		List<Venue> venues = venueRepository.findAll();
		for(Venue venue : venues){
			System.out.println(venue.getPlaceId());
		}
	}



}
