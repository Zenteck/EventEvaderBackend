package com.Codeclan.example.eventevaderscraper;

import com.Codeclan.example.eventevaderscraper.clients.EventClient;
import com.Codeclan.example.eventevaderscraper.components.TheListReader;
import com.Codeclan.example.eventevaderscraper.models.Event;
import com.Codeclan.example.eventevaderscraper.models.Venue;
import com.Codeclan.example.eventevaderscraper.payloads.TheListEvent;
import com.Codeclan.example.eventevaderscraper.repositories.EventRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class EventevaderscraperApplicationTests {

	Venue celtic;


	@Autowired
	EventClient eventClient;

	@Autowired
	TheListReader theListReader;

	@Autowired
	EventRepository eventRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void canGetStringBack(){
		String response = eventClient.requestEvents();
		System.out.println(response);
	}

	@Test
	void canParseString() throws InterruptedException, JsonProcessingException {
		TheListEvent[] events = theListReader.getEvents();
	}

	@Test
	void canGetEventsByVenue(){

		List<Event> celticEvents = eventRepository.findByVenueId(2);
		assertEquals(2,celticEvents.size());
	}

	@Test
	void cangetTodaysEvents(){
		LocalDate today = LocalDate.of(2020, Month.FEBRUARY, 23);
		List<Event> todaysEvents = eventRepository.findByDate(today);
		assertEquals(2, todaysEvents.size());
	}

	@Test
	void canGetTomorrowsEvents(){
		LocalDate tomorrow = LocalDate.of(2020, Month.FEBRUARY, 24);
		List<Event> tomorrowsEvents = eventRepository.findByDate(tomorrow);
		assertEquals(1,tomorrowsEvents.size());
	}



}
