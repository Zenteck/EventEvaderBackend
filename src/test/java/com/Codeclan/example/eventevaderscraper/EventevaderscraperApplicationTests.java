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
		LocalDate today = LocalDate.now();
		List<Event> todaysEvents = eventRepository.findByDate(today);
		assertEquals(2, todaysEvents.size());
	}

	@Test
	void canGetTomorrowsEvents(){
		LocalDate tomorrow = LocalDate.now().plusDays(1);
		List<Event> tomorrowsEvents = eventRepository.findByDate(tomorrow);
		assertEquals(1,tomorrowsEvents.size());
	}

	/* findByDateBetween() is inclusive of the start and end date. eg If start is Monday and an end date is on Sunday,
	Sundays and Mondays events are included */
	@Test
	void canGetNext7DaysEvents(){
		LocalDate startDate = LocalDate.now();
		LocalDate endDate = LocalDate.now().plusDays(7);
		List<Event> eventsWithin7Days = eventRepository.findByDateBetween(startDate,endDate);
		assertEquals(5,eventsWithin7Days.size());
	}

	@Test
	void canGetNext30DaysEvents(){
		LocalDate startDate = LocalDate.now();
		LocalDate endDate = LocalDate.now().plusDays(30);
		List<Event> eventsWithin30Days = eventRepository.findByDateBetween(startDate,endDate);
		assertEquals(7,eventsWithin30Days.size());
	}


}
