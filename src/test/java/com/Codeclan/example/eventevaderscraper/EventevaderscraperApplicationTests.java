package com.Codeclan.example.eventevaderscraper;

import com.Codeclan.example.eventevaderscraper.clients.EventClient;
import com.Codeclan.example.eventevaderscraper.components.TheListReader;
import com.Codeclan.example.eventevaderscraper.payloads.TheListEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class EventevaderscraperApplicationTests {


	@Autowired
	EventClient eventClient;

	@Autowired
	TheListReader theListReader;

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



}
