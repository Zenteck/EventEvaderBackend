package com.Codeclan.example.eventevaderscraper;

import com.Codeclan.example.eventevaderscraper.clients.EventClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class EventevaderscraperApplicationTests {


	@Autowired
	EventClient eventClient;

	@Test
	void contextLoads() {
	}

	@Test
	void canGetStringBack(){
		ResponseEntity<String> response = eventClient.requestEvents();
		System.out.println("hi");
		System.out.println(response);

	}

}
